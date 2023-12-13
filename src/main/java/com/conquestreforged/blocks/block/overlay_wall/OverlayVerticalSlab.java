package com.conquestreforged.blocks.block.overlay_wall;

import com.conquestreforged.blocks.block.VerticalSlab;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;

@Assets(
        state = @State(name = "%s_vertical_slab", template = "parent_vertical_slab_overlay"),
        item = @Model(name = "item/%s_vertical_slab", parent = "block/%s_vertical_slab_4", template = "item/parent_vertical_slab_tudor"),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {
                @Model(name = "block/%s_vertical_slab_1", template = "block/parent_vertical_slab_overlay_1"),
                @Model(name = "block/%s_vertical_slab_2", template = "block/parent_vertical_slab_overlay_2"),
                @Model(name = "block/%s_vertical_slab_4", template = "block/parent_vertical_slab_overlay_4"),
                @Model(name = "block/%s_vertical_slab_6", template = "block/parent_vertical_slab_overlay_6"),
        }
)
public class OverlayVerticalSlab extends VerticalSlab {

    public OverlayVerticalSlab(Props properties) {
        super(properties);
    }
}
