package com.conquestreforged.core.block.base;

import com.conquestreforged.core.block.properties.BidirectionalShape;
import com.conquestreforged.core.block.properties.Waterloggable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
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
public abstract class WaterloggedBidirectionalShape extends Shape implements Waterloggable {

    public static final EnumProperty DIRECTION = EnumProperty.of("direction", BidirectionalShape.class);

    public WaterloggedBidirectionalShape(Settings builder) {
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
        FluidState fluid = context.getWorld().getFluidState(context.getBlockPos());
        return super.getPlacementState(context)
                .with(DIRECTION, facing)
                .with(WATERLOGGED, fluid.getFluid() == Fluids.WATER);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    protected final void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(DIRECTION, WATERLOGGED);
        addProperties(builder);
    }

    protected void addProperties(StateManager.Builder<Block, BlockState> builder) {}
}
