package com.conquestreforged.content.blocks.block.classical;

import com.conquestreforged.content.blocks.block.VerticalCornerLessLayers;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.util.math.Direction;

@Assets(
        state = @State(name = "%s_vertical_corner", template = "parent_doric_base_vertical_corner"),
        item = @Model(name = "item/%s_vertical_corner", parent = "block/%s_vertical_corner_4", template = "item/parent_vertical_corner"),
        block = {
                @Model(name = "block/%s_vertical_corner_2", template = "block/parent_doric_base_vertical_corner_2"),
                @Model(name = "block/%s_vertical_corner_4", template = "block/parent_doric_base_vertical_corner_4"),
                @Model(name = "block/%s_vertical_corner_6", template = "block/parent_doric_base_vertical_corner_6"),
        }
)
public class VerticalCornerBase extends VerticalCornerLessLayers {

    public VerticalCornerBase(Props properties) {
        super(properties);
        this.setDefaultState((this.stateManager.getDefaultState()).with(DIRECTION, Direction.NORTH).with(WATERLOGGED, false));
    }
}
