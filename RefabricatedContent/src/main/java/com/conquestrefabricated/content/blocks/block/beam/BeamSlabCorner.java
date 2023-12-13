package com.conquestrefabricated.content.blocks.block.beam;

import com.conquestrefabricated.content.blocks.block.SlabCorner;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;

@Assets(
        state = @State(name = "%s_corner_slab", template = "parent_slab_corner_beam"),
        item = @Model(name = "item/%s_corner_slab", parent = "block/%s_slab_corner", template = "item/parent_slab_corner"),
        block = {
                @Model(name = "block/%s_slab_corner", template = "block/parent_slab_corner_beam"),
                @Model(name = "block/%s_slab_corner_top", template = "block/parent_slab_corner_top_beam"),
        }
)
public class BeamSlabCorner extends SlabCorner {

    public BeamSlabCorner(Settings properties) {
        super(properties);
    }
}