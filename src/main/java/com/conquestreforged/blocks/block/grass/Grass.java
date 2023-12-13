package com.conquestreforged.blocks.block.grass;

import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.world.level.block.GrassBlock;

@Render(RenderLayer.CUTOUT_MIPPED)
public class Grass extends GrassBlock {

    public Grass(Properties properties) {
        super(properties);
    }
}
