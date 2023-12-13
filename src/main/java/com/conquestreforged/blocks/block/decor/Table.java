package com.conquestreforged.blocks.block.decor;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.CrossCollisionBlock;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Table extends CrossCollisionBlock {

    public Table(Properties properties) {
        super(0.0F, 0.0F, 16.0F, 16.0F, 16.0F, properties);
    }


    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.block();
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState state1, LevelAccessor world, BlockPos pos, BlockPos pos1) {
        if (state.getValue(WATERLOGGED)) {
            world.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }
        return facing.getAxis().getPlane() == Direction.Plane.HORIZONTAL ? state.setValue(PROPERTY_BY_DIRECTION.get(facing), this.canTableConnectTo(world, pos, facing)) : super.updateShape(state, facing, state1, world, pos, pos1);
    }

    private boolean canTableConnectTo(BlockGetter reader, BlockPos pos, Direction facing) {
        BlockPos offset = pos.m_142300_(facing);
        BlockState other = reader.getBlockState(offset);
        return canBeConnectedTo(other, reader, offset, facing.getOpposite()) || canBeConnectedTo(other, reader, pos, facing);
    }

    private boolean canBeConnectedTo(BlockState state, BlockGetter reader, BlockPos pos, Direction facing) {
        BlockState other = reader.getBlockState(pos.m_142300_(facing));
        return this.attachesTo(other);
    }

    private boolean attachesTo(BlockState state) {
        Block block = state.getBlock();
        return block == this;
    }
}
