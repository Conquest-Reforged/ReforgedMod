package com.conquestreforged.content.blocks.block.food;

import com.conquestreforged.content.blocks.block.directional.HorizontalDirectional;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;

@Render(RenderLayer.CUTOUT)
public class Tankard extends HorizontalDirectional {

    public static final IntProperty TANKARDS = IntProperty.of("tankards", 1, 2);

    public Tankard(Props properties) {
        super(properties);
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        return context.getStack().getItem() == this.asItem() && state.get(TANKARDS) < 2 ? true : super.canReplace(state, context);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockState blockstate = context.getWorld().getBlockState(context.getBlockPos());
        if (blockstate.getBlock() == this) {
            return blockstate.with(TANKARDS, Integer.valueOf(Math.min(4, blockstate.get(TANKARDS) + 1)));
        } else {
            return super.getPlacementState(context);
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
    protected void addProperties(StateManager.Builder<Block, BlockState> container) {
        container.add(TANKARDS);
    }
}
