package com.conquestrefabricated.content.blocks.block.decor;

import com.conquestrefabricated.core.block.base.Shape;
import com.conquestrefabricated.core.block.builder.Props;
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
