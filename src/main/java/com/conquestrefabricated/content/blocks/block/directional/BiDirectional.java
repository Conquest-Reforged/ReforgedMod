package com.conquestrefabricated.content.blocks.block.directional;

import com.conquestrefabricated.core.block.base.BiDirectionalShape;
import com.conquestrefabricated.core.block.builder.Props;
import net.minecraft.block.BlockState;
import net.minecraft.util.shape.VoxelShape;

import java.util.List;

import static com.conquestrefabricated.core.block.properties.BidirectionalShape.EAST_WEST;

public class BiDirectional extends BiDirectionalShape {

    private final List<VoxelShape> hitBox;

    public BiDirectional(Props props) {
        super(props.toSettings());
        this.hitBox = props.get("hitBox", List.class);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        boolean hasTwoShapes = hitBox.size() == 2;
        if (state.get(DIRECTION) == EAST_WEST) {
            return hitBox.get(hasTwoShapes ? 1 : 0);
        } else {
            return hitBox.get(0);
        }
    }
}
