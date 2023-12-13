package com.conquestrefabricated.content.blocks.block;

import com.conquestrefabricated.content.blocks.block.classical.corinthian.CubeCapitalCorinthian;
import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class WallOld extends HorizontalConnectingBlock {

    public static final BooleanProperty UP = Properties.UP;
    private final VoxelShape[] wallShapes;
    private final VoxelShape[] wallCollisionShapes;

    public WallOld(Settings properties) {
        super(0.0F, 3.0F, 0.0F, 14.0F, 24.0F, properties);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(UP, true)
                .with(NORTH, false)
                .with(EAST, false)
                .with(SOUTH, false)
                .with(WEST, false)
                .with(WATERLOGGED, false));
        this.wallShapes = this.createShapes(4.0F, 3.0F, 16.0F, 0.0F, 14.0F);
        this.wallCollisionShapes = this.createShapes(4.0F, 3.0F, 24.0F, 0.0F, 24.0F);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
        return state.get(UP) ? this.wallShapes[this.getShapeIndex(state)] : super.getOutlineShape(state, worldIn, pos, context);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
        return state.get(UP) ? this.wallCollisionShapes[this.getShapeIndex(state)] : super.getCollisionShape(state, worldIn, pos, context);
    }

    private boolean canAttachTo(BlockState blockState, boolean isSideSolid, Direction direction) {
        Block block = blockState.getBlock();
        boolean flag = blockState.isIn(BlockTags.WALLS) ||
                block instanceof FenceGateBlock && FenceGateBlock.canWallConnect(blockState, direction) ||
                block instanceof CubeCapitalCorinthian ||
                (block instanceof VerticalCorner && blockState.get(VerticalCorner.LAYERS) >= 3) ||
                (block instanceof VerticalCornerLessLayers && blockState.get(VerticalCornerLessLayers.LAYERS) >= 2) ||
                (block instanceof VerticalSlab && blockState.get(VerticalSlab.LAYERS) >= 3 && canAttachToVertSlab(blockState, direction)) ||
                (block instanceof VerticalSlabLessLayers && blockState.get(VerticalSlabLessLayers.LAYERS) >= 2 && canAttachToVertSlab(blockState, direction)) ||
                (block instanceof VerticalQuarter && blockState.get(VerticalQuarter.LAYERS) >= 3 && canAttachToVertQuarter(blockState, direction)) ||
                (block instanceof VerticalQuarterLessLayers && blockState.get(VerticalQuarterLessLayers.LAYERS) >= 2 && canAttachToVertQuarter(blockState, direction));
        return !cannotConnect(blockState) && isSideSolid || flag;
    }

    private boolean canAttachToVertQuarter(BlockState state, Direction direction) {
        return (state.get(VerticalQuarter.DIRECTION) != direction && state.get(VerticalQuarter.DIRECTION).rotateYCounterclockwise() != direction);
    }

    public final boolean canAttachToVertSlab(BlockState state, Direction direction) {
        return state.get(VerticalSlab.DIRECTION) != direction;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        WorldView iworldreader = context.getWorld();
        BlockPos blockpos = context.getBlockPos();
        FluidState ifluidstate = context.getWorld().getFluidState(context.getBlockPos());
        BlockPos blockpos1 = blockpos.north();
        BlockPos blockpos2 = blockpos.east();
        BlockPos blockpos3 = blockpos.south();
        BlockPos blockpos4 = blockpos.west();
        BlockState blockstate = iworldreader.getBlockState(blockpos1);
        BlockState blockstate1 = iworldreader.getBlockState(blockpos2);
        BlockState blockstate2 = iworldreader.getBlockState(blockpos3);
        BlockState blockstate3 = iworldreader.getBlockState(blockpos4);
        boolean flag = this.canAttachTo(blockstate, blockstate.isSideSolidFullSquare(iworldreader, blockpos1, Direction.SOUTH), Direction.SOUTH);
        boolean flag1 = this.canAttachTo(blockstate1, blockstate1.isSideSolidFullSquare(iworldreader, blockpos2, Direction.WEST), Direction.WEST);
        boolean flag2 = this.canAttachTo(blockstate2, blockstate2.isSideSolidFullSquare(iworldreader, blockpos3, Direction.NORTH), Direction.NORTH);
        boolean flag3 = this.canAttachTo(blockstate3, blockstate3.isSideSolidFullSquare(iworldreader, blockpos4, Direction.EAST), Direction.EAST);
        boolean flag4 = (!flag || flag1 || !flag2 || flag3) && (flag || !flag1 || flag2 || !flag3);
        return this.getDefaultState().with(UP, flag4 || !iworldreader.isAir(blockpos.up())).with(NORTH, flag).with(EAST, flag1).with(SOUTH, flag2).with(WEST, flag3).with(WATERLOGGED, ifluidstate.getFluid() == Fluids.WATER);
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.get(WATERLOGGED)) {
            worldIn.createAndScheduleFluidTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }

        if (facing == Direction.DOWN) {
            return super.getStateForNeighborUpdate(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        } else {
            Direction direction = facing.getOpposite();
            boolean flag = facing == Direction.NORTH ? this.canAttachTo(facingState, facingState.isSideSolidFullSquare(worldIn, facingPos, direction), direction) : stateIn.get(NORTH);
            boolean flag1 = facing == Direction.EAST ? this.canAttachTo(facingState, facingState.isSideSolidFullSquare(worldIn, facingPos, direction), direction) : stateIn.get(EAST);
            boolean flag2 = facing == Direction.SOUTH ? this.canAttachTo(facingState, facingState.isSideSolidFullSquare(worldIn, facingPos, direction), direction) : stateIn.get(SOUTH);
            boolean flag3 = facing == Direction.WEST ? this.canAttachTo(facingState, facingState.isSideSolidFullSquare(worldIn, facingPos, direction), direction) : stateIn.get(WEST);
            boolean flag4 = (!flag || flag1 || !flag2 || flag3) && (flag || !flag1 || flag2 || !flag3);
            return stateIn.with(UP, flag4 || !worldIn.isAir(currentPos.up())).with(NORTH, Boolean.valueOf(flag)).with(EAST, Boolean.valueOf(flag1)).with(SOUTH, Boolean.valueOf(flag2)).with(WEST, Boolean.valueOf(flag3));
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(UP, NORTH, EAST, WEST, SOUTH, WATERLOGGED);
    }
}
