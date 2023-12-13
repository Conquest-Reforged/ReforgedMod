package com.conquestrefabricated.content.blocks.block.glass;

import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.util.RenderLayer;

@Assets(
        state = @State(name = "%s", template = "parent_cube", plural = true),
        item = @Model(name = "item/%s", parent = "block/%s", template = "item/parent_cube", plural = true),
        render = @Render(RenderLayer.TRANSLUCENT),
        block = @Model(name = "block/%s", template = "block/parent_cube", plural = true)
)
public class GlassTranslucent extends Glass {

    public GlassTranslucent(Settings properties) {
        super(properties);
    }
}
