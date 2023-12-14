package com.conquestreforged.content.blocks.block.pipes;

import com.conquestreforged.content.blocks.BlockVoxelShapes;
import com.conquestreforged.content.blocks.block.decor.HorizontalDirectionalWaterloggedToggle2;
import com.conquestreforged.core.block.base.WaterloggedHorizontalDirectionalShape;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.block.BlockState;
import net.minecraft.util.shape.VoxelShape;

public class CrossFlange extends HorizontalDirectionalWaterloggedToggle2 {

    public CrossFlange(Props props) {
        super(props);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        switch (state.get(TOGGLE)) {
            default:
            case 1:
                switch(state.get(WaterloggedHorizontalDirectionalShape.DIRECTION)) {
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
