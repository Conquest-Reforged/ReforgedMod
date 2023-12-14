package com.conquestreforged.content.blocks.block.overlay_top;

import com.conquestreforged.content.blocks.block.windows.WindowSmallHalf;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.util.RenderLayer;

@Assets(
        state = @State(name = "%s_small_window_half", template = "parent_window_small_half_overlay_top"),
        item = @Model(name = "item/%s_small_window_half", parent = "block/%s_window_small_half_updown", template = "item/parent_window_small_half"),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {
                @Model(name = "block/%s_window_small_half", template = "block/parent_window_small_half_overlay_top"),
                @Model(name = "block/%s_window_small_half_down", template = "block/parent_window_small_half_down_overlay_top"),
                @Model(name = "block/%s_window_small_half_up", template = "block/parent_window_small_half_up_overlay_top"),
                @Model(name = "block/%s_window_small_half_updown", template = "block/parent_window_small_half_updown_overlay_top"),
        }
)
public class TopOverlayWindowSmallHalf extends WindowSmallHalf {

    public TopOverlayWindowSmallHalf(Settings properties) {
        super(properties);
    }
}
