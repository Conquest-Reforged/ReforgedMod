package com.conquestreforged.blocks.block.directional;

import com.conquestreforged.core.block.base.BiDirectionalShape;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

import static com.conquestreforged.core.block.properties.BidirectionalShape.EAST_WEST;

public class BiDirectional extends BiDirectionalShape {

    private final List<VoxelShape> hitBox;

    public BiDirectional(Props props) {
        super(props.toProperties());
        this.hitBox = props.get("hitBox", List.class);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        boolean hasTwoShapes = hitBox.size() == 2;
        if (state.getValue(DIRECTION) == EAST_WEST) {
            return hitBox.get(hasTwoShapes ? 1 : 0);
        } else {
            return hitBox.get(0);
        }
    }
}
