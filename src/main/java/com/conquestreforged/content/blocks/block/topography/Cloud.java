package com.conquestreforged.content.blocks.block.topography;

import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;

@Render(RenderLayer.TRANSLUCENT)
public class Cloud extends Block {

    private static final IntProperty OPACITY = IntProperty.of("opacity", 0, 15);

    public Cloud(Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(OPACITY, 7));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(OPACITY);
    }
}
