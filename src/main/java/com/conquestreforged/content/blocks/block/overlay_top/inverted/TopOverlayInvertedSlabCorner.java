package com.conquestreforged.content.blocks.block.overlay_top.inverted;

import com.conquestreforged.content.blocks.block.SlabCorner;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.util.RenderLayer;

@Assets(
        state = @State(name = "%s_corner_slab", template = "parent_slab_corner_overlay_top_inverted"),
        item = @Model(name = "item/%s_corner_slab", parent = "block/%s_slab_corner", template = "item/parent_slab_corner"),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {
                @Model(name = "block/%s_slab_corner", template = "block/parent_slab_corner_overlay_top_inverted"),
                @Model(name = "block/%s_slab_corner_top", template = "block/parent_slab_corner_overlay_top_inverted_top"),
        }
)
public class TopOverlayInvertedSlabCorner extends SlabCorner {

    public TopOverlayInvertedSlabCorner(Settings properties) {
        super(properties);
    }
}