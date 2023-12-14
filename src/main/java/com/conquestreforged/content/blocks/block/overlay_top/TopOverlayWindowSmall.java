package com.conquestreforged.content.blocks.block.overlay_top;

import com.conquestreforged.content.blocks.block.windows.WindowSmall;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.util.RenderLayer;

@Assets(
        state = @State(name = "%s_small_window", template = "parent_window_small_overlay_top"),
        item = @Model(name = "item/%s_small_window", parent = "block/%s_window_small", template = "item/parent_window_small"),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {
                @Model(name = "block/%s_window_small", template = "block/parent_window_small_overlay_top"),
                @Model(name = "block/%s_window_small_down", template = "block/parent_window_small_down_overlay_top"),
                @Model(name = "block/%s_window_small_up", template = "block/parent_window_small_up_overlay_top"),
                @Model(name = "block/%s_window_small_updown", template = "block/parent_window_small_updown_overlay_top"),
        }
)
public class TopOverlayWindowSmall extends WindowSmall {

    public TopOverlayWindowSmall(Settings properties) {
        super(properties);
    }
}