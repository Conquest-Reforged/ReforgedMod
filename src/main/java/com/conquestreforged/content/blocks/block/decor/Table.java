package com.conquestreforged.content.blocks.block.decor;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalConnectingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

public class Table extends HorizontalConnectingBlock {

    public Table(Settings properties) {
        super(0.0F, 0.0F, 16.0F, 16.0F, 16.0F, properties);
    }


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.fullCube();
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction facing, BlockState state1, WorldAccess world, BlockPos pos, BlockPos pos1) {
        if (state.get(WATERLOGGED)) {
            world.createAndScheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return facing.getAxis().getType() == Direction.Type.HORIZONTAL ? state.with(FACING_PROPERTIES.get(facing), this.canTableConnectTo(world, pos, facing)) : super.getStateForNeighborUpdate(state, facing, state1, world, pos, pos1);
    }

    private boolean canTableConnectTo(BlockView reader, BlockPos pos, Direction facing) {
        BlockPos offset = pos.offset(facing);
        BlockState other = reader.getBlockState(offset);
        return canBeConnectedTo(other, reader, offset, facing.getOpposite()) || canBeConnectedTo(other, reader, pos, facing);
    }

    private boolean canBeConnectedTo(BlockState state, BlockView reader, BlockPos pos, Direction facing) {
        BlockState other = reader.getBlockState(pos.offset(facing));
        return this.attachesTo(other);
    }

    private boolean attachesTo(BlockState state) {
        Block block = state.getBlock();
        return block == this;
    }
}
