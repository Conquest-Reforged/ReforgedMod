package com.conquestrefabricated.content.blocks.block.tudor;

import com.conquestrefabricated.content.blocks.block.VerticalCornerLessLayers;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.builder.Props;
import com.conquestrefabricated.core.block.properties.Waterloggable;

@Assets(
        state = @State(name = "%s_vertical_corner", template = "parent_vertical_corner_tudor"),
        item = @Model(name = "item/%s_vertical_corner", parent = "block/%s_vertical_corner_4", template = "item/parent_vertical_corner_tudor"),
        block = {
                @Model(name = "block/%s_vertical_corner_2", template = "block/parent_vertical_corner_tudor_2"),
                @Model(name = "block/%s_vertical_corner_4", template = "block/parent_vertical_corner_tudor_4"),
                @Model(name = "block/%s_vertical_corner_6", template = "block/parent_vertical_corner_tudor_6"),
        }
)
public class TudorVerticalCorner extends VerticalCornerLessLayers implements Waterloggable {

    public TudorVerticalCorner(Props properties) {
        super(properties);
    }
}
