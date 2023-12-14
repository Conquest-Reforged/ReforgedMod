package com.conquestreforged.content.blocks.block.overlay_top.inverted;

import com.conquestreforged.content.blocks.block.VerticalQuarter;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;

@Assets(
        state = @State(name = "%s_vertical_quarter", template = "parent_vertical_quarter_overlay_top_inverted"),
        item = @Model(name = "item/%s_vertical_quarter", parent = "block/%s_vertical_quarter_4", template = "item/parent_vertical_quarter_tudor"),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {
                @Model(name = "block/%s_vertical_quarter_1", template = "block/parent_vertical_quarter_1_overlay_top_inverted"),
                @Model(name = "block/%s_vertical_quarter_2", template = "block/parent_vertical_quarter_2_overlay_top_inverted"),
                @Model(name = "block/%s_vertical_quarter_4", template = "block/parent_vertical_quarter_4_overlay_top_inverted"),
                @Model(name = "block/%s_vertical_quarter_6", template = "block/parent_vertical_quarter_6_overlay_top_inverted"),
        }
)
public class TopOverlayInvertedVerticalQuarter extends VerticalQuarter {

    public TopOverlayInvertedVerticalQuarter(Props properties) {
        super(properties);
    }
}
