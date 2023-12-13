package com.conquestreforged.core.block.base;

import com.conquestreforged.core.block.properties.BidirectionalShape;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;

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
        if (state.get(DIRECTION) == BidirectionalShape.NORTH_SOUTH) {
            return state.with(DIRECTION, BidirectionalShape.EAST_WEST);
        } else {
            return state.with(DIRECTION, BidirectionalShape.NORTH_SOUTH);
        }
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state;
    }

    @Nonnull
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BidirectionalShape facing = BidirectionalShape.EAST_WEST;
        if (context.getPlacementHorizontalFacing() == Direction.NORTH || context.getPlacementHorizontalFacing() == Direction.SOUTH) {
            facing = BidirectionalShape.NORTH_SOUTH;
        }
        return super.getStateForPlacement(context).with(DIRECTION, facing);
    }

    @Override
    protected final void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(DIRECTION);
        addProperties(builder);
    }

    protected void addProperties(StateContainer.Builder<Block, BlockState> builder) {

    }
}
