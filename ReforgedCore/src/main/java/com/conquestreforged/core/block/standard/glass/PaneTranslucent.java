package com.conquestreforged.core.block.standard.glass;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import net.minecraft.block.PaneBlock;
import net.minecraft.util.BlockRenderLayer;

@Assets(
        state = @State(name = "%s_pane", template = "parent_pane"),
        item = @Model(name = "item/%s_pane", parent = "block/%s_pane_ns", template = "item/parent_pane"),
        block = {
                @Model(name = "block/%s_pane_n", template = "block/parent_flatpane_n"),
                @Model(name = "block/%s_pane_ne", template = "block/parent_flatpane_ne"),
                @Model(name = "block/%s_pane_ns", template = "block/parent_flatpane_ns"),
                @Model(name = "block/%s_pane_nse", template = "block/parent_flatpane_nse"),
                @Model(name = "block/%s_pane_nsew", template = "block/parent_flatpane_nsew"),
                @Model(name = "block/%s_pane_post", template = "block/parent_flatpane_post"),
                @Model(name = "block/%s_pane_n_up", template = "block/parent_flatpane_n_up"),
                @Model(name = "block/%s_pane_ne_up", template = "block/parent_flatpane_ne_up"),
                @Model(name = "block/%s_pane_ns_up", template = "block/parent_flatpane_ns_up"),
                @Model(name = "block/%s_pane_nse_up", template = "block/parent_flatpane_nse_up"),
                @Model(name = "block/%s_pane_nsew_up", template = "block/parent_flatpane_nsew_up"),
                @Model(name = "block/%s_pane_post_up", template = "block/parent_flatpane_post_up")
        }
)
public class PaneTranslucent extends Pane {

    public PaneTranslucent(Properties properties) {
        super(properties);
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
}
