package com.conquestrefabricated.content.blocks.block.overlay_wall;

import com.conquestrefabricated.content.blocks.block.VerticalQuarter;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.builder.Props;
import com.conquestrefabricated.core.util.RenderLayer;

@Assets(
        state = @State(name = "%s_vertical_quarter", template = "parent_vertical_quarter_overlay"),
        item = @Model(name = "item/%s_vertical_quarter", parent = "block/%s_vertical_quarter_4", template = "item/parent_vertical_quarter_tudor"),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {
                @Model(name = "block/%s_vertical_quarter_1", template = "block/parent_vertical_quarter_overlay_1"),
                @Model(name = "block/%s_vertical_quarter_2", template = "block/parent_vertical_quarter_overlay_2"),
                @Model(name = "block/%s_vertical_quarter_4", template = "block/parent_vertical_quarter_overlay_4"),
                @Model(name = "block/%s_vertical_quarter_6", template = "block/parent_vertical_quarter_overlay_6"),
        }
)
public class OverlayVerticalQuarter extends VerticalQuarter {

    public OverlayVerticalQuarter(Props properties) {
        super(properties);
    }
}
