package com.conquestreforged.blocks.block;

import com.conquestreforged.blocks.block.util.PlacementHelper;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.base.WaterloggedHorizontalDirectionalShape;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.block.properties.Waterloggable;
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
        state = @State(name = "%s_vertical_corner", template = "parent_vertical_corner_lesslayers"),
        item = @Model(name = "item/%s_vertical_corner", parent = "block/%s_vertical_corner_4", template = "item/parent_vertical_corner"),
        block = {
                @Model(name = "block/%s_vertical_corner_2", template = "block/parent_vertical_corner_2"),
                @Model(name = "block/%s_vertical_corner_4", template = "block/parent_vertical_corner_4"),
                @Model(name = "block/%s_vertical_corner_6", template = "block/parent_vertical_corner_6"),
        }
)
public class VerticalCornerLessLayers extends WaterloggedHorizontalDirectionalShape implements Waterloggable {

    public static final IntegerProperty LAYERS = IntegerProperty.create("layer", 1, 3);

    private Block fullBlock;

    public VerticalCornerLessLayers(Props props) {
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
    public boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        switch (state.getValue(DIRECTION)) {
            case NORTH:
            default:
                return VerticalCorner.NORTH_SHAPE[state.getValue(LAYERS)];
            case SOUTH:
                return VerticalCorner.SOUTH_SHAPE[state.getValue(LAYERS)];
            case WEST:
                return VerticalCorner.WEST_SHAPE[state.getValue(LAYERS)];
            case EAST:
                return VerticalCorner.EAST_SHAPE[state.getValue(LAYERS)];
        }
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
        Direction facing = PlacementHelper.getHitVecHorizontalAxisDirection(context.getHorizontalDirection().getOpposite(), blockpos, context);

        BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos());
        if (blockstate.getBlock() == this) {
            int i = blockstate.getValue(LAYERS);
            if (i == 3) {
                return fullBlock.defaultBlockState();
            }
            return blockstate.setValue(LAYERS, Math.min(3, i + 1));
        } else {
            return super.getStateForPlacement(context).setValue(DIRECTION, facing);
        }
    }

    @Override
    protected void addProperties(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LAYERS);
    }
}
