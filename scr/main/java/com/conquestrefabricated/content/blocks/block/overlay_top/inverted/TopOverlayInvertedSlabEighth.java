package com.conquestrefabricated.content.blocks.block.overlay_top.inverted;

import com.conquestrefabricated.content.blocks.block.SlabEighth;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.util.RenderLayer;

@Assets(
        state = @State(name = "%s_eighth_slab", template = "parent_slab_eighth_overlay_top_inverted"),
        item = @Model(name = "item/%s_eighth_slab", parent = "block/%s_slab_eighth", template = "item/parent_slab_eighth"),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {
                @Model(name = "block/%s_slab_eighth", template = "block/parent_slab_eighth_overlay_top_inverted"),
                @Model(name = "block/%s_slab_eighth_top", template = "block/parent_slab_eighth_overlay_top_inverted_top"),
        }
)
public class TopOverlayInvertedSlabEighth extends SlabEighth {

    public TopOverlayInvertedSlabEighth(Settings properties) {
        super(properties);
    }
}