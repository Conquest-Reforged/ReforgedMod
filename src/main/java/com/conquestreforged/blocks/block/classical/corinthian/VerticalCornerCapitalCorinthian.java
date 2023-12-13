package com.conquestreforged.blocks.block.classical.corinthian;

import com.conquestreforged.blocks.block.VerticalCornerLessLayers;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.Direction;

@Assets(
        state = @State(name = "%s_vertical_corner", template = "parent_doric_capital_vertical_corner"),
        item = @Model(name = "item/%s_vertical_corner", parent = "block/%s_vertical_corner_4", template = "item/parent_vertical_corner"),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {
                @Model(name = "block/%s_vertical_corner_2", template = "block/parent_doric_capital_vertical_corner_2"),
                @Model(name = "block/%s_vertical_corner_4", template = "block/parent_doric_capital_vertical_corner_4"),
                @Model(name = "block/%s_vertical_corner_6", template = "block/parent_doric_capital_vertical_corner_6"),
        }
)
public class VerticalCornerCapitalCorinthian extends VerticalCornerLessLayers {

    public VerticalCornerCapitalCorinthian(Props properties) {
        super(properties);
        this.registerDefaultState((this.stateDefinition.any()).setValue(DIRECTION, Direction.NORTH).setValue(WATERLOGGED, false));

    }
}
