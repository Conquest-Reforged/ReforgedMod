package com.conquestrefabricated.content.blocks.block.overlay_wall;

import com.conquestrefabricated.content.blocks.block.VerticalCorner;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.builder.Props;
import com.conquestrefabricated.core.block.properties.Waterloggable;
import com.conquestrefabricated.core.util.RenderLayer;

@Assets(
        state = @State(name = "%s_vertical_corner", template = "parent_vertical_corner_overlay"),
        item = @Model(name = "item/%s_vertical_corner", parent = "block/%s_vertical_corner_4", template = "item/parent_vertical_corner_tudor"),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {
                @Model(name = "block/%s_vertical_corner_1", template = "block/parent_vertical_corner_overlay_1"),
                @Model(name = "block/%s_vertical_corner_2", template = "block/parent_vertical_corner_overlay_2"),
                @Model(name = "block/%s_vertical_corner_4", template = "block/parent_vertical_corner_overlay_4"),
                @Model(name = "block/%s_vertical_corner_6", template = "block/parent_vertical_corner_overlay_6"),
        }
)
public class OverlayVerticalCorner extends VerticalCorner implements Waterloggable {

    public OverlayVerticalCorner(Props properties) {
        super(properties);
    }
}
