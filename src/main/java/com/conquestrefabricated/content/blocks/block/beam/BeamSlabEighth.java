package com.conquestrefabricated.content.blocks.block.beam;

import com.conquestrefabricated.content.blocks.block.SlabEighth;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;

@Assets(
        state = @State(name = "%s_eighth_slab", template = "parent_slab_eighth_beam"),
        item = @Model(name = "item/%s_eighth_slab", parent = "block/%s_slab_eighth", template = "item/parent_slab_eighth"),
        block = {
                @Model(name = "block/%s_slab_eighth", template = "block/parent_slab_eighth_beam"),
                @Model(name = "block/%s_slab_eighth_top", template = "block/parent_slab_eighth_top_beam"),
        }
)
public class BeamSlabEighth extends SlabEighth {

   public BeamSlabEighth(Settings properties) {
        super(properties);
    }
}