package com.conquestreforged.blocks.block.overlay_top.inverted;

import com.conquestreforged.blocks.block.Balustrade;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.util.RenderLayer;

@Assets(
        state = @State(name = "%s_balustrade", template = "parent_balustrade_overlay_top_inverted"),
        item = @Model(name = "item/%s_balustrade", parent = "block/%s_balustrade", template = "item/parent_balustrade"),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {
                @Model(name = "block/%s_balustrade", template = "block/parent_balustrade_overlay_top_inverted"),
                @Model(name = "block/%s_balustrade_base", template = "block/parent_balustrade_base_overlay_top_inverted"),
        }
)
public class TopOverlayInvertedBalustrade extends Balustrade {

    public TopOverlayInvertedBalustrade(Properties properties) {
        super(properties);
    }
}
