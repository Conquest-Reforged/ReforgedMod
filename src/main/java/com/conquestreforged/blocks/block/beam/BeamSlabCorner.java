package com.conquestreforged.blocks.block.beam;

import com.conquestreforged.blocks.block.SlabCorner;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;

@Assets(
        state = @State(name = "%s_corner_slab", template = "parent_slab_corner_beam"),
        item = @Model(name = "item/%s_corner_slab", parent = "block/%s_slab_corner", template = "item/parent_slab_corner"),
        block = {
                @Model(name = "block/%s_slab_corner", template = "block/parent_slab_corner_beam"),
                @Model(name = "block/%s_slab_corner_top", template = "block/parent_slab_corner_top_beam"),
        }
)
public class BeamSlabCorner extends SlabCorner {

    public BeamSlabCorner(Properties properties) {
        super(properties);
    }
}