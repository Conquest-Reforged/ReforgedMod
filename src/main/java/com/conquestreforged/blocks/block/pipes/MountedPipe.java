package com.conquestreforged.blocks.block.pipes;

import com.conquestreforged.blocks.BlockVoxelShapes;
import com.conquestreforged.blocks.block.decor.HorizontalDirectionalWaterloggedToggle4;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MountedPipe extends HorizontalDirectionalWaterloggedToggle4 {

    public MountedPipe(Props props) {
        super(props);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        if (state.getValue(TOGGLE) == 1) {
            return BlockVoxelShapes.pipeShape;
        } else {
            switch(state.getValue(DIRECTION)) {
                default:
                case NORTH:
                case SOUTH:
                    return BlockVoxelShapes.pipeShapeHorizontal_NS;
                case EAST:
                case WEST:
                    return BlockVoxelShapes.pipeShapeHorizontal_EW;
            }
        }

    }
}
