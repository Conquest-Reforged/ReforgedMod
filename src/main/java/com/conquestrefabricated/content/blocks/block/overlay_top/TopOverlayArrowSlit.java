package com.conquestrefabricated.content.blocks.block.overlay_top;

import com.conquestrefabricated.content.blocks.block.windows.ArrowSlit;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.util.RenderLayer;

@Assets(
        state = @State(name = "%s_arrowslit", template = "parent_arrowslit_overlay_top"),
        item = @Model(name = "item/%s_arrowslit", parent = "block/%s_arrowslit", template = "item/parent_arrowslit"),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {
                @Model(name = "block/%s_arrowslit", template = "block/parent_arrowslit_overlay_top"),
        }
)
public class TopOverlayArrowSlit extends ArrowSlit {

    public TopOverlayArrowSlit(Settings properties) {
        super(properties);
    }
}
