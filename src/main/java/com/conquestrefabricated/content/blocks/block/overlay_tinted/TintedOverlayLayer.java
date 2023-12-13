package com.conquestrefabricated.content.blocks.block.overlay_tinted;

import com.conquestrefabricated.content.blocks.block.Layer;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.builder.Props;
import com.conquestrefabricated.core.util.RenderLayer;

@Assets(
        state = @State(name = "%s_layer", template = "parent_layer_overlay_tinted"),
        item = @Model(name = "item/%s_layer", parent = "block/%s_slab_bottom_4", template = "item/acacia_slab"),
        render = @Render(RenderLayer.TRANSLUCENT),
        block = {
                @Model(name = "block/%s_slab_bottom_1", template = "block/parent_slab_bottom_1_overlay_tinted"),
                @Model(name = "block/%s_slab_bottom_2", template = "block/parent_slab_bottom_2_overlay_tinted"),
                @Model(name = "block/%s_slab_bottom_3", template = "block/parent_slab_bottom_3_overlay_tinted"),
                @Model(name = "block/%s_slab_bottom_4", template = "block/parent_slab_bottom_4_overlay_tinted"),
                @Model(name = "block/%s_slab_bottom_5", template = "block/parent_slab_bottom_5_overlay_tinted"),
                @Model(name = "block/%s_slab_bottom_6", template = "block/parent_slab_bottom_6_overlay_tinted"),
                @Model(name = "block/%s_slab_bottom_7", template = "block/parent_slab_bottom_7_overlay_tinted"),
                @Model(name = "block/%s_slab_bottom_8", template = "block/parent_cube")
        }
)
public class TintedOverlayLayer extends Layer {

    public TintedOverlayLayer(Props props) {
        super(props);
    }
}