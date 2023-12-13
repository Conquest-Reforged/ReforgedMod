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
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.VoxelShape;

@Assets(
        state = @State(name = "%s_vertical_quarter", template = "parent_vertical_quarter"),
        item = @Model(name = "item/%s_vertical_quarter", parent = "block/%s_vertical_quarter_4", template = "item/parent_vertical_quarter"),
        block = {
                @Model(name = "block/%s_vertical_quarter_1", template = "block/parent_vertical_quarter_1"),
                @Model(name = "block/%s_vertical_quarter_2", template = "block/parent_vertical_quarter_2"),
                @Model(name = "block/%s_vertical_quarter_4", template = "block/parent_vertical_quarter_4"),
                @Model(name = "block/%s_vertical_quarter_6", template = "block/parent_vertical_quarter_6"),
        }
)
public class VerticalQuarter extends WaterloggedHorizontalDirectionalShape {

    public static final IntegerProperty LAYERS = IntegerProperty.create("layer", 1, 4);

    public static final VoxelShape[] NORTH_SHAPE = new VoxelShape[]{Block.box(14.0D, 0.0D, 14.0D, 16.0D, 16.0D, 16.0D), Block.box(12.0D, 0.0D, 12.0D, 16.0D, 16.0D, 16.0D), Block.box(8.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D), Block.box(4.0D, 0.0D, 4.0D, 16.0D, 16.0D, 16.0D)};
    public static final VoxelShape[] SOUTH_SHAPE = new VoxelShape[]{Block.box(0.0D, 0.0D, 0.0D, 2.0D, 16.0D, 2.0D), Block.box(0.0D, 0.0D, 0.0D, 4.0D, 16.0D, 4.0D), Block.box(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 8.0D), Block.box(0.0D, 0.0D, 0.0D, 12.0D, 16.0D, 12.0D)};
    public static final VoxelShape[] EAST_SHAPE = new VoxelShape[]{Block.box(0.0D, 0.0D, 14.0D, 2.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 12.0D, 4.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 8.0D, 8.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 4.0D, 12.0D, 16.0D, 16.0D)};
    public static final VoxelShape[] WEST_SHAPE = new VoxelShape[]{Block.box(14.0D, 0.0D, 0.0D, 16.0D, 16.0D, 2.0D), Block.box(12.0D, 0.0D, 0.0D, 16.0D, 16.0D, 4.0D), Block.box(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D), Block.box(4.0D, 0.0D, 0.0D, 16.0D, 16.0D, 12.0D)};
    private Block fullBlock;

    public VerticalQuarter(Props props) {
        super(props.toProperties());
        this.registerDefaultState((this.stateDefinition.any()).setValue(DIRECTION, Direction.NORTH).setValue(WATERLOGGED, false));
        this.fullBlock = props.getParent().getBlock();
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        switch (mirrorIn) {
            case FRONT_BACK:
                switch(state.getValue(DIRECTION)) {
                    case NORTH:
                        return state.setValue(DIRECTION, Direction.EAST);
                    case EAST:
                        return state.setValue(DIRECTION, Direction.NORTH);
                    case SOUTH:
                        return state.setValue(DIRECTION, Direction.WEST);
                    case WEST:
                        return state.setValue(DIRECTION, Direction.SOUTH);
                    default:
                        return super.mirror(state, mirrorIn);
                }
            case LEFT_RIGHT:
                switch(state.getValue(DIRECTION)) {
                    case NORTH:
                        return state.setValue(DIRECTION, Direction.WEST);
                    case EAST:
                        return state.setValue(DIRECTION, Direction.SOUTH);
                    case SOUTH:
                        return state.setValue(DIRECTION, Direction.EAST);
                    case WEST:
                        return state.setValue(DIRECTION, Direction.NORTH);
                    default:
                        return super.mirror(state, mirrorIn);
                }
        }
        return super.mirror(state, mirrorIn);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        switch (state.getValue(DIRECTION)) {
            case NORTH:
            default:
                return NORTH_SHAPE[state.getValue(LAYERS) - 1];
            case SOUTH:
                return SOUTH_SHAPE[state.getValue(LAYERS) - 1];
            case WEST:
                return WEST_SHAPE[state.getValue(LAYERS) - 1];
            case EAST:
                return EAST_SHAPE[state.getValue(LAYERS) - 1];
        }
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        int i = state.getValue(LAYERS);
        if (context.getItemInHand().getItem() == this.asItem() && i <= 4) {
            if (PlacementHelper.replacingClickedOnBlock(context)) {
                return context.getClickedFace() == state.getValue(DIRECTION) || context.getClickedFace() == state.getValue(DIRECTION).getCounterClockWise();
            } else {
                return true;
            }
        }
        else {
            return false;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        Direction facing = PlacementHelper.getHitVecHorizontalAxisDirection(context.getHorizontalDirection().getOpposite(), blockpos, context);
        BlockState blockstate = context.getLevel().getBlockState(blockpos);
        if (blockstate.getBlock() == this) {
            int i = blockstate.getValue(LAYERS);
            if (i == 4) {
                return fullBlock.defaultBlockState();
            }
            return blockstate.setValue(LAYERS, Math.min(4, i + 1));
        } else {
            return super.getStateForPlacement(context).setValue(DIRECTION, facing);
        }
    }

    @Override
    protected void addProperties(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LAYERS);
    }
}
