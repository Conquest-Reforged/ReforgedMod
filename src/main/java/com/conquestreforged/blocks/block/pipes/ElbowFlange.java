package com.conquestreforged.blocks.block.pipes;

import com.conquestreforged.blocks.BlockVoxelShapes;
import com.conquestreforged.blocks.block.decor.HorizontalDirectionalWaterloggedToggle3;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ElbowFlange extends HorizontalDirectionalWaterloggedToggle3 {

    public ElbowFlange(Props props) {
        super(props);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        switch (state.getValue(TOGGLE)) {
            default:
            case 1:
                switch(state.getValue(DIRECTION)) {
                    default:
                    case NORTH:
                        return BlockVoxelShapes.elbowFlangeShapes.get(0);
                    case EAST:
                        return BlockVoxelShapes.elbowFlangeShapes.get(1);
                    case SOUTH:
                        return BlockVoxelShapes.elbowFlangeShapes.get(2);
                    case WEST:
                        return BlockVoxelShapes.elbowFlangeShapes.get(3);
                }
            case 2:
                switch(state.getValue(DIRECTION)) {
                    default:
                    case NORTH:
                        return BlockVoxelShapes.elbowFlangeShapes.get(8);
                    case EAST:
                        return BlockVoxelShapes.elbowFlangeShapes.get(9);
                    case SOUTH:
                        return BlockVoxelShapes.elbowFlangeShapes.get(10);
                    case WEST:
                        return BlockVoxelShapes.elbowFlangeShapes.get(11);
                }
            case 3:
                switch(state.getValue(DIRECTION)) {
                    default:
                    case NORTH:
                        return BlockVoxelShapes.elbowFlangeShapes.get(4);
                    case EAST:
                        return BlockVoxelShapes.elbowFlangeShapes.get(5);
                    case SOUTH:
                        return BlockVoxelShapes.elbowFlangeShapes.get(6);
                    case WEST:
                        return BlockVoxelShapes.elbowFlangeShapes.get(7);
                }
        }
    }
}
