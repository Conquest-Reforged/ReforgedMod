package com.conquestreforged.content.blocks.block.overlay_top.inverted;

import com.conquestreforged.content.blocks.block.Slab;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;

@Assets(
        state = @State(name = "%s_slab", template = "parent_slab_overlay_top_inverted"),
        item = @Model(name = "item/%s_slab", parent = "block/%s_slab_bottom_4", template = "item/acacia_slab"),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {
                @Model(name = "block/%s_slab_bottom_1", template = "block/parent_slab_bottom_1_overlay_top_inverted"),
                @Model(name = "block/%s_slab_bottom_2", template = "block/parent_slab_bottom_2_overlay_top_inverted"),
                @Model(name = "block/%s_slab_bottom_3", template = "block/parent_slab_bottom_3_overlay_top_inverted"),
                @Model(name = "block/%s_slab_bottom_4", template = "block/parent_slab_bottom_4_overlay_top_inverted"),
                @Model(name = "block/%s_slab_bottom_5", template = "block/parent_slab_bottom_5_overlay_top_inverted"),
                @Model(name = "block/%s_slab_bottom_6", template = "block/parent_slab_bottom_6_overlay_top_inverted"),
                @Model(name = "block/%s_slab_bottom_7", template = "block/parent_slab_bottom_7_overlay_top_inverted"),
                @Model(name = "block/%s_slab_top_1", template = "block/parent_slab_top_1_overlay_top_inverted"),
                @Model(name = "block/%s_slab_top_2", template = "block/parent_slab_top_2_overlay_top_inverted"),
                @Model(name = "block/%s_slab_top_3", template = "block/parent_slab_top_3_overlay_top_inverted"),
                @Model(name = "block/%s_slab_top_4", template = "block/parent_slab_top_4_overlay_top_inverted"),
                @Model(name = "block/%s_slab_top_5", template = "block/parent_slab_top_5_overlay_top_inverted"),
                @Model(name = "block/%s_slab_top_6", template = "block/parent_slab_top_6_overlay_top_inverted"),
                @Model(name = "block/%s_slab_top_7", template = "block/parent_slab_top_7_overlay_top_inverted"),
                @Model(name = "block/%s", template = "block/parent_cube"),
        }
)
public class TopOverlayInvertedSlab extends Slab {


    public TopOverlayInvertedSlab(Props props) {
        super(props);
    }
}