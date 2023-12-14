package com.conquestreforged.content.blocks.block.decor;

import com.conquestreforged.core.block.base.Shape;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.block.BlockState;
import net.minecraft.util.shape.VoxelShape;

import java.util.List;

public class ModelBlock extends Shape {

    private final List<VoxelShape> hitBox;

    public ModelBlock(Props props) {
        super(props.toSettings());
        this.hitBox = props.get("hitBox", List.class);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        return hitBox.get(0);
    }
}
