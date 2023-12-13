package com.conquestreforged.blocks.block.overlay_top.inverted;

import com.conquestreforged.blocks.block.windows.ArrowSlit;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.util.RenderLayer;

@Assets(
        state = @State(name = "%s_arrowslit", template = "parent_arrowslit_overlay_top_inverted"),
        item = @Model(name = "item/%s_arrowslit", parent = "block/%s_arrowslit", template = "item/parent_arrowslit"),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {
                @Model(name = "block/%s_arrowslit", template = "block/parent_arrowslit_overlay_top_inverted"),
        }
)
public class TopOverlayInvertedArrowSlit extends ArrowSlit {

    public TopOverlayInvertedArrowSlit(Properties properties) {
        super(properties);
    }
}
