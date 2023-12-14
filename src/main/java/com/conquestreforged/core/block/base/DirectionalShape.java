package com.conquestreforged.core.block.base;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import org.jetbrains.annotations.NotNull;


public abstract class DirectionalShape extends Shape {

    public static final DirectionProperty DIRECTION = Properties.FACING;

    public DirectionalShape(Settings builder) {
        super(builder);
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rot) {
        return state.with(DIRECTION, rot.rotate(state.get(DIRECTION)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.get(DIRECTION)));
    }

    @NotNull
    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(DIRECTION, context.getPlayerLookDirection().getOpposite());
    }

    @Override
    protected final void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(DIRECTION);
        addProperties(builder);
    }

    protected void addProperties(StateManager.Builder<Block, BlockState> builder) {

    }
}
