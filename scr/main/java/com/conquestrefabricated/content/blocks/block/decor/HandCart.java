package com.conquestrefabricated.content.blocks.block.decor;

import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.block.builder.Props;
import com.conquestrefabricated.core.util.RenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

@Render(RenderLayer.CUTOUT)
public class HandCart extends TableParallelConnecting {

    protected static final VoxelShape SHAPE = Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape COLLISION_SHAPE_N = Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 32.0D);
    protected static final VoxelShape COLLISION_SHAPE_E = Block.createCuboidShape(-16.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape COLLISION_SHAPE_S = Block.createCuboidShape(0.0D, 8.0D, -16.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape COLLISION_SHAPE_W = Block.createCuboidShape(0.0D, 8.0D, 0.0D, 32.0D, 16.0D, 16.0D);

    public HandCart(Props properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        return SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
        switch (state.get(DIRECTION)) {
            default:
            case NORTH:
                return COLLISION_SHAPE_N;
            case EAST:
                return COLLISION_SHAPE_E;
            case SOUTH:
                return COLLISION_SHAPE_S;
            case WEST:
                return COLLISION_SHAPE_W;
        }
    }

    @Override
    protected boolean attachesTo(BlockState state, Direction facing) {
        Block block = state.getBlock();
        return block instanceof HandCart && state.get(DIRECTION) == facing;
    }
}
