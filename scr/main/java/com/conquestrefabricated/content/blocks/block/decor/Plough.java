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
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;


public class Plough extends HorizontalFacingBlock {
    public static final EnumProperty<BedPart> PART = Properties.BED_PART;
    protected static final VoxelShape BASE_X_AXIS_AABB = Block.createCuboidShape(0.0D, 0.0D, 6.5D, 16.0D, 16.0D, 9.5D);
    protected static final VoxelShape BASE_Z_AXIS_AABB = Block.createCuboidShape(6.5D, 0.0D, 0.0D, 9.5D, 16.0D, 16.0D);
    protected static final VoxelShape TOP_AABB = Block.createCuboidShape(0.0D, 14.0D, 0.0D, 14.0D, 16.0D, 16.0D);

    public Plough(Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(PART, BedPart.FOOT));
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView blockGetter, BlockPos blockPos, ShapeContext context) {
        Direction direction = state.get(FACING);
        switch(direction.getAxis()) {
            case Z:
            default:
                return state.get(PART) == BedPart.FOOT ? BASE_Z_AXIS_AABB : TOP_AABB;
            case X:
                return state.get(PART) == BedPart.FOOT ? BASE_X_AXIS_AABB : TOP_AABB;
        }
    }

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

    public PistonBehavior getPistonBehavior(BlockState blockState) {
        return PistonBehavior.DESTROY;
    }

    public boolean canPathfindThrough(BlockState blockState, BlockView blockGetter, BlockPos blockPos, NavigationType type) {
        return false;
    }

    private static Direction getNeighbourDirection(BedPart part, Direction direction) {
        return part == BedPart.FOOT ? direction : direction.getOpposite();
    }

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

    public void onPlaced(World level, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack itemStack) {
        super.onPlaced(level, pos, state, entity, itemStack);
        if (!level.isClient) {
            BlockPos blockpos = pos.offset(state.get(FACING));
            level.setBlockState(blockpos, state.with(PART, BedPart.HEAD), 3);
            level.updateNeighbors(pos, Blocks.AIR);
            state.updateNeighbors(level, pos, 3);
        }
    }

    public long getRenderingSeed(BlockState state, BlockPos pos) {
        BlockPos blockpos = pos.offset(state.get(FACING), state.get(PART) == BedPart.HEAD ? 0 : 1);
        return MathHelper.hashCode(blockpos.getX(), pos.getY(), blockpos.getZ());
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, PART);
    }
}
