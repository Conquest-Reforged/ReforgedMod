package com.conquestrefabricated.content.blocks.block.plants;

import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.util.RenderLayer;
import net.minecraft.block.LilyPadBlock;

@Render(RenderLayer.CUTOUT)
public class LilyPad extends LilyPadBlock {

    public LilyPad(Settings properties) {
        super(properties);
    }

}
