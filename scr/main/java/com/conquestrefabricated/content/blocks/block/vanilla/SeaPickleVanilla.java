package com.conquestrefabricated.content.blocks.block.vanilla;

import com.conquestrefabricated.content.blocks.block.Layer;
import net.minecraft.block.BlockState;
import net.minecraft.block.SeaPickleBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

public class SeaPickleVanilla extends SeaPickleBlock {

    public SeaPickleVanilla(Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(PICKLES, Integer.valueOf(1)).with(WATERLOGGED, Boolean.valueOf(true)));
    }

    @Override
    public boolean canPlantOnTop(BlockState state, BlockView worldIn, BlockPos pos) {
        return !state.getCollisionShape(worldIn, pos).getFace(Direction.UP).isEmpty() || state.getBlock() instanceof Layer;
    }

}
