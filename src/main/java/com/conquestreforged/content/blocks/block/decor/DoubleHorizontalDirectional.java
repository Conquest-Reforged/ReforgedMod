package com.conquestreforged.content.blocks.block.decor;

import com.conquestreforged.content.blocks.block.directional.HorizontalDirectional;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class DoubleHorizontalDirectional extends HorizontalDirectional {
    public static final EnumProperty<DoubleBlockHalf> HALF = Properties.DOUBLE_BLOCK_HALF;

    public DoubleHorizontalDirectional(Props properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(DIRECTION, Direction.NORTH).with(HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockPos blockpos = context.getBlockPos();
        World level = context.getWorld();
        if (blockpos.getY() < level.getTopY() - 1 && level.getBlockState(blockpos.up()).canReplace(context)) {
            return this.getDefaultState().with(DIRECTION, context.getPlayerFacing().getOpposite()).with(HALF, DoubleBlockHalf.LOWER);
        } else {
            return null;
        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState blockState, Direction direction, BlockState state, WorldAccess levelAccessor, BlockPos blockPos, BlockPos facing) {
        DoubleBlockHalf doubleblockhalf = blockState.get(HALF);
        if (direction.getAxis() == Direction.Axis.Y && doubleblockhalf == DoubleBlockHalf.LOWER == (direction == Direction.UP)) {
            return state.isOf(this) && state.get(HALF) != doubleblockhalf ? blockState.with(DIRECTION, state.get(DIRECTION)) : Blocks.AIR.getDefaultState();
        } else {
            return doubleblockhalf == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !blockState.canPlaceAt(levelAccessor, blockPos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(blockState, direction, state, levelAccessor, blockPos, facing);
        }
    }

    protected static void preventCreativeDropFromBottomPart(World level, BlockPos pos, BlockState state, PlayerEntity player) {
        DoubleBlockHalf doubleblockhalf = state.get(HALF);
        if (doubleblockhalf == DoubleBlockHalf.UPPER) {
            BlockPos blockpos = pos.down();
            BlockState blockstate = level.getBlockState(blockpos);
            if (blockstate.isOf(state.getBlock()) && blockstate.get(HALF) == DoubleBlockHalf.LOWER) {
                BlockState blockstate1 = blockstate.contains(Properties.WATERLOGGED) && blockstate.get(Properties.WATERLOGGED) ? Blocks.WATER.getDefaultState() : Blocks.AIR.getDefaultState();
                level.setBlockState(blockpos, blockstate1, 35);
                level.syncWorldEvent(player, 2001, blockpos, Block.getRawIdFromState(blockstate));
            }
        }

    }

    @Override
    public void onBreak(World level, BlockPos pos, BlockState blockState, PlayerEntity player) {
        if (!level.isClient && player.isCreative()) {
            this.preventCreativeDropFromBottomPart(level, pos, blockState, player);
        }

        super.onBreak(level, pos, blockState, player);
    }

    @Override
    public void onPlaced(World level, BlockPos pos, BlockState blockState, LivingEntity livingEntity, ItemStack itemStack) {
        level.setBlockState(pos.up(), blockState.with(HALF, DoubleBlockHalf.UPPER), 3);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView levelReader, BlockPos pos) {
        BlockPos blockpos = pos.down();
        BlockState blockstate = levelReader.getBlockState(blockpos);
        return state.get(HALF) == DoubleBlockHalf.UPPER ? blockstate.isOf(this) : super.canPlaceAt(state, levelReader, pos);
    }

    @Override
    public long getRenderingSeed(BlockState blockState, BlockPos pos) {
        return MathHelper.hashCode(pos.getX(), pos.down(blockState.get(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), pos.getZ());
    }

    @Override
    protected void addProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HALF);
    }
}
