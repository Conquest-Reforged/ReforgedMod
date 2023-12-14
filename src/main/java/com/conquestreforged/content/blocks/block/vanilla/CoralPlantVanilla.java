package com.conquestreforged.content.blocks.block.vanilla;

import com.conquestreforged.content.blocks.block.Layer;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class CoralPlantVanilla extends CoralParentBlock {

    public static final BooleanProperty LIVING = BooleanProperty.of("living");
    protected static final VoxelShape SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 15.0D, 14.0D);

    public CoralPlantVanilla(Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(LIVING, true));

    }

    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        this.checkLivingConditions(state, worldIn, pos);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (!isInWater(state, worldIn, pos)) {
            worldIn.setBlockState(pos, this.getDefaultState().with(LIVING, false).with(WATERLOGGED, false), 2);
        }

    }

    /**
     * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
     * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
     * returns its solidified counterpart.
     * Note that this method should ideally consider only the specific face passed in.
     */
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (facing == Direction.DOWN && !stateIn.canPlaceAt(worldIn, currentPos)) {
            return Blocks.AIR.getDefaultState();
        } else {
            this.checkLivingConditions(stateIn, worldIn, currentPos);
            if (stateIn.get(WATERLOGGED)) {
                worldIn.createAndScheduleFluidTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
            }

            return super.getStateForNeighborUpdate(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        }
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        return worldIn.getBlockState(blockpos).isSideSolidFullSquare(worldIn, blockpos, Direction.UP) || worldIn.getBlockState(blockpos).getBlock() instanceof Layer;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, LIVING);
    }
}
