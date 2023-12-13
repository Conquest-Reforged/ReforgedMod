package com.conquestrefabricated.content.blocks.block.decor;

import com.conquestrefabricated.core.block.base.WaterloggedShape;
import com.conquestrefabricated.core.block.builder.Props;
import net.minecraft.block.BlockState;
import net.minecraft.util.shape.VoxelShape;

import java.util.List;

public class ModelBlockWaterlogged extends WaterloggedShape {

    private final List<VoxelShape> hitBox;

    public ModelBlockWaterlogged(Props props) {
        super(props.toSettings());
        this.hitBox = props.get("hitBox", List.class);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        return hitBox.get(0);
    }
}
