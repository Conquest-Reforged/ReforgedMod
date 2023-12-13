package com.conquestrefabricated.content.blocks.block.overlay_wall;

import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.util.RenderLayer;
import net.minecraft.block.Block;

@Assets(
        state = @State(name = "%s", template = "parent_cube_overlay", plural = true),
        item = @Model(name = "item/%s", parent = "block/%s", template = "item/parent_cube", plural = true),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = @Model(name = "block/%s", template = "block/parent_cube_overlay", plural = true)
)
public class OverlayCube extends Block {

    public OverlayCube(Settings properties) {
        super(properties);
    }
}