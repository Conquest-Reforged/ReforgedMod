package com.conquestreforged.content.blocks.block.pipes;

import com.conquestreforged.content.blocks.BlockVoxelShapes;
import com.conquestreforged.content.blocks.block.decor.HorizontalDirectionalWaterloggedToggle4;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.block.BlockState;
import net.minecraft.util.shape.VoxelShape;

public class MountedPipe extends HorizontalDirectionalWaterloggedToggle4 {

    public MountedPipe(Props props) {
        super(props);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        if (state.get(TOGGLE) == 1) {
            return BlockVoxelShapes.pipeShape;
        } else {
            switch(state.get(DIRECTION)) {
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
