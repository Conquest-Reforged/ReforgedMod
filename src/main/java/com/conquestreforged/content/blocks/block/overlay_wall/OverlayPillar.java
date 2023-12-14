package com.conquestreforged.content.blocks.block.overlay_wall;

import com.conquestreforged.content.blocks.block.Pillar;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;

@Assets(
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        state = @State(name = "%s_pillar", template = "parent_pillar_overlay"),
        item = @Model(name = "item/%s_pillar", parent = "block/%s_pillar_4", template = "item/dragon_egg"),
        block = {
                @Model(name = "block/%s_pillar_2", template = "block/parent_pillar_overlay_2"),
                @Model(name = "block/%s_pillar_4", template = "block/parent_pillar_overlay_4"),
                @Model(name = "block/%s_pillar_6", template = "block/parent_pillar_overlay_6"),
        }
)
public class OverlayPillar extends Pillar {

    public OverlayPillar(Props properties) {
        super(properties);
    }
}
