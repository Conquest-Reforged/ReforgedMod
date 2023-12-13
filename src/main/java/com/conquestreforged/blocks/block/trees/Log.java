package com.conquestreforged.blocks.block.trees;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import net.minecraft.world.level.block.RotatedPillarBlock;

@Assets(
        state = @State(name = "%s", template = "parent_log"),
        item = @Model(name = "item/%s", parent = "block/%s", template = "item/acacia_log"),
        block = {
                @Model(name = "block/%s_horizontal", template = "block/parent_log_horizontal"),
                @Model(name = "block/%s", template = "block/parent_log")
        }
)
public class Log extends RotatedPillarBlock {

    public Log(Properties properties) {
        super(properties);
    }
}