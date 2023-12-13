package com.conquestreforged.blocks.block.overlay_top;

import com.conquestreforged.blocks.block.VerticalSlabCorner;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.util.RenderLayer;

@Assets(
        state = @State(name = "%s_vertical_corner_slab", template = "parent_vertical_corner_slab_overlay_top"),
        item = @Model(name = "item/%s_vertical_corner_slab", parent = "block/%s_vertical_corner_slab_left", template = "item/parent_slab_corner"),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {
                @Model(name = "block/%s_vertical_corner_slab_left", template = "block/parent_vertical_corner_slab_left_overlay_top"),
                @Model(name = "block/%s_vertical_corner_slab_bottom_left", template = "block/parent_vertical_corner_slab_bottom_left_overlay_top"),
                @Model(name = "block/%s_vertical_corner_slab_right", template = "block/parent_vertical_corner_slab_right_overlay_top"),
                @Model(name = "block/%s_vertical_corner_slab_bottom_right", template = "block/parent_vertical_corner_slab_bottom_right_overlay_top"),
        }
)
public class TopOverlayVerticalSlabCorner extends VerticalSlabCorner {

    public TopOverlayVerticalSlabCorner(Properties properties) {
        super(properties);
    }
}