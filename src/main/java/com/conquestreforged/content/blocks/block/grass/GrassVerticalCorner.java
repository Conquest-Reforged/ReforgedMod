package com.conquestreforged.content.blocks.block.grass;

import com.conquestreforged.content.blocks.block.VerticalCorner;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.block.properties.Waterloggable;
import com.conquestreforged.core.util.RenderLayer;

@Assets(
        state = @State(name = "%s_vertical_corner", template = "parent_vertical_corner_tudor"),
        item = @Model(name = "item/%s_vertical_corner", parent = "block/%s_vertical_corner_4", template = "item/parent_vertical_corner_tudor"),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {
                @Model(name = "block/%s_vertical_corner_2", template = "block/parent_vertical_corner_grass_2"),
                @Model(name = "block/%s_vertical_corner_4", template = "block/parent_vertical_corner_grass_4"),
                @Model(name = "block/%s_vertical_corner_6", template = "block/parent_vertical_corner_grass_6"),
        }
)
public class GrassVerticalCorner extends VerticalCorner implements Waterloggable {

    public GrassVerticalCorner(Props properties) {
        super(properties);
    }
}
