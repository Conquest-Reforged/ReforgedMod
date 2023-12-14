package com.conquestreforged.content.blocks.block;

import com.conquestreforged.content.blocks.block.util.PlacementHelper;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.base.WaterloggedHorizontalDirectionalShape;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.block.properties.Waterloggable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

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

    public static final IntProperty LAYERS = IntProperty.of("layer", 1, 3);

    private Block fullBlock;

    public VerticalCornerLessLayers(Props props) {
        super(props.toSettings());
        this.setDefaultState((this.stateManager.getDefaultState()).with(DIRECTION, Direction.NORTH).with(WATERLOGGED, false));
        this.fullBlock = props.getParent().getBlock();
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirrorIn) {
        switch (mirrorIn) {
            case FRONT_BACK:
                switch(state.get(DIRECTION)) {
                    case NORTH:
                        return state.with(DIRECTION, Direction.EAST);
                    case EAST:
                        return state.with(DIRECTION, Direction.NORTH);
                    case SOUTH:
                        return state.with(DIRECTION, Direction.WEST);
                    case WEST:
                        return state.with(DIRECTION, Direction.SOUTH);
                    default:
                        return super.mirror(state, mirrorIn);
                }
            case LEFT_RIGHT:
                switch(state.get(DIRECTION)) {
                    case NORTH:
                        return state.with(DIRECTION, Direction.WEST);
                    case EAST:
                        return state.with(DIRECTION, Direction.SOUTH);
                    case SOUTH:
                        return state.with(DIRECTION, Direction.EAST);
                    case WEST:
                        return state.with(DIRECTION, Direction.NORTH);
                    default:
                        return super.mirror(state, mirrorIn);
                }
        }
        return super.mirror(state, mirrorIn);
    }

    @Override
    public boolean hasSidedTransparency(BlockState state) {
        return true;
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        switch (state.get(DIRECTION)) {
            case NORTH:
            default:
                return VerticalCorner.NORTH_SHAPE[state.get(LAYERS)];
            case SOUTH:
                return VerticalCorner.SOUTH_SHAPE[state.get(LAYERS)];
            case WEST:
                return VerticalCorner.WEST_SHAPE[state.get(LAYERS)];
            case EAST:
                return VerticalCorner.EAST_SHAPE[state.get(LAYERS)];
        }
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        int i = state.get(LAYERS);
        if (context.getStack().getItem() == this.asItem() && i <= 3) {
            if (PlacementHelper.replacingClickedOnBlock(context)) {
                return context.getSide() == state.get(DIRECTION) || context.getSide() == state.get(DIRECTION).rotateYCounterclockwise();
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockPos blockpos = context.getBlockPos();
        Direction facing = PlacementHelper.getHitVecHorizontalAxisDirection(context.getPlayerFacing().getOpposite(), blockpos, context);

        BlockState blockstate = context.getWorld().getBlockState(context.getBlockPos());
        if (blockstate.getBlock() == this) {
            int i = blockstate.get(LAYERS);
            if (i == 3) {
                return fullBlock.getDefaultState();
            }
            return blockstate.with(LAYERS, Math.min(3, i + 1));
        } else {
            return super.getPlacementState(context).with(DIRECTION, facing);
        }
    }

    @Override
    protected void addProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LAYERS);
    }
}
