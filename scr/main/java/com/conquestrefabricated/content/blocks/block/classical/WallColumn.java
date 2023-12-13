package com.conquestrefabricated.content.blocks.block.classical;

import com.conquestrefabricated.content.blocks.block.WallOld;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;

@Assets(
        state = @State(name = "%s_wall", template = "parent_column_wall"),
        item = @Model(name = "item/%s_wall", parent = "block/%s_wall_inventory", template = "item/cobblestone_wall"),
        block = {
                @Model(name = "block/%s_wall_post", template = "block/parent_column_wall_post"),
                @Model(name = "block/%s_wall_n", template = "block/parent_column_wall_n"),
                @Model(name = "block/%s_wall_ne", template = "block/parent_column_wall_ne"),
                @Model(name = "block/%s_wall_ns", template = "block/parent_column_wall_ns"),
                @Model(name = "block/%s_wall_nse", template = "block/parent_column_wall_nse"),
                @Model(name = "block/%s_wall_nsew", template = "block/parent_column_wall_nsew"),
                @Model(name = "block/%s_wall_inventory", template = "block/parent_wall_inventory"),
        }
)
public class WallColumn extends WallOld {

    public WallColumn(Settings properties) {
        super(properties);
    }
}
