package com.conquestrefabricated.content.blocks.block;

import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.util.RenderLayer;

@Assets(
        state = @State(name = "%s_boards", template = "parent_boards_vertical"),
        item = @Model(name = "item/%s_boards", parent = "block/%s_boards_lower", template = "item/acacia_slab"),
        render = @Render(RenderLayer.CUTOUT),
        block = {
                @Model(name = "block/%s_boards_lower", template = "block/parent_boards_vertical_lower"),
                @Model(name = "block/%s_boards_upper", template = "block/parent_boards_vertical_upper"),
        }
)
public class BoardsVertical extends BoardsHorizontal {

    public BoardsVertical(Settings properties) {
        super(properties);
    }
}