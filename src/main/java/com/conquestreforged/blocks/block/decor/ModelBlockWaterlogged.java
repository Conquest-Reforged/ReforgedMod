package com.conquestreforged.blocks.block.decor;

import com.conquestreforged.core.block.base.WaterloggedShape;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class ModelBlockWaterlogged extends WaterloggedShape {

    private final List<VoxelShape> hitBox;

    public ModelBlockWaterlogged(Props props) {
        super(props.toProperties());
        this.hitBox = props.get("hitBox", List.class);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        return hitBox.get(0);
    }
}
