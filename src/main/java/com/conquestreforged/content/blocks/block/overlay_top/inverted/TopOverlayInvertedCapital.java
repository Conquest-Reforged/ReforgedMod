package com.conquestreforged.content.blocks.block.overlay_top.inverted;

import com.conquestreforged.content.blocks.block.Capital;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.properties.Waterloggable;
import com.conquestreforged.core.util.RenderLayer;

@Assets(
        state = @State(name = "%s_capital", template = "parent_capital_overlay_top_inverted"),
        item = @Model(name = "item/%s_capital", parent = "block/%s_capital_down_flat", template = "item/parent_capital"),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {
                @Model(name = "block/%s_capital_down_flat", template = "block/parent_capital_down_flat_overlay_top_inverted"),
                @Model(name = "block/%s_capital_down_side", template = "block/parent_capital_down_side_overlay_top_inverted"),
                @Model(name = "block/%s_capital_up_flat", template = "block/parent_capital_up_flat_overlay_top_inverted"),
                @Model(name = "block/%s_capital_up_side", template = "block/parent_capital_up_side_overlay_top_inverted"),
        }
)
public class TopOverlayInvertedCapital extends Capital implements Waterloggable {

    public TopOverlayInvertedCapital(Settings properties) {
        super(properties);
    }
}
