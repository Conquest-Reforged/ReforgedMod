package com.conquestreforged.blocks.block.decor;

import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@Render(RenderLayer.CUTOUT)
public class HandCart extends TableParallelConnecting {

    protected static final VoxelShape SHAPE = Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape COLLISION_SHAPE_N = Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 32.0D);
    protected static final VoxelShape COLLISION_SHAPE_E = Block.box(-16.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape COLLISION_SHAPE_S = Block.box(0.0D, 8.0D, -16.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape COLLISION_SHAPE_W = Block.box(0.0D, 8.0D, 0.0D, 32.0D, 16.0D, 16.0D);

    public HandCart(Props properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        return SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        switch (state.getValue(DIRECTION)) {
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
        return block instanceof HandCart && state.getValue(DIRECTION) == facing;
    }
}
