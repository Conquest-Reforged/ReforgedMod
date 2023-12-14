package com.conquestreforged.content.blocks.block.decor;

import com.conquestreforged.content.blocks.block.util.PlacementHelper;
import com.conquestreforged.core.block.base.HorizontalDirectionalShape;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class ClothesHangerCorner extends HorizontalDirectionalShape {

    private static final VoxelShape TOP_QTR_SOUTH_SHAPE = Block.createCuboidShape(0.0D, 8.0D, 8.0D, 8.0D, 16.0D, 16.0D);
    private static final VoxelShape TOP_MAIN_SOUTH_SHAPE = Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D);
    private static final VoxelShape TOP_SOUTH_SHAPE = VoxelShapes.union(TOP_QTR_SOUTH_SHAPE, TOP_MAIN_SOUTH_SHAPE);
    private static final VoxelShape TOP_QTR_NORTH_SHAPE = Block.createCuboidShape(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D);
    private static final VoxelShape TOP_MAIN_NORTH_SHAPE = Block.createCuboidShape(0.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape TOP_NORTH_SHAPE = VoxelShapes.union(TOP_QTR_NORTH_SHAPE, TOP_MAIN_NORTH_SHAPE);
    private static final VoxelShape TOP_QTR_WEST_SHAPE = Block.createCuboidShape(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 8.0D);
    private static final VoxelShape TOP_MAIN_WEST_SHAPE = Block.createCuboidShape(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape TOP_WEST_SHAPE = VoxelShapes.union(TOP_QTR_WEST_SHAPE, TOP_MAIN_WEST_SHAPE);
    private static final VoxelShape TOP_QTR_EAST_SHAPE = Block.createCuboidShape(8.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape TOP_MAIN_EAST_SHAPE = Block.createCuboidShape(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 16.0D);
    private static final VoxelShape TOP_EAST_SHAPE = VoxelShapes.union(TOP_QTR_EAST_SHAPE, TOP_MAIN_EAST_SHAPE);

    public ClothesHangerCorner(Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(DIRECTION, Direction.NORTH));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockPos pos = context.getBlockPos();
        Direction facingHorizontal = PlacementHelper.getHitVecHorizontalAxisDirection(context.getPlayerFacing().getOpposite(), pos, context);
        return getDefaultState().with(DIRECTION, facingHorizontal);
    }


    @Override
    public VoxelShape getShape(BlockState state) {
        switch (state.get(DIRECTION)) {
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