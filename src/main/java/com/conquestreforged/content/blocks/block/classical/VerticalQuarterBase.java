package com.conquestreforged.content.blocks.block.classical;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;

@Assets(
        state = @State(name = "%s_vertical_quarter", template = "parent_doric_base_vertical_quarter"),
        item = @Model(name = "item/%s_vertical_quarter", parent = "block/%s_vertical_quarter_4", template = "item/parent_vertical_quarter"),
        block = {
                @Model(name = "block/%s_vertical_quarter_2", template = "block/parent_doric_base_vertical_quarter_2"),
                @Model(name = "block/%s_vertical_quarter_2_e", template = "block/parent_doric_base_vertical_quarter_2_e"),
                @Model(name = "block/%s_vertical_quarter_2_es", template = "block/parent_doric_base_vertical_quarter_2_es"),
                @Model(name = "block/%s_vertical_quarter_2_s", template = "block/parent_doric_base_vertical_quarter_2_s"),
                @Model(name = "block/%s_vertical_quarter_4", template = "block/parent_doric_base_vertical_quarter_4"),
                @Model(name = "block/%s_vertical_quarter_4_e", template = "block/parent_doric_base_vertical_quarter_4_e"),
                @Model(name = "block/%s_vertical_quarter_4_es", template = "block/parent_doric_base_vertical_quarter_4_es"),
                @Model(name = "block/%s_vertical_quarter_4_s", template = "block/parent_doric_base_vertical_quarter_4_s"),
                @Model(name = "block/%s_vertical_quarter_6", template = "block/parent_doric_base_vertical_quarter_6"),
                @Model(name = "block/%s_vertical_quarter_6_e", template = "block/parent_doric_base_vertical_quarter_6_e"),
                @Model(name = "block/%s_vertical_quarter_6_es", template = "block/parent_doric_base_vertical_quarter_6_es"),
                @Model(name = "block/%s_vertical_quarter_6_s", template = "block/parent_doric_base_vertical_quarter_6_s"),
        }
)
public class VerticalQuarterBase extends VerticalQuarterCapital {

    public VerticalQuarterBase(Props properties) {
        super(properties);
    }
}
