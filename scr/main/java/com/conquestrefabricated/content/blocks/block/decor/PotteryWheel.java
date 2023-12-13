package com.conquestrefabricated.content.blocks.block.decor;

import net.minecraft.block.*;
import net.minecraft.block.enums.BedPart;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;


public class PotteryWheel extends HorizontalFacingBlock {
    public static final EnumProperty<BedPart> PART = Properties.BED_PART;
    protected static final VoxelShape BASE_X_AXIS = Block.createCuboidShape(0.0D, 0.0D, 1.0D, 16.0D, 4.0D, 15.0D);
    protected static final VoxelShape BASE_Z_AXIS = Block.createCuboidShape(1.0D, 0.0D, 0.0D, 15.0D, 4.0D, 16.0D);
    protected static final VoxelShape MIDDLE_X_AXIS = Block.createCuboidShape(0.0D, 4.0D, 2.0D, 16.0D, 10.0D, 14.0D);
    protected static final VoxelShape MIDDLE_Z_AXIS = Block.createCuboidShape(2.0D, 4.0D, 0.0D, 14.0D, 10.0D, 16.0D);
    protected static final VoxelShape TOP_X_AXIS = Block.createCuboidShape(0.0D, 10.0D, 4.0D, 16.0D, 16.0D, 12.0D);
    protected static final VoxelShape TOP_Z_AXIS = Block.createCuboidShape(4.0D, 10.0D, 0.0D, 12.0D, 16.0D, 16.0D);
    protected static final VoxelShape X_AXIS_AABB = VoxelShapes.union(BASE_X_AXIS, MIDDLE_X_AXIS, TOP_X_AXIS);
    protected static final VoxelShape Z_AXIS_AABB = VoxelShapes.union(BASE_Z_AXIS, MIDDLE_Z_AXIS, TOP_Z_AXIS);

    public PotteryWheel(AbstractBlock.Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(PART, BedPart.FOOT));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView blockGetter, BlockPos blockPos, ShapeContext context) {
        Direction direction = state.get(FACING);
        switch(direction.getAxis()) {
            case Z:
            default:
                return Z_AXIS_AABB;
            case X:
                return X_AXIS_AABB;
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        Direction direction = context.getPlayerFacing();
        BlockPos blockpos = context.getBlockPos();
        BlockPos blockpos1 = blockpos.offset(direction);
        World level = context.getWorld();
        return level.getBlockState(blockpos1).canReplace(context) && level.getWorldBorder().contains(blockpos1) ? this.getDefaultState().with(FACING, direction) : null;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState blockState, Direction direction, BlockState facingState, WorldAccess levelAccessor, BlockPos currentPos, BlockPos facingPos) {
        if (direction == getNeighbourDirection(blockState.get(PART), blockState.get(FACING))) {
            return facingState.isOf(this) && facingState.get(PART) != blockState.get(PART) ? super.getStateForNeighborUpdate(blockState, direction, facingState, levelAccessor, currentPos, facingPos) : Blocks.AIR.getDefaultState();
        } else {
            return super.getStateForNeighborUpdate(blockState, direction, facingState, levelAccessor, currentPos, facingPos);
        }
    }

    @Override
    public PistonBehavior getPistonBehavior(BlockState blockState) {
        return PistonBehavior.DESTROY;
    }

    @Override
    public boolean canPathfindThrough(BlockState blockState, BlockView blockGetter, BlockPos blockPos, NavigationType type) {
        return false;
    }

    private static Direction getNeighbourDirection(BedPart part, Direction direction) {
        return part == BedPart.FOOT ? direction : direction.getOpposite();
    }

    @Override
    public void onBreak(World level, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!level.isClient && player.isCreative()) {
            BedPart bedpart = state.get(PART);
            if (bedpart == BedPart.FOOT) {
                BlockPos blockpos = pos.offset(getNeighbourDirection(bedpart, state.get(FACING)));
                BlockState blockstate = level.getBlockState(blockpos);
                if (blockstate.isOf(this) && blockstate.get(PART) == BedPart.HEAD) {
                    level.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 35);
                    level.syncWorldEvent(player, 2001, blockpos, Block.getRawIdFromState(blockstate));
                }
            }
        }
        super.onBreak(level, pos, state, player);
    }

    @Override
    public void onPlaced(World level, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack itemStack) {
        super.onPlaced(level, pos, state, entity, itemStack);
        if (!level.isClient) {
            BlockPos blockpos = pos.offset(state.get(FACING));
            level.setBlockState(blockpos, state.with(PART, BedPart.HEAD), 3);
            level.updateNeighbors(pos, Blocks.AIR);
            state.updateNeighbors(level, pos, 3);
        }
    }

    @Override
    public long getRenderingSeed(BlockState state, BlockPos pos) {
        BlockPos blockpos = pos.offset(state.get(FACING), state.get(PART) == BedPart.HEAD ? 0 : 1);
        return MathHelper.hashCode(blockpos.getX(), pos.getY(), blockpos.getZ());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, PART);
    }
}
