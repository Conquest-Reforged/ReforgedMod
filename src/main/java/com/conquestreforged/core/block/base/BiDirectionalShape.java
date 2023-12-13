package com.conquestreforged.core.block.base;

import com.conquestreforged.core.block.properties.BidirectionalShape;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;

import javax.annotation.Nonnull;

/**
 * A directional, non full-cube shape that can be waterlogged
 */
public abstract class BiDirectionalShape extends Shape {

    public static final EnumProperty DIRECTION = EnumProperty.create("direction", BidirectionalShape.class);

    public BiDirectionalShape(Properties builder) {
        super(builder);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        if (state.getValue(DIRECTION) == BidirectionalShape.NORTH_SOUTH) {
            return state.setValue(DIRECTION, BidirectionalShape.EAST_WEST);
        } else {
            return state.setValue(DIRECTION, BidirectionalShape.NORTH_SOUTH);
        }
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state;
    }

    @Nonnull
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BidirectionalShape facing = BidirectionalShape.EAST_WEST;
        if (context.getHorizontalDirection() == Direction.NORTH || context.getHorizontalDirection() == Direction.SOUTH) {
            facing = BidirectionalShape.NORTH_SOUTH;
        }
        return super.getStateForPlacement(context).setValue(DIRECTION, facing);
    }

    @Override
    protected final void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DIRECTION);
        addProperties(builder);
    }

    protected void addProperties(StateDefinition.Builder<Block, BlockState> builder) {

    }
}
