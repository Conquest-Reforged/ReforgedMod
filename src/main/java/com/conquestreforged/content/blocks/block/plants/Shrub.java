package com.conquestreforged.content.blocks.block.plants;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.util.RenderLayer;

@Assets(
        state = @State(name = "%s", template = "parent_shrub"),
        item = @Model(name = "item/%s", parent = "block/%s_pane_ns", template = "item/parent_round_arch"),
        render = @Render(RenderLayer.CUTOUT),
        block = {
                @Model(name = "block/%s_shrub_model_1_a", template = "block/parent_shrub_model_1_a"),
                @Model(name = "block/%s_shrub_model_1_b", template = "block/parent_shrub_model_1_b"),
                @Model(name = "block/%s_plant_dense_model_1_c", template = "block/parent_plant_dense_model_1_c"),
                @Model(name = "block/%s_shrub_model_2_a", template = "block/parent_shrub_model_2_a"),
                @Model(name = "block/%s_shrub_model_2_b", template = "block/parent_shrub_model_2_b"),
                @Model(name = "block/%s_plant_dense_model_2_c", template = "block/parent_plant_dense_model_2_c"),
                @Model(name = "block/%s_shrub_model_3_a", template = "block/parent_shrub_model_3_a"),
                @Model(name = "block/%s_shrub_model_3_b", template = "block/parent_shrub_model_3_b"),
                @Model(name = "block/%s_plant_dense_model_3_c", template = "block/parent_plant_dense_model_3_c"),
                @Model(name = "block/%s_shrub_model_4_a", template = "block/parent_shrub_model_4_a"),
                @Model(name = "block/%s_shrub_model_4_b", template = "block/parent_shrub_model_4_b"),
                @Model(name = "block/%s_plant_dense_model_4_c", template = "block/parent_plant_dense_model_4_c"),
                @Model(name = "block/%s_shrub_model_5_a", template = "block/parent_shrub_model_5_a"),
                @Model(name = "block/%s_shrub_model_5_b", template = "block/parent_shrub_model_5_b"),
                @Model(name = "block/%s_plant_dense_model_5_c", template = "block/parent_plant_dense_model_5_c"),
                @Model(name = "block/%s_shrub_model_6_a", template = "block/parent_shrub_model_6_a"),
                @Model(name = "block/%s_shrub_model_6_b", template = "block/parent_shrub_model_6_b"),
                @Model(name = "block/%s_plant_dense_model_6_c", template = "block/parent_plant_dense_model_6_c"),
                @Model(name = "block/%s_shrub_model_7_a", template = "block/parent_shrub_model_7_a"),
                @Model(name = "block/%s_shrub_model_7_b", template = "block/parent_shrub_model_7_b"),
                @Model(name = "block/%s_plant_dense_model_7_c", template = "block/parent_plant_dense_model_7_c"),
                @Model(name = "block/%s_shrub_model_8_a", template = "block/parent_shrub_model_8_a"),
                @Model(name = "block/%s_shrub_model_8_b", template = "block/parent_shrub_model_8_b"),
                @Model(name = "block/%s_plant_dense_model_8_c", template = "block/parent_plant_dense_model_8_c"),
                @Model(name = "block/%s_pane_ns", template = "block/parent_flatpane_ns"),
        }
)
public class Shrub extends Bush {

    public Shrub(Settings properties) {
        super(properties);
    }
}
