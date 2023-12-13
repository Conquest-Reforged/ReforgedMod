package com.conquestrefabricated.content.blocks.block.overlay_top.inverted;

import com.conquestrefabricated.content.blocks.block.SlabQuarter;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.builder.Props;
import com.conquestrefabricated.core.util.RenderLayer;

@Assets(
        state = @State(name = "%s_quarter_slab", template = "parent_slab_quarter_overlay_top_inverted"),
        item = @Model(name = "item/%s_quarter_slab", parent = "block/%s_slab_quarter_4", template = "item/parent_slab_quarter"),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {
                @Model(name = "block/%s_slab_quarter_2", template = "block/parent_slab_quarter_overlay_top_inverted_2"),
                @Model(name = "block/%s_slab_quarter_4", template = "block/parent_slab_quarter_overlay_top_inverted_4"),
                @Model(name = "block/%s_slab_quarter_6", template = "block/parent_slab_quarter_overlay_top_inverted_6"),
                @Model(name = "block/%s_slab_quarter_2_top", template = "block/parent_slab_quarter_overlay_top_inverted_2_top"),
                @Model(name = "block/%s_slab_quarter_4_top", template = "block/parent_slab_quarter_overlay_top_inverted_4_top"),
                @Model(name = "block/%s_slab_quarter_6_top", template = "block/parent_slab_quarter_overlay_top_inverted_6_top")

        }
)
public class TopOverlayInvertedSlabQuarter extends SlabQuarter {

    public TopOverlayInvertedSlabQuarter(Props properties) {
        super(properties);
    }
}