package com.conquestreforged.blocks.block.overlay_top.inverted;

import com.conquestreforged.blocks.block.VerticalSlab;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;

@Assets(
        state = @State(name = "%s_vertical_slab", template = "parent_vertical_slab_overlay_top_inverted"),
        item = @Model(name = "item/%s_vertical_slab", parent = "block/%s_vertical_slab_4", template = "item/parent_vertical_slab_tudor"),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {
                @Model(name = "block/%s_vertical_slab_1", template = "block/parent_vertical_slab_1_overlay_top_inverted"),
                @Model(name = "block/%s_vertical_slab_2", template = "block/parent_vertical_slab_2_overlay_top_inverted"),
                @Model(name = "block/%s_vertical_slab_4", template = "block/parent_vertical_slab_4_overlay_top_inverted"),
                @Model(name = "block/%s_vertical_slab_6", template = "block/parent_vertical_slab_6_overlay_top_inverted"),
        }
)
public class TopOverlayInvertedVerticalSlab extends VerticalSlab {

    public TopOverlayInvertedVerticalSlab(Props properties) {
        super(properties);
    }
}
