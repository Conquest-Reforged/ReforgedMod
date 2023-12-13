package com.conquestreforged.blocks.block.decor;

import com.conquestreforged.blocks.block.VerticalSlab;
import com.conquestreforged.blocks.block.VerticalSlabCorner;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DiagonalBeamUpDown extends VerticalSlabCorner {

    public DiagonalBeamUpDown(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        switch (state.getValue(DIRECTION)) {
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
