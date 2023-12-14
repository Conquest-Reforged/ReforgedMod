package com.conquestreforged.content.blocks.block.grass;

import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.block.GrassBlock;

@Render(RenderLayer.CUTOUT_MIPPED)
public class Grass extends GrassBlock {

    public Grass(Settings properties) {
        super(properties);
    }
}
