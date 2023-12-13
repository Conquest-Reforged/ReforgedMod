package com.conquestreforged.blocks.block;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;

@Assets(
        state = @State(name = "%s_wall", template = "parent_wall"),
        item = @Model(name = "item/%s_wall", parent = "block/%s_wall_inventory", template = "item/cobblestone_wall"),
        block = {
                @Model(name = "block/%s_wall_post", template = "block/parent_wall_post"),
                @Model(name = "block/%s_wall_n", template = "block/parent_wall_n"),
                @Model(name = "block/%s_wall_ne", template = "block/parent_wall_ne"),
                @Model(name = "block/%s_wall_nse", template = "block/parent_wall_nse"),
                @Model(name = "block/%s_wall_nsew", template = "block/parent_wall_nsew"),
                @Model(name = "block/%s_wall_ns", template = "block/parent_wall_ns"),
                @Model(name = "block/%s_wall_ns_above", template = "block/parent_wall_ns_above"),
                @Model(name = "block/%s_wall_inventory", template = "block/parent_wall_inventory"),
        }
)
public class Wall extends WallOld {

    public Wall(Properties properties) {
        super(properties);
    }
}
