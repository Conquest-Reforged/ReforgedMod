package com.conquestreforged.blocks.block.classical;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;

@Assets(
        state = @State(name = "%s_vertical_slab", template = "parent_doric_base_vertical_slab"),
        item = @Model(name = "item/%s_vertical_slab", parent = "block/%s_vertical_slab_4", template = "item/parent_vertical_slab"),
        block = {
                @Model(name = "block/%s_vertical_slab_2", template = "block/parent_doric_base_vertical_slab_2"),
                @Model(name = "block/%s_vertical_slab_2_e", template = "block/parent_doric_base_vertical_slab_2_e"),
                @Model(name = "block/%s_vertical_slab_2_es", template = "block/parent_doric_base_vertical_slab_2_es"),
                @Model(name = "block/%s_vertical_slab_2_ew", template = "block/parent_doric_base_vertical_slab_2_ew"),
                @Model(name = "block/%s_vertical_slab_2_esw", template = "block/parent_doric_base_vertical_slab_2_esw"),
                @Model(name = "block/%s_vertical_slab_2_s", template = "block/parent_doric_base_vertical_slab_2_s"),
                @Model(name = "block/%s_vertical_slab_2_sw", template = "block/parent_doric_base_vertical_slab_2_sw"),
                @Model(name = "block/%s_vertical_slab_2_w", template = "block/parent_doric_base_vertical_slab_2_w"),
                @Model(name = "block/%s_vertical_slab_4", template = "block/parent_doric_base_vertical_slab_4"),
                @Model(name = "block/%s_vertical_slab_4_e", template = "block/parent_doric_base_vertical_slab_4_e"),
                @Model(name = "block/%s_vertical_slab_4_es", template = "block/parent_doric_base_vertical_slab_4_es"),
                @Model(name = "block/%s_vertical_slab_4_ew", template = "block/parent_doric_base_vertical_slab_4_ew"),
                @Model(name = "block/%s_vertical_slab_4_esw", template = "block/parent_doric_base_vertical_slab_4_esw"),
                @Model(name = "block/%s_vertical_slab_4_s", template = "block/parent_doric_base_vertical_slab_4_s"),
                @Model(name = "block/%s_vertical_slab_4_sw", template = "block/parent_doric_base_vertical_slab_4_sw"),
                @Model(name = "block/%s_vertical_slab_4_w", template = "block/parent_doric_base_vertical_slab_4_w"),
                @Model(name = "block/%s_vertical_slab_6", template = "block/parent_doric_base_vertical_slab_6"),
                @Model(name = "block/%s_vertical_slab_6_e", template = "block/parent_doric_base_vertical_slab_6_e"),
                @Model(name = "block/%s_vertical_slab_6_es", template = "block/parent_doric_base_vertical_slab_6_es"),
                @Model(name = "block/%s_vertical_slab_6_ew", template = "block/parent_doric_base_vertical_slab_6_ew"),
                @Model(name = "block/%s_vertical_slab_6_esw", template = "block/parent_doric_base_vertical_slab_6_esw"),
                @Model(name = "block/%s_vertical_slab_6_s", template = "block/parent_doric_base_vertical_slab_6_s"),
                @Model(name = "block/%s_vertical_slab_6_sw", template = "block/parent_doric_base_vertical_slab_6_sw"),
                @Model(name = "block/%s_vertical_slab_6_w", template = "block/parent_doric_base_vertical_slab_6_w"),
        }
)
public class VerticalSlabBase extends VerticalSlabCapital {

    public VerticalSlabBase(Props properties) {
        super(properties);
    }
}
