package com.conquestreforged.blocks.block.decor;

import com.conquestreforged.blocks.block.util.PlacementHelper;
import com.conquestreforged.core.block.base.HorizontalDirectionalShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ClothesHangerCorner extends HorizontalDirectionalShape {

    private static final VoxelShape TOP_QTR_SOUTH_SHAPE = Block.box(0.0D, 8.0D, 8.0D, 8.0D, 16.0D, 16.0D);
    private static final VoxelShape TOP_MAIN_SOUTH_SHAPE = Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D);
    private static final VoxelShape TOP_SOUTH_SHAPE = Shapes.or(TOP_QTR_SOUTH_SHAPE, TOP_MAIN_SOUTH_SHAPE);
    private static final VoxelShape TOP_QTR_NORTH_SHAPE = Block.box(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D);
    private static final VoxelShape TOP_MAIN_NORTH_SHAPE = Block.box(0.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape TOP_NORTH_SHAPE = Shapes.or(TOP_QTR_NORTH_SHAPE, TOP_MAIN_NORTH_SHAPE);
    private static final VoxelShape TOP_QTR_WEST_SHAPE = Block.box(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 8.0D);
    private static final VoxelShape TOP_MAIN_WEST_SHAPE = Block.box(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape TOP_WEST_SHAPE = Shapes.or(TOP_QTR_WEST_SHAPE, TOP_MAIN_WEST_SHAPE);
    private static final VoxelShape TOP_QTR_EAST_SHAPE = Block.box(8.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape TOP_MAIN_EAST_SHAPE = Block.box(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 16.0D);
    private static final VoxelShape TOP_EAST_SHAPE = Shapes.or(TOP_QTR_EAST_SHAPE, TOP_MAIN_EAST_SHAPE);

    public ClothesHangerCorner(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(DIRECTION, Direction.NORTH));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        Direction facingHorizontal = PlacementHelper.getHitVecHorizontalAxisDirection(context.getHorizontalDirection().getOpposite(), pos, context);
        return defaultBlockState().setValue(DIRECTION, facingHorizontal);
    }


    @Override
    public VoxelShape getShape(BlockState state) {
        switch (state.getValue(DIRECTION)) {
                case NORTH:
                default:
                    return TOP_NORTH_SHAPE;
                case SOUTH:
                    return TOP_SOUTH_SHAPE;
                case WEST:
                    return TOP_WEST_SHAPE;
                case EAST:
                    return TOP_EAST_SHAPE;
            }
        }
}