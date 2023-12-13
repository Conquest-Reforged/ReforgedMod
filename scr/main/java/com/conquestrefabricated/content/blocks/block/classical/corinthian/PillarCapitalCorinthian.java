package com.conquestrefabricated.content.blocks.block.classical.corinthian;

import com.conquestrefabricated.content.blocks.block.Pillar;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.builder.Props;
import com.conquestrefabricated.core.util.RenderLayer;

@Assets(
        state = @State(name = "%s_pillar", template = "parent_doric_capital_pillar"),
        item = @Model(name = "item/%s_pillar", parent = "block/%s_wall_post", template = "item/acacia_fence"),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {
                @Model(name = "block/%s_wall_post", template = "block/parent_doric_capital_wall_post"),
                @Model(name = "block/%s_pillar_2", template = "block/parent_doric_capital_pillar_2"),
                @Model(name = "block/%s_pillar_6", template = "block/parent_doric_capital_pillar_6")
        }
)
public class PillarCapitalCorinthian extends Pillar {

    public PillarCapitalCorinthian(Props properties) {
        super(properties);
    }
}
