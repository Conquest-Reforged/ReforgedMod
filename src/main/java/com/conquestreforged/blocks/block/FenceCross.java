package com.conquestreforged.blocks.block;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import net.minecraft.world.level.block.FenceBlock;

@Assets(
        state = @State(name = "%s_fence", template = "parent_wooden_rail_fence"),
        item = @Model(name = "item/%s_fence", parent = "block/%s_fence_inventory", template = "item/acacia_fence"),
        block = {
                @Model(name = "block/%s_fence_post", template = "block/parent_wooden_rail_fence_post"),
                @Model(name = "block/%s_fence_n", template = "block/parent_wooden_rail_fence_n"),
                @Model(name = "block/%s_fence_ne", template = "block/parent_wooden_rail_fence_ne"),
                @Model(name = "block/%s_fence_ns", template = "block/parent_wooden_rail_fence_ns"),
                @Model(name = "block/%s_fence_nse", template = "block/parent_wooden_rail_fence_nse"),
                @Model(name = "block/%s_fence_nsew", template = "block/parent_wooden_rail_fence_nsew"),
                @Model(name = "block/%s_fence_inventory", template = "block/parent_wooden_rail_fence_inventory"),
        }
)
public class FenceCross extends FenceBlock {

    public FenceCross(Properties properties) {
        super(properties);
    }

}