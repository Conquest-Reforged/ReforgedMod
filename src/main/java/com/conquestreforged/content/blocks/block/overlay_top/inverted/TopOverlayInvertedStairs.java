package com.conquestreforged.content.blocks.block.overlay_top.inverted;

import com.conquestreforged.content.blocks.block.Stairs;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.block.BlockState;

@Assets(
        state = @State(name = "%s_stairs", template = "parent_stairs_overlay_top_inverted"),
        item = @Model(name = "item/%s_stairs", parent = "block/%s_stairs", template = "item/acacia_stairs"),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {
                @Model(name = "block/%s_stairs", template = "block/parent_stairs_overlay_top_inverted"),
                @Model(name = "block/%s_stairs_outer", template = "block/parent_stairs_outer_overlay_top_inverted"),
                @Model(name = "block/%s_stairs_inner", template = "block/parent_stairs_inner_overlay_top_inverted"),
                @Model(name = "block/%s_stairs_top", template = "block/parent_stairs_top_overlay_top_inverted"),
                @Model(name = "block/%s_stairs_top_outer", template = "block/parent_stairs_outer_top_overlay_top_inverted"),
                @Model(name = "block/%s_stairs_top_inner", template = "block/parent_stairs_inner_top_overlay_top_inverted"),
        }
)
public class TopOverlayInvertedStairs extends Stairs {

    public TopOverlayInvertedStairs(BlockState parent, Settings properties) {
        super(parent, properties);
    }
}