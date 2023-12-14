package com.conquestreforged.content.blocks.block;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.base.WaterloggedShape;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

@Assets(
        state = @State(name = "%s_slab", template = "parent_slab_lesslayers"),
        item = @Model(name = "item/%s_slab", parent = "block/%s_slab_bottom_4", template = "item/acacia_slab"),
        block = {
                @Model(name = "block/%s_slab_bottom_1", template = "block/parent_slab_bottom_1"),
                @Model(name = "block/%s_slab_bottom_2", template = "block/parent_slab_bottom_2"),
                @Model(name = "block/%s_slab_bottom_4", template = "block/parent_slab_bottom_4"),
                @Model(name = "block/%s_slab_bottom_6", template = "block/parent_slab_bottom_6"),
                @Model(name = "block/%s_slab_top_1", template = "block/parent_slab_top_1"),
                @Model(name = "block/%s_slab_top_2", template = "block/parent_slab_top_2"),
                @Model(name = "block/%s_slab_top_4", template = "block/parent_slab_top_4"),
                @Model(name = "block/%s_slab_top_6", template = "block/parent_slab_top_6"),
        }
)
public class SlabLessLayers extends WaterloggedShape {

    public static final IntProperty LAYERS = IntProperty.of("layer", 1, 4);

    public static final EnumProperty<BlockHalf> TYPE_UPDOWN = EnumProperty.of("type", BlockHalf.class);
    private Block fullBlock;

    public SlabLessLayers(Props props) {
        super(props.toSettings());
        this.fullBlock = props.getParent().getBlock();
        this.setDefaultState((this.stateManager.getDefaultState()).with(TYPE_UPDOWN, BlockHalf.BOTTOM).with(WATERLOGGED, false));
    }

    @Override
    public boolean hasSidedTransparency(BlockState state) {
        return true;
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        Direction facing = context.getSide();
        if (state.get(TYPE_UPDOWN) == BlockHalf.BOTTOM) {
            return facing == Direction.UP;
        } else {
            return facing == Direction.DOWN;
        }
    }

    @Override
    public boolean isTranslucent(BlockState p_200123_1_, BlockView p_200123_2_, BlockPos p_200123_3_) {
        return false;
    }


    @Override
    public VoxelShape getShape(BlockState state) {
        if (state.get(TYPE_UPDOWN) == BlockHalf.TOP) {
            switch (state.get(LAYERS)) {
                case 1: return Slab.TOP_SHAPE[0];
                case 2: return Slab.TOP_SHAPE[1];
                case 3: return Slab.TOP_SHAPE[3];
                default: return Slab.TOP_SHAPE[5];
            }
        } else {
            switch (state.get(LAYERS)) {
                case 1: return Slab.BOTTOM_SHAPE[0];
                case 2: return Slab.BOTTOM_SHAPE[1];
                case 3: return Slab.BOTTOM_SHAPE[3];
                default: return Slab.BOTTOM_SHAPE[5];
            }
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockPos blockpos = context.getBlockPos();
        BlockState state = context.getWorld().getBlockState(context.getBlockPos());
        if (state.getBlock() == this) {
            int i = state.get(LAYERS);
            if (i == 4) {
                return fullBlock.getDefaultState();
            }
            return state.with(LAYERS, Math.min(7, i + 1));
        } else {
            FluidState fluid = context.getWorld().getFluidState(context.getBlockPos());
            BlockState state2 = this.getDefaultState().with(TYPE_UPDOWN, BlockHalf.BOTTOM).with(WATERLOGGED, fluid.getFluid() == Fluids.WATER);

            Direction facing = context.getSide();
            return facing != Direction.DOWN && (facing == Direction.UP || !(context.getHitPos().y - (double) blockpos.getY() > 0.5D)) ? state2 : state2.with(TYPE_UPDOWN, BlockHalf.TOP);
        }
    }

    @Override
    protected void addProperties(StateManager.Builder<Block, BlockState> container) {
        container.add(TYPE_UPDOWN).add(LAYERS);
    }
}