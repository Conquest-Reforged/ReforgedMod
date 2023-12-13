package com.conquestreforged.blocks.block.decor;

import com.conquestreforged.core.block.base.Shape;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class ModelBlock extends Shape {

    private final List<VoxelShape> hitBox;

    public ModelBlock(Props props) {
        super(props.toProperties());
        this.hitBox = props.get("hitBox", List.class);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        return hitBox.get(0);
    }
}
