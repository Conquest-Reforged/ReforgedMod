package com.conquestreforged.blocks.block.food;

import com.conquestreforged.blocks.block.directional.HorizontalDirectional;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

@Render(RenderLayer.CUTOUT)
public class Tankard extends HorizontalDirectional {

    public static final IntegerProperty TANKARDS = IntegerProperty.create("tankards", 1, 2);

    public Tankard(Props properties) {
        super(properties);
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return context.getItemInHand().getItem() == this.asItem() && state.getValue(TANKARDS) < 2 ? true : super.canBeReplaced(state, context);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos());
        if (blockstate.getBlock() == this) {
            return blockstate.setValue(TANKARDS, Integer.valueOf(Math.min(4, blockstate.getValue(TANKARDS) + 1)));
        } else {
            return super.getStateForPlacement(context);
        }
    }

    //@Override
    //public Vec3d getOffset(BlockState state, IBlockReader worldIn, BlockPos pos) {
    //    if (state.get(TANKARDS) > 1) {
    //        return Vec3d.ZERO;
    //    } else {
    //        long i = MathHelper.getCoordinateRandom(pos.getX(), 0, pos.getZ());
    //        return new Vec3d(((double)((float)(i & 15L) / 15.0F) - 0.5D) * 0.5D, 0.0D, ((double)((float)(i >> 8 & 15L) / 15.0F) - 0.5D) * 0.5D);
    //    }
    //}

    @Override
    protected void addProperties(StateDefinition.Builder<Block, BlockState> container) {
        container.add(TANKARDS);
    }
}
