package com.conquestrefabricated.content.blocks.block.beam;

import com.conquestrefabricated.content.blocks.block.SlabQuarter;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.builder.Props;

@Assets(
        state = @State(name = "%s_quarter_slab", template = "parent_slab_quarter_beam"),
        item = @Model(name = "item/%s_quarter_slab", parent = "block/%s_slab_quarter_4", template = "item/parent_slab_quarter"),
        block = {
                @Model(name = "block/%s_slab_quarter_2", template = "block/parent_slab_quarter_2_beam"),
                @Model(name = "block/%s_slab_quarter_4", template = "block/parent_slab_quarter_4_beam"),
                @Model(name = "block/%s_slab_quarter_6", template = "block/parent_slab_quarter_6_beam"),
                @Model(name = "block/%s_slab_quarter_2_top", template = "block/parent_slab_quarter_2_top_beam"),
                @Model(name = "block/%s_slab_quarter_4_top", template = "block/parent_slab_quarter_4_top_beam"),
                @Model(name = "block/%s_slab_quarter_6_top", template = "block/parent_slab_quarter_6_top_beam")
        }
)
public class BeamSlabQuarter extends SlabQuarter {

    public BeamSlabQuarter(Props props) {
        super(props);
    }
}