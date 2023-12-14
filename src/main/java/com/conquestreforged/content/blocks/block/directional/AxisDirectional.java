package com.conquestreforged.content.blocks.block.directional;

import com.conquestreforged.core.block.base.AxisShape;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

import java.util.List;

public class AxisDirectional extends AxisShape {

    private final List<VoxelShape> hitBox;

    public AxisDirectional(Props props) {
        super(props.toSettings());
        this.hitBox = props.get("hitBox", List.class);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        boolean hasThreeShapes = hitBox.size() == 3;

        if (state.get(AXIS) == Direction.Axis.Y) {
            return hitBox.get(hasThreeShapes ? 1 : 0);
        } else if (state.get(AXIS) == Direction.Axis.X) {
            return hitBox.get(hasThreeShapes ? 2 : 0);
        } else {
            return hitBox.get(0);
        }
    }
}