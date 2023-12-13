package com.conquestrefabricated.content.blocks.block.overlay_top.inverted;

import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.util.RenderLayer;
import net.minecraft.block.Block;

@Assets(
        state = @State(name = "%s", template = "parent_cube_overlay_top_inverted", plural = true),
        item = @Model(name = "item/%s", parent = "block/%s", template = "item/parent_cube", plural = true),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = @Model(name = "block/%s", template = "block/parent_cube_overlay_top_inverted", plural = true)
)
public class TopOverlayInvertedCube extends Block {

    public TopOverlayInvertedCube(Settings properties) {
        super(properties);
    }
}