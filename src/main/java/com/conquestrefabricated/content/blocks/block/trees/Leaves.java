package com.conquestrefabricated.content.blocks.block.trees;

import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.block.builder.Props;
import com.conquestrefabricated.core.util.RenderLayer;
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
