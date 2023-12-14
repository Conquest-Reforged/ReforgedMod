package com.conquestreforged.content.blocks.block.uniquetexture;

import com.conquestreforged.content.blocks.block.Wall;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;

@Assets(
        state = @State(name = "%s_wall", template = "parent_wall_unique_texture"),
        item = @Model(name = "item/%s_wall", parent = "block/%s_wall_inventory", template = "item/cobblestone_wall"),
        block = {
                @Model(name = "block/%s_wall_post", template = "block/parent_wall_unique_texture_post"),
                @Model(name = "block/%s_wall_n", template = "block/parent_wall_unique_texture_n"),
                @Model(name = "block/%s_wall_ne", template = "block/parent_wall_unique_texture_ne"),
                @Model(name = "block/%s_wall_nse", template = "block/parent_wall_unique_texture_nse"),
                @Model(name = "block/%s_wall_nsew", template = "block/parent_wall_unique_texture_nsew"),
                @Model(name = "block/%s_wall_ns", template = "block/parent_wall_unique_texture_ns"),
                @Model(name = "block/%s_wall_ns_above", template = "block/parent_wall_unique_texture_ns_above"),
                @Model(name = "block/%s_wall_inventory", template = "block/parent_wall_unique_texture_inventory"),
        }
)
public class WallUniqueTexture extends Wall {

    public WallUniqueTexture(Props props) {
        super(props.toSettings());
    }
}
