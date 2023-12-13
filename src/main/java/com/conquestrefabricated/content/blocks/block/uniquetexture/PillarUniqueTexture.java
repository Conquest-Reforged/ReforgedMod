package com.conquestrefabricated.content.blocks.block.uniquetexture;

import com.conquestrefabricated.content.blocks.block.Pillar;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.builder.Props;

@Assets(
        state = @State(name = "%s_pillar", template = "parent_pillar_unique_texture"),
        item = @Model(name = "item/%s_pillar", parent = "block/%s_pillar_unique_texture_4", template = "item/dragon_egg"),
        block = {
                @Model(name = "block/%s_pillar_unique_texture_2", template = "block/parent_pillar_unique_texture_2"),
                @Model(name = "block/%s_pillar_unique_texture_4", template = "block/parent_pillar_unique_texture_4"),
                @Model(name = "block/%s_pillar_unique_texture_6", template = "block/parent_pillar_unique_texture_6"),
        }
)
public class PillarUniqueTexture extends Pillar {

    public PillarUniqueTexture(Props properties) {
        super(properties);
    }
}
