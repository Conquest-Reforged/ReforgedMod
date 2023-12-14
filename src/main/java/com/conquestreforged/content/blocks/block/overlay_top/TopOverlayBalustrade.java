package com.conquestreforged.content.blocks.block.overlay_top;

import com.conquestreforged.content.blocks.block.Balustrade;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.util.RenderLayer;

@Assets(
        state = @State(name = "%s_balustrade", template = "parent_balustrade_overlay_top"),
        item = @Model(name = "item/%s_balustrade", parent = "block/%s_balustrade", template = "item/parent_balustrade"),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {
                @Model(name = "block/%s_balustrade", template = "block/parent_balustrade_overlay_top"),
                @Model(name = "block/%s_balustrade_base", template = "block/parent_balustrade_base_overlay_top"),
        }
)
public class TopOverlayBalustrade extends Balustrade {

    public TopOverlayBalustrade(Settings properties) {
        super(properties);
    }
}
