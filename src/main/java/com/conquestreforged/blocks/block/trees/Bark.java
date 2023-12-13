package com.conquestreforged.blocks.block.trees;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import net.minecraft.world.level.block.RotatedPillarBlock;

@Assets(
        state = @State(name = "%s_bark", template = "parent_bark"),
        item = @Model(name = "item/%s_bark", parent = "block/%s_bark", template = "item/parent_bark"),
        block = {
                @Model(name = "block/%s_bark", template = "block/parent_bark")
        }
)
public class Bark extends RotatedPillarBlock {

    public Bark(Properties properties) {
        super(properties);
    }
}