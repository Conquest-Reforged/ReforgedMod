package com.conquestreforged.blocks.block.vanilla;

import com.conquestreforged.blocks.block.Layer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.SeaPickleBlock;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class SeaPickleVanilla extends SeaPickleBlock {

    public SeaPickleVanilla(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(PICKLES, Integer.valueOf(1)).setValue(WATERLOGGED, Boolean.valueOf(true)));
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return !state.getCollisionShape(worldIn, pos).getFaceShape(Direction.UP).isEmpty() || state.getBlock() instanceof Layer;
    }

}
