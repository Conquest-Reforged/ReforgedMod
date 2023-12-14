package com.conquestreforged.content.blocks.block;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import net.minecraft.block.BlockState;

@Assets(
        state = @State(name = "%s_platform", template = "parent_platform_vertical"),
        item = @Model(name = "item/%s_platform", parent = "block/%s_platform_vertical_top", template = "item/acacia_stairs"),
        block = {
                @Model(name = "block/%s_platform_vertical_bottom", template = "block/parent_platform_vertical_bottom"),
                @Model(name = "block/%s_platform_vertical_bottom_outer", template = "block/parent_platform_vertical_bottom_outer"),
                @Model(name = "block/%s_platform_vertical_bottom_inner", template = "block/parent_platform_vertical_bottom_inner"),
                @Model(name = "block/%s_platform_vertical_top", template = "block/parent_platform_vertical_top"),
                @Model(name = "block/%s_platform_vertical_top_outer", template = "block/parent_platform_vertical_top_outer"),
                @Model(name = "block/%s_platform_vertical_top_inner", template = "block/parent_platform_vertical_top_inner")
        }
)

public class PlatformVertical extends PlatformHorizontal {

    public PlatformVertical(BlockState parent, Settings properties) {
        super(parent, properties);
    }
}