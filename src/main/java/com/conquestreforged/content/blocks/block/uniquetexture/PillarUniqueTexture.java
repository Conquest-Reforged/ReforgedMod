package com.conquestreforged.content.blocks.block.uniquetexture;

import com.conquestreforged.content.blocks.block.Pillar;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;

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
