package com.conquestreforged.blocks.block.topography;

import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

@Render(RenderLayer.TRANSLUCENT)
public class Cloud extends Block {

    private static final IntegerProperty OPACITY = IntegerProperty.create("opacity", 0, 15);

    public Cloud(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(OPACITY, 7));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(OPACITY);
    }
}
