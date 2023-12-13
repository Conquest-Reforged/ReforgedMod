package com.conquestreforged.blocks.block;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import net.minecraft.world.level.block.FenceBlock;

@Assets(
        state = @State(name = "%s_fence", template = "parent_fence"),
        item = @Model(name = "item/%s_fence", parent = "block/%s_fence_ns_1", template = "item/acacia_fence"),
        block = {
                @Model(name = "block/%s_fence_post", template = "block/parent_fence_post"),
                @Model(name = "block/%s_fence_n_1", template = "block/parent_fence_n_1"),
                @Model(name = "block/%s_fence_n_2", template = "block/parent_fence_n_2"),
                @Model(name = "block/%s_fence_ne_1", template = "block/parent_fence_ne_1"),
                @Model(name = "block/%s_fence_ne_2", template = "block/parent_fence_ne_2"),
                @Model(name = "block/%s_fence_ns_1", template = "block/parent_fence_ns_1"),
                @Model(name = "block/%s_fence_ns_2", template = "block/parent_fence_ns_2"),
                @Model(name = "block/%s_fence_nse", template = "block/parent_fence_nse"),
                @Model(name = "block/%s_fence_nsew", template = "block/parent_fence_nsew"),
        }
)
public class Fence extends FenceBlock {

    public Fence(Properties properties) {
        super(properties);
    }

}