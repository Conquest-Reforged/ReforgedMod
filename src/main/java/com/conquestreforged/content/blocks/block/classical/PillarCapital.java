package com.conquestreforged.content.blocks.block.classical;

import com.conquestreforged.content.blocks.block.Pillar;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;

@Assets(
        state = @State(name = "%s_pillar", template = "parent_doric_capital_pillar"),
        item = @Model(name = "item/%s_pillar", parent = "block/%s_wall_post", template = "item/acacia_fence"),
        block = {
                @Model(name = "block/%s_wall_post", template = "block/parent_doric_capital_wall_post"),
                @Model(name = "block/%s_pillar_2", template = "block/parent_doric_capital_pillar_2"),
                @Model(name = "block/%s_pillar_6", template = "block/parent_doric_capital_pillar_6")
        }
)
public class PillarCapital extends Pillar {

    public PillarCapital(Props properties) {
        super(properties);
    }


}