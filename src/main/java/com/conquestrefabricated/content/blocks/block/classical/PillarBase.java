package com.conquestrefabricated.content.blocks.block.classical;

import com.conquestrefabricated.content.blocks.block.Pillar;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.builder.Props;

@Assets(
        state = @State(name = "%s_pillar", template = "parent_doric_base_pillar"),
        item = @Model(name = "item/%s_pillar", parent = "block/%s_wall_post", template = "item/acacia_fence"),
        block = {
                @Model(name = "block/%s_wall_post", template = "block/parent_doric_base_wall_post"),
                @Model(name = "block/%s_pillar_2", template = "block/parent_doric_base_pillar_2"),
                @Model(name = "block/%s_pillar_6", template = "block/parent_doric_base_pillar_6")
        }
)
public class PillarBase extends Pillar {

    public PillarBase(Props properties) {
        super(properties);
    }


}
