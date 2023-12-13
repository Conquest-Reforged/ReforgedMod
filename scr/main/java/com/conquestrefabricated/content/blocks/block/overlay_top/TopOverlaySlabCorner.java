package com.conquestrefabricated.content.blocks.block.overlay_top;

import com.conquestrefabricated.content.blocks.block.SlabCorner;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.util.RenderLayer;

@Assets(
        state = @State(name = "%s_corner_slab", template = "parent_slab_corner_overlay_top"),
        item = @Model(name = "item/%s_corner_slab", parent = "block/%s_slab_corner", template = "item/parent_slab_corner"),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {
                @Model(name = "block/%s_slab_corner", template = "block/parent_slab_corner_overlay_top"),
                @Model(name = "block/%s_slab_corner_top", template = "block/parent_slab_corner_overlay_top_top"),
        }
)
public class TopOverlaySlabCorner extends SlabCorner {

    public TopOverlaySlabCorner(Settings properties) {
        super(properties);
    }
}