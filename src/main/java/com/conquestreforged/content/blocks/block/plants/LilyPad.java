package com.conquestreforged.content.blocks.block.plants;

import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.block.LilyPadBlock;

@Render(RenderLayer.CUTOUT)
public class LilyPad extends LilyPadBlock {

    public LilyPad(Settings properties) {
        super(properties);
    }

}
