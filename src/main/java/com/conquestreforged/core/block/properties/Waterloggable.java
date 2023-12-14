package com.conquestreforged.core.block.properties;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;

public interface Waterloggable extends net.minecraft.block.Waterloggable {

    BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    static FluidState getFluidState(BlockState state) {
        //todo check #getSource
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : Fluids.EMPTY.getDefaultState();
    }
}
