package com.conquestreforged.blocks.block.tudor;

import com.conquestreforged.blocks.block.VerticalQuarterLessLayers;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.block.properties.Waterloggable;

@Assets(
        state = @State(name = "%s_vertical_quarter", template = "parent_vertical_quarter_tudor"),
        item = @Model(name = "item/%s_vertical_quarter", parent = "block/%s_vertical_quarter_4", template = "item/parent_vertical_quarter_tudor"),
        block = {
                @Model(name = "block/%s_vertical_quarter_2", template = "block/parent_vertical_quarter_tudor_2"),
                @Model(name = "block/%s_vertical_quarter_4", template = "block/parent_vertical_quarter_tudor_4"),
                @Model(name = "block/%s_vertical_quarter_6", template = "block/parent_vertical_quarter_tudor_6"),
        }
)
public class TudorVerticalQuarter extends VerticalQuarterLessLayers implements Waterloggable {

    public TudorVerticalQuarter(Props properties) {
        super(properties);
    }
}
