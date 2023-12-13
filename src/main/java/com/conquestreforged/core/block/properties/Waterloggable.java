package com.conquestreforged.core.block.properties;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public interface Waterloggable extends SimpleWaterloggedBlock {

    BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    static FluidState getFluidState(BlockState state) {
        //todo check #getSource
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : Fluids.EMPTY.defaultFluidState();
    }
}
