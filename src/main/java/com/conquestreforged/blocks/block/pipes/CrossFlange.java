package com.conquestreforged.blocks.block.pipes;

import com.conquestreforged.blocks.BlockVoxelShapes;
import com.conquestreforged.blocks.block.decor.HorizontalDirectionalWaterloggedToggle2;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CrossFlange extends HorizontalDirectionalWaterloggedToggle2 {

    public CrossFlange(Props props) {
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
                    case SOUTH:
                        return BlockVoxelShapes.crossFlangeShapes.get(0);
                    case EAST:
                    case WEST:
                        return BlockVoxelShapes.crossFlangeShapes.get(1);
                }
            case 2:
                return BlockVoxelShapes.crossFlangeShapes.get(2);
        }
    }
}
