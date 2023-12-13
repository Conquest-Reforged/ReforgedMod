package com.conquestreforged.blocks.block.classical.corinthian;

import com.conquestreforged.blocks.block.WallOld;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.util.RenderLayer;

@Assets(
        state = @State(name = "%s_wall", template = "parent_doric_capital_wall"),
        item = @Model(name = "item/%s_wall", parent = "block/%s_wall_inventory", template = "item/cobblestone_wall"),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {
                @Model(name = "block/%s_wall_post", template = "block/parent_doric_capital_wall_post"),
                @Model(name = "block/%s_wall_n", template = "block/parent_doric_capital_wall_n"),
                @Model(name = "block/%s_wall_ne", template = "block/parent_doric_capital_wall_ne"),
                @Model(name = "block/%s_wall_ns", template = "block/parent_doric_capital_wall_ns"),
                @Model(name = "block/%s_wall_nse", template = "block/parent_doric_capital_wall_nse"),
                @Model(name = "block/%s_wall_nsew", template = "block/parent_doric_capital_wall_nsew"),
                @Model(name = "block/%s_wall_inventory", template = "block/parent_wall_inventory"),
        }
)
public class WallCapitalCorinthian extends WallOld {

    public WallCapitalCorinthian(Properties properties) {
        super(properties);
    }
}
