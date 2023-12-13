package com.conquestreforged.blocks.block;

import com.conquestreforged.blocks.block.util.PlacementHelper;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.base.WaterloggedHorizontalDirectionalShape;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.VoxelShape;

@Assets(
        state = @State(name = "%s_quarter_slab", template = "parent_slab_quarter"),
        item = @Model(name = "item/%s_quarter_slab", parent = "block/%s_slab_quarter_4", template = "item/parent_slab_quarter"),
        block = {
                @Model(name = "block/%s_slab_quarter_2", template = "block/parent_slab_quarter_2"),
                @Model(name = "block/%s_slab_quarter_4", template = "block/parent_slab_quarter_4"),
                @Model(name = "block/%s_slab_quarter_6", template = "block/parent_slab_quarter_6"),
                @Model(name = "block/%s_slab_quarter_2_top", template = "block/parent_slab_quarter_2_top"),
                @Model(name = "block/%s_slab_quarter_4_top", template = "block/parent_slab_quarter_4_top"),
                @Model(name = "block/%s_slab_quarter_6_top", template = "block/parent_slab_quarter_6_top")
        }
)
public class SlabQuarter extends WaterloggedHorizontalDirectionalShape {

    public static final IntegerProperty LAYERS = IntegerProperty.create("layer", 1, 3);


    public static final EnumProperty<Half> TYPE_UPDOWN = EnumProperty.create("type", Half.class);
    public static final VoxelShape[] BOTTOM_SOUTH_SHAPE = new VoxelShape[]{Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 4.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 12.0D)};
    public static final VoxelShape[] BOTTOM_NORTH_SHAPE = new VoxelShape[]{Block.box(0.0D, 0.0D, 12.0D, 16.0D, 4.0D, 16.0D), Block.box(0.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D), Block.box(0.0D, 0.0D, 4.0D, 16.0D, 12.0D, 16.0D)};
    public static final VoxelShape[] BOTTOM_WEST_SHAPE = new VoxelShape[]{Block.box(12.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.box(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(4.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D)};
    public static final VoxelShape[] BOTTOM_EAST_SHAPE = new VoxelShape[]{Block.box(0.0D, 0.0D, 0.0D, 4.0D, 4.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 12.0D, 12.0D, 16.0D)};
    public static final VoxelShape[] TOP_SOUTH_SHAPE = new VoxelShape[]{Block.box(0.0D, 12.0D, 0.0D, 16.0D, 16.0D, 4.0D), Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D), Block.box(0.0D, 4.0D, 0.0D, 16.0D, 16.0D, 12.0D)};
    public static final VoxelShape[] TOP_NORTH_SHAPE = new VoxelShape[]{Block.box(0.0D, 12.0D, 12.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 4.0D, 4.0D, 16.0D, 16.0D, 16.0D)};
    public static final VoxelShape[] TOP_WEST_SHAPE = new VoxelShape[]{Block.box(12.0D, 12.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(4.0D, 4.0D, 0.0D, 16.0D, 16.0D, 16.0D)};
    public static final VoxelShape[] TOP_EAST_SHAPE = new VoxelShape[]{Block.box(0.0D, 12.0D, 0.0D, 4.0D, 16.0D, 16.0D), Block.box(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 16.0D), Block.box(0.0D, 4.0D, 0.0D, 12.0D, 16.0D, 16.0D)};

    private Block fullBlock;

    public SlabQuarter(Props props) {
        super(props.toProperties());
        this.fullBlock = props.getParent().getBlock();
        this.registerDefaultState((this.stateDefinition.any()).setValue(DIRECTION, Direction.NORTH).setValue(TYPE_UPDOWN, Half.BOTTOM).setValue(WATERLOGGED, false));
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        int i = state.getValue(LAYERS);
        if (context.getItemInHand().getItem() == this.asItem() && i <= 3) {
            if (PlacementHelper.replacingClickedOnBlock(context)) {
                return context.getClickedFace() == state.getValue(DIRECTION) || context.getClickedFace() == state.getValue(DIRECTION).getCounterClockWise();
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        FluidState fluid = context.getLevel().getFluidState(blockpos);
        Direction facingHorizontal = context.getHorizontalDirection().getOpposite();
        BlockState state2 = this.defaultBlockState().setValue(DIRECTION, facingHorizontal).setValue(TYPE_UPDOWN, Half.BOTTOM).setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);
        Direction facing = context.getClickedFace();
        BlockState blockstate = context.getLevel().getBlockState(blockpos);
        if (blockstate.getBlock() == this) {
            int i = blockstate.getValue(LAYERS);
            if (i == 3) {
                return fullBlock.defaultBlockState();
            }
            return blockstate.setValue(LAYERS, Math.min(3, i + 1));
        }
        return facing != Direction.DOWN && (facing == Direction.UP || !(context.getClickLocation().y - (double)blockpos.getY() > 0.5D)) ? state2 : state2.setValue(TYPE_UPDOWN, Half.TOP);
    }

    @Override
    protected void addProperties(StateDefinition.Builder<Block, BlockState> container) {
        container.add(TYPE_UPDOWN, LAYERS);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        if (state.getValue(TYPE_UPDOWN) == Half.BOTTOM) {
            switch (state.getValue(DIRECTION)) {
                case NORTH:
                default:
                    return BOTTOM_NORTH_SHAPE[state.getValue(LAYERS) - 1];
                case SOUTH:
                    return BOTTOM_SOUTH_SHAPE[state.getValue(LAYERS) - 1];
                case WEST:
                    return BOTTOM_WEST_SHAPE[state.getValue(LAYERS) - 1];
                case EAST:
                    return BOTTOM_EAST_SHAPE[state.getValue(LAYERS) - 1];
            }
        } else {
            switch (state.getValue(DIRECTION)) {
                case NORTH:
                default:
                    return TOP_NORTH_SHAPE[state.getValue(LAYERS) - 1];
                case SOUTH:
                    return TOP_SOUTH_SHAPE[state.getValue(LAYERS) - 1];
                case WEST:
                    return TOP_WEST_SHAPE[state.getValue(LAYERS) - 1];
                case EAST:
                    return TOP_EAST_SHAPE[state.getValue(LAYERS) - 1];
            }
        }
    }
}