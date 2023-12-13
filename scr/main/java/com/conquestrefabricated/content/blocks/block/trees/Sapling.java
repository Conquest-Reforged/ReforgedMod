package com.conquestrefabricated.content.blocks.block.trees;

import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.block.builder.Props;
import com.conquestrefabricated.core.util.RenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

@Render(RenderLayer.CUTOUT)
public class Sapling extends SaplingBlock {

    public Sapling(Props props) {
        super(props.get("tree", SaplingGenerator.class), props.toSettings());
    }

    @Override
    public boolean canPlantOnTop(BlockState state, BlockView reader, BlockPos pos) {
        return true;
    }
}
