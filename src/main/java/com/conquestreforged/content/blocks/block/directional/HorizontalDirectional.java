package com.conquestreforged.content.blocks.block.directional;

import com.conquestreforged.core.block.base.HorizontalDirectionalShape;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.block.BlockState;
import net.minecraft.util.shape.VoxelShape;

import java.util.List;

public class HorizontalDirectional extends HorizontalDirectionalShape {

    private final List<VoxelShape> hitBox;

    public HorizontalDirectional(Props props) {
        super(props.toSettings());
        this.hitBox = props.get("hitBox", List.class);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        boolean hasFourShapes = hitBox.size() == 4;
        switch (state.get(DIRECTION)) {
            default:
                return hitBox.get(0);
            case EAST:
                return hitBox.get(hasFourShapes ? 1 : 0);
            case SOUTH:
                return hitBox.get(hasFourShapes ? 2 : 0);
            case WEST:
                return hitBox.get(hasFourShapes ? 3 : 0);
        }
    }
}
