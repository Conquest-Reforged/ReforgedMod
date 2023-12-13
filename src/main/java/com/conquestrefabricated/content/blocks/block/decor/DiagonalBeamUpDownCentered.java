package com.conquestrefabricated.content.blocks.block.decor;

import com.conquestrefabricated.content.blocks.block.directional.SlabDirectionalWaterlogged;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

public class DiagonalBeamUpDownCentered extends SlabDirectionalWaterlogged {

    public DiagonalBeamUpDownCentered(Settings properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        if (state.get(DIRECTION) == Direction.NORTH || state.get(DIRECTION) == Direction.SOUTH) {
            return DiagonalBeamCentered.NORTH_SOUTH_SHAPE;
        } else {
            return DiagonalBeamCentered.EAST_WEST_SHAPE;
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        Direction facing = DiagonalBeamCentered.getDirection(context.getPlayerFacing().getOpposite(), context.getBlockPos(), context);
        return super.getPlacementState(context).with(DIRECTION, facing);
    }
}
