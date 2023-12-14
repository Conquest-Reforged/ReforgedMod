package com.conquestreforged.content.blocks.block.plants;

import com.conquestreforged.core.block.properties.Waterloggable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ConnectingBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

import java.util.Map;
import java.util.Objects;

public class LichenMoss extends AbstractBush implements Waterloggable {

    public static final BooleanProperty DOWN = ConnectingBlock.DOWN;
    public static final BooleanProperty NORTH = ConnectingBlock.NORTH;
    public static final BooleanProperty EAST = ConnectingBlock.EAST;
    public static final BooleanProperty SOUTH = ConnectingBlock.SOUTH;
    public static final BooleanProperty WEST = ConnectingBlock.WEST;
    protected static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = ConnectingBlock.FACING_PROPERTIES.entrySet().stream().filter((p_199775_0_) -> p_199775_0_.getKey().getAxis().isHorizontal()).collect(Util.toMap());

    public LichenMoss(Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockView iblockreader = context.getWorld();
        BlockPos blockpos = context.getBlockPos();
        FluidState ifluidstate = context.getWorld().getFluidState(context.getBlockPos());
        BlockPos blockpos1 = blockpos.north();
        BlockPos blockpos2 = blockpos.east();
        BlockPos blockpos3 = blockpos.south();
        BlockPos blockpos4 = blockpos.west();
        BlockPos blockposDown = blockpos.down();
        BlockState blockstate = iblockreader.getBlockState(blockpos1);
        BlockState blockstate1 = iblockreader.getBlockState(blockpos2);
        BlockState blockstate2 = iblockreader.getBlockState(blockpos3);
        BlockState blockstate3 = iblockreader.getBlockState(blockpos4);
        BlockState blockstateDown = iblockreader.getBlockState(blockposDown);
        return Objects.requireNonNull(super.getPlacementState(context)).with(NORTH, blockstate.isSideSolidFullSquare(iblockreader, blockpos1, Direction.SOUTH)).with(EAST, blockstate1.isSideSolidFullSquare(iblockreader, blockpos1, Direction.WEST)).with(SOUTH, blockstate2.isSideSolidFullSquare(iblockreader, blockpos3, Direction.NORTH)).with(WEST, blockstate3.isSideSolidFullSquare(iblockreader, blockpos4, Direction.EAST)).with(DOWN, blockstateDown.isSideSolidFullSquare(iblockreader, blockposDown, Direction.DOWN)).with(WATERLOGGED, ifluidstate.getFluid() == Fluids.WATER);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess world, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.get(WATERLOGGED)) {
            world.createAndScheduleFluidTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return facing.getAxis().getType() == Direction.Type.HORIZONTAL ? stateIn.with(PROPERTY_BY_DIRECTION.get(facing), facingState.isSideSolidFullSquare(world, facingPos, facing.getOpposite())) : super.getStateForNeighborUpdate(stateIn, facing, facingState, world, currentPos, facingPos);
    }

    @SuppressWarnings("deprecation")
    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, WEST, SOUTH, DOWN, WATERLOGGED);
    }

    @Override
    public float getMaxHorizontalModelOffset() {
        return 0.0F;
    }

    @Override
    public float getVerticalModelOffsetMultiplier() {
        return 0.0F;
    }


}
