package com.conquestrefabricated.content.blocks.block.decor;

import com.conquestrefabricated.content.blocks.block.VerticalSlab;
import com.conquestrefabricated.content.blocks.block.VerticalSlabCorner;
import net.minecraft.block.BlockState;
import net.minecraft.util.shape.VoxelShape;

public class DiagonalBeamUpDown extends VerticalSlabCorner {

    public DiagonalBeamUpDown(Settings properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        switch (state.get(DIRECTION)) {
            case NORTH:
                return VerticalSlab.NORTH_SHAPE[1];
            case SOUTH:
                return VerticalSlab.SOUTH_SHAPE[1];
            case EAST:
                return VerticalSlab.EAST_SHAPE[1];
            default:
                return VerticalSlab.WEST_SHAPE[1];
        }
    }
}
