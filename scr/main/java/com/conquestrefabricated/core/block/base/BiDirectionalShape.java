package com.conquestrefabricated.core.block.base;

import com.conquestrefabricated.core.block.properties.BidirectionalShape;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.NotNull;


/**
 * A directional, non full-cube shape that can be waterlogged
 */
public abstract class BiDirectionalShape extends Shape {

    public static final EnumProperty DIRECTION = EnumProperty.of("direction", BidirectionalShape.class);

    public BiDirectionalShape(Settings builder) {
        super(builder);
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rot) {
        if (state.get(DIRECTION) == BidirectionalShape.NORTH_SOUTH) {
            return state.with(DIRECTION, BidirectionalShape.EAST_WEST);
        } else {
            return state.with(DIRECTION, BidirectionalShape.NORTH_SOUTH);
        }
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirrorIn) {
        return state;
    }

    @NotNull
    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BidirectionalShape facing = BidirectionalShape.EAST_WEST;
        if (context.getPlayerFacing() == Direction.NORTH || context.getPlayerFacing() == Direction.SOUTH) {
            facing = BidirectionalShape.NORTH_SOUTH;
        }
        return super.getPlacementState(context).with(DIRECTION, facing);
    }

    @Override
    protected final void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(DIRECTION);
        addProperties(builder);
    }

    protected void addProperties(StateManager.Builder<Block, BlockState> builder) {

    }
}
