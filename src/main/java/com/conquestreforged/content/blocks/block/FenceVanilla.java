package com.conquestreforged.content.blocks.block;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import net.minecraft.block.FenceBlock;

@Assets(
        state = @State(name = "%s_fence", template = "parent_fence_vanilla"),
        item = @Model(name = "item/%s_fence", parent = "block/%s_fence_inventory", template = "item/acacia_fence"),
        block = {
                @Model(name = "block/%s_fence_side", template = "block/parent_fence_vanilla_side"),
                @Model(name = "block/%s_fence_post", template = "block/parent_fence_vanilla_post"),
                @Model(name = "block/%s_fence_inventory", template = "block/acacia_fence_inventory"),
        }
)
public class FenceVanilla extends FenceBlock {

    public FenceVanilla(Settings properties) {
        super(properties);
    }

}