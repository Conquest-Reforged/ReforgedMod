package com.conquestrefabricated.content.blocks.block.directional;

import com.conquestrefabricated.core.block.base.WaterloggedHorizontalDirectionalShape;
import com.conquestrefabricated.core.block.builder.Props;
import net.minecraft.block.BlockState;
import net.minecraft.util.shape.VoxelShape;

import java.util.List;

public class HorizontalDirectionalWaterlogged extends WaterloggedHorizontalDirectionalShape {

    private final List<VoxelShape> hitBox;

    public HorizontalDirectionalWaterlogged(Props props) {
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
