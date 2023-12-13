package com.conquestrefabricated.content.blocks.block.decor;

import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.block.builder.Props;
import com.conquestrefabricated.core.block.properties.ParallelConnectionShape2;
import com.conquestrefabricated.core.util.RenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.shape.VoxelShape;

import java.util.List;

@Render(RenderLayer.CUTOUT)
public class Rack extends TableParallelConnecting {

    protected static final VoxelShape SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
    private final List<VoxelShape> hitBox;

    public static final EnumProperty<ParallelConnectionShape2> FORM = EnumProperty.of("shape", ParallelConnectionShape2.class);

    public Rack(Props props) {
        super(props);
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
