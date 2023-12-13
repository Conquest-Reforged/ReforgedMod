package com.conquestrefabricated.content.blocks.block.grass;

import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.util.RenderLayer;
import net.minecraft.block.GrassBlock;

@Render(RenderLayer.CUTOUT_MIPPED)
public class Grass extends GrassBlock {

    public Grass(Settings properties) {
        super(properties);
    }
}
