package com.conquestreforged.blocks.block;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.base.WaterloggedShape;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.VoxelShape;

@Assets(
        state = @State(name = "%s_slab", template = "parent_slab_basic"),
        item = @Model(name = "item/%s_slab", parent = "block/%s_slab_bottom_4", template = "item/acacia_slab"),
        block = {
                @Model(name = "block/%s_slab_bottom_4", template = "block/parent_slab_bottom_4"),
                @Model(name = "block/%s_slab_top_4", template = "block/parent_slab_top_4"),
        }
)
public class SlabBasic extends WaterloggedShape {

    public static final EnumProperty<Half> TYPE_UPDOWN = EnumProperty.create("type", Half.class);

    public SlabBasic(Props props) {
        super(props.toProperties());
        this.registerDefaultState((this.stateDefinition.any()).setValue(TYPE_UPDOWN, Half.BOTTOM).setValue(WATERLOGGED, false));
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }


    @Override
    public boolean propagatesSkylightDown(BlockState p_200123_1_, BlockGetter p_200123_2_, BlockPos p_200123_3_) {
        return false;
    }


    @Override
    public VoxelShape getShape(BlockState state) {
        if (state.getValue(TYPE_UPDOWN) == Half.TOP) {
            return Slab.TOP_SHAPE[3];
        } else {
            return Slab.BOTTOM_SHAPE[3];
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
        BlockState state2 = this.defaultBlockState().setValue(TYPE_UPDOWN, Half.BOTTOM).setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);
        Direction facing = context.getClickedFace();
        return facing != Direction.DOWN && (facing == Direction.UP || !(context.getClickLocation().y - (double) blockpos.getY() > 0.5D)) ? state2 : state2.setValue(TYPE_UPDOWN, Half.TOP);
    }

    @Override
    protected void addProperties(StateDefinition.Builder<Block, BlockState> container) {
        container.add(TYPE_UPDOWN);
    }
}