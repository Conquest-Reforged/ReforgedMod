package com.conquestrefabricated.content.blocks.block.trees;

import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;
import net.minecraft.block.PillarBlock;

@Assets(
        state = @State(name = "%s", template = "parent_log"),
        item = @Model(name = "item/%s", parent = "block/%s", template = "item/acacia_log"),
        block = {
                @Model(name = "block/%s_horizontal", template = "block/parent_log_horizontal"),
                @Model(name = "block/%s", template = "block/parent_log")
        }
)
public class Log extends PillarBlock {

    public Log(Settings properties) {
        super(properties);
    }
}