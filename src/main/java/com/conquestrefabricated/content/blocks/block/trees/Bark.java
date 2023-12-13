package com.conquestrefabricated.content.blocks.block.trees;

import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;
import net.minecraft.block.PillarBlock;

@Assets(
        state = @State(name = "%s_bark", template = "parent_bark"),
        item = @Model(name = "item/%s_bark", parent = "block/%s_bark", template = "item/parent_bark"),
        block = {
                @Model(name = "block/%s_bark", template = "block/parent_bark")
        }
)
public class Bark extends PillarBlock {

    public Bark(Settings properties) {
        super(properties);
    }
}