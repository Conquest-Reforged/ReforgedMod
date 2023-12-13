package com.conquestrefabricated.content.blocks.block.beam;

import com.conquestrefabricated.content.blocks.block.SlabLessLayers;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.builder.Props;

@Assets(
        state = @State(name = "%s_slab", template = "parent_slab_lesslayers_beam"),
        item = @Model(name = "item/%s_slab", parent = "block/%s_slab_bottom_4", template = "item/acacia_slab"),
        block = {
                @Model(name = "block/%s_slab_bottom_1", template = "block/parent_slab_bottom_1_beam"),
                @Model(name = "block/%s_slab_bottom_2", template = "block/parent_slab_bottom_2_beam"),
                @Model(name = "block/%s_slab_bottom_4", template = "block/parent_slab_bottom_4_beam"),
                @Model(name = "block/%s_slab_bottom_6", template = "block/parent_slab_bottom_6_beam"),
                @Model(name = "block/%s_slab_top_1", template = "block/parent_slab_top_1_beam"),
                @Model(name = "block/%s_slab_top_2", template = "block/parent_slab_top_2_beam"),
                @Model(name = "block/%s_slab_top_4", template = "block/parent_slab_top_4_beam"),
                @Model(name = "block/%s_slab_top_6", template = "block/parent_slab_top_6_beam"),
        }
)
public class BeamSlabLessLayers extends SlabLessLayers {

    public BeamSlabLessLayers(Props props) {
        super(props);
    }
}