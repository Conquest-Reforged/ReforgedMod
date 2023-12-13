package com.conquestrefabricated.content.blocks.block.classical;

import com.conquestrefabricated.content.blocks.block.VerticalCornerLessLayers;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.builder.Props;
import net.minecraft.util.math.Direction;

@Assets(
        state = @State(name = "%s_vertical_corner", template = "parent_doric_capital_vertical_corner"),
        item = @Model(name = "item/%s_vertical_corner", parent = "block/%s_vertical_corner_4", template = "item/parent_vertical_corner"),
        block = {
                @Model(name = "block/%s_vertical_corner_2", template = "block/parent_doric_capital_vertical_corner_2"),
                @Model(name = "block/%s_vertical_corner_4", template = "block/parent_doric_capital_vertical_corner_4"),
                @Model(name = "block/%s_vertical_corner_6", template = "block/parent_doric_capital_vertical_corner_6"),
        }
)
public class VerticalCornerCapital extends VerticalCornerLessLayers {

    public VerticalCornerCapital(Props properties) {
        super(properties);
        this.setDefaultState((this.stateManager.getDefaultState()).with(DIRECTION, Direction.NORTH).with(WATERLOGGED, false));

    }
}
