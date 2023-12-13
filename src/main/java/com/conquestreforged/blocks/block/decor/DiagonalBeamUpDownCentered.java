package com.conquestreforged.blocks.block.decor;

import com.conquestreforged.blocks.block.directional.SlabDirectionalWaterlogged;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DiagonalBeamUpDownCentered extends SlabDirectionalWaterlogged {

    public DiagonalBeamUpDownCentered(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        if (state.getValue(DIRECTION) == Direction.NORTH || state.getValue(DIRECTION) == Direction.SOUTH) {
            return DiagonalBeamCentered.NORTH_SOUTH_SHAPE;
        } else {
            return DiagonalBeamCentered.EAST_WEST_SHAPE;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction facing = DiagonalBeamCentered.getDirection(context.getHorizontalDirection().getOpposite(), context.getClickedPos(), context);
        return super.getStateForPlacement(context).setValue(DIRECTION, facing);
    }
}
