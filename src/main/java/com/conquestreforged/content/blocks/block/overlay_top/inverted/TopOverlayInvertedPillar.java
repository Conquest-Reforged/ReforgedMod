package com.conquestreforged.content.blocks.block.overlay_top.inverted;

import com.conquestreforged.content.blocks.block.Pillar;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;


@Assets(
        state = @State(name = "%s_pillar", template = "parent_pillar_overlay_top_inverted"),
        item = @Model(name = "item/%s_pillar", parent = "block/%s_pillar_4", template = "item/dragon_egg"),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {
                @Model(name = "block/%s_pillar_2", template = "block/parent_pillar_2_overlay_top_inverted"),
                @Model(name = "block/%s_pillar_4", template = "block/parent_pillar_4_overlay_top_inverted"),
                @Model(name = "block/%s_pillar_6", template = "block/parent_pillar_6_overlay_top_inverted"),
        }
)
public class TopOverlayInvertedPillar extends Pillar {

    public TopOverlayInvertedPillar(Props properties) {
        super(properties);
    }
}
