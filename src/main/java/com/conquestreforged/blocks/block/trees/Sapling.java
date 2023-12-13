package com.conquestreforged.blocks.block.trees;

import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;

@Render(RenderLayer.CUTOUT)
public class Sapling extends SaplingBlock {

    public Sapling(Props props) {
        super(props.get("tree", AbstractTreeGrower.class), props.toProperties());
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter reader, BlockPos pos) {
        return true;
    }
}
