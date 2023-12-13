package com.conquestreforged.blocks.block.overlay_top;

import com.conquestreforged.blocks.block.Pillar;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;


@Assets(
        state = @State(name = "%s_pillar", template = "parent_pillar_overlay_top"),
        item = @Model(name = "item/%s_pillar", parent = "block/%s_pillar_4", template = "item/dragon_egg"),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {
                @Model(name = "block/%s_pillar_2", template = "block/parent_pillar_2_overlay_top"),
                @Model(name = "block/%s_pillar_4", template = "block/parent_pillar_4_overlay_top"),
                @Model(name = "block/%s_pillar_6", template = "block/parent_pillar_6_overlay_top"),
        }
)
public class TopOverlayPillar extends Pillar {

    public TopOverlayPillar(Props properties) {
        super(properties);
    }
}
