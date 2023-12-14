package com.conquestreforged.content.blocks.block.trees;

import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.block.LeavesBlock;
import net.minecraft.item.ItemConvertible;

@Render(RenderLayer.CUTOUT_MIPPED)
public class Leaves extends LeavesBlock {

    private final ItemConvertible sapling;

    public Leaves(Props props) {
        super(props.toSettings());
        this.sapling = props.get("sapling", ItemConvertible.class);
    }
}
