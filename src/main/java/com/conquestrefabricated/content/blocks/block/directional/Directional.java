package com.conquestrefabricated.content.blocks.block.directional;

import com.conquestrefabricated.core.block.base.DirectionalShape;
import com.conquestrefabricated.core.block.builder.Props;
import net.minecraft.block.BlockState;
import net.minecraft.util.shape.VoxelShape;

import java.util.List;

public class Directional extends DirectionalShape {

    private final List<VoxelShape> hitBox;

    public Directional(Props props) {
        super(props.toSettings());
        this.hitBox = props.get("hitBox", List.class);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        boolean hasSixShapes = hitBox.size() == 6;
        switch (state.get(DIRECTION)) {
            default:
                return hitBox.get(0);
            case EAST:
                return hitBox.get(hasSixShapes ? 1 : 0);
            case SOUTH:
                return hitBox.get(hasSixShapes ? 2 : 0);
            case WEST:
                return hitBox.get(hasSixShapes ? 3 : 0);
            case UP:
                return hitBox.get(hasSixShapes ? 4 : 0);
            case DOWN:
                return hitBox.get(hasSixShapes ? 5 : 0);
        }
    }
}
