package com.conquestreforged.blocks.block.trees;

import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.LeavesBlock;

@Render(RenderLayer.CUTOUT_MIPPED)
public class Leaves extends LeavesBlock {

    private final ItemLike sapling;

    public Leaves(Props props) {
        super(props.toProperties());
        this.sapling = props.get("sapling", ItemLike.class);
    }
}
