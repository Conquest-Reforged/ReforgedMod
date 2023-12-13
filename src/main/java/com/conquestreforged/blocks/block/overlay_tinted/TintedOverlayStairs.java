package com.conquestreforged.blocks.block.overlay_tinted;

import com.conquestreforged.blocks.block.Stairs;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.world.level.block.state.BlockState;

@Assets(
        state = @State(name = "%s_stairs", template = "parent_stairs_overlay_tinted"),
        item = @Model(name = "item/%s_stairs", parent = "block/%s_stairs", template = "item/acacia_stairs"),
        render = @Render(RenderLayer.TRANSLUCENT),
        block = {
                @Model(name = "block/%s_stairs", template = "block/parent_stairs_overlay_tinted"),
                @Model(name = "block/%s_stairs_outer", template = "block/parent_stairs_outer_overlay_tinted"),
                @Model(name = "block/%s_stairs_inner", template = "block/parent_stairs_inner_overlay_tinted"),
                @Model(name = "block/%s_stairs_top", template = "block/parent_stairs_top_overlay_tinted"),
                @Model(name = "block/%s_stairs_top_outer", template = "block/parent_stairs_outer_top_overlay_tinted"),
                @Model(name = "block/%s_stairs_top_inner", template = "block/parent_stairs_inner_top_overlay_tinted"),
        }
)
public class TintedOverlayStairs extends Stairs {

    public TintedOverlayStairs(BlockState parent, Properties properties) {
        super(parent, properties);
    }
}