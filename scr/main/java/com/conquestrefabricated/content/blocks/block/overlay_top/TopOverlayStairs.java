package com.conquestrefabricated.content.blocks.block.overlay_top;

import com.conquestrefabricated.content.blocks.block.Stairs;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.util.RenderLayer;
import net.minecraft.block.BlockState;

@Assets(
        state = @State(name = "%s_stairs", template = "parent_stairs_overlay_top"),
        item = @Model(name = "item/%s_stairs", parent = "block/%s_stairs", template = "item/acacia_stairs"),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {
                @Model(name = "block/%s_stairs", template = "block/parent_stairs_overlay_top"),
                @Model(name = "block/%s_stairs_outer", template = "block/parent_stairs_outer_overlay_top"),
                @Model(name = "block/%s_stairs_inner", template = "block/parent_stairs_inner_overlay_top"),
                @Model(name = "block/%s_stairs_top", template = "block/parent_stairs_top_overlay_top"),
                @Model(name = "block/%s_stairs_top_outer", template = "block/parent_stairs_outer_top_overlay_top"),
                @Model(name = "block/%s_stairs_top_inner", template = "block/parent_stairs_inner_top_overlay_top"),
        }
)
public class TopOverlayStairs extends Stairs {

    public TopOverlayStairs(BlockState parent, Settings properties) {
        super(parent, properties);
    }
}