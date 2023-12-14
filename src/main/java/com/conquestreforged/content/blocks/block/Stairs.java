package com.conquestreforged.content.blocks.block;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;

@Assets(
        state = @State(name = "%s_stairs", template = "parent_stairs"),
        item = @Model(name = "item/%s_stairs", parent = "block/%s_stairs", template = "item/acacia_stairs"),
        block = {
                @Model(name = "block/%s_stairs", template = "block/acacia_stairs"),
                @Model(name = "block/%s_stairs_outer", template = "block/acacia_stairs_outer"),
                @Model(name = "block/%s_stairs_inner", template = "block/acacia_stairs_inner"),
        }
)
public class Stairs extends StairsBlock {

    public Stairs(BlockState parent, Settings properties) {
        super(parent, properties);
        //super(() -> parent, properties);
    }
}