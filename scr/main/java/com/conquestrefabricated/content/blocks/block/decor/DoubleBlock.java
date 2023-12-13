package com.conquestrefabricated.content.blocks.block.decor;

import com.conquestrefabricated.core.block.base.Shape;
import com.conquestrefabricated.core.block.builder.Props;
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
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import java.util.List;

public class DoubleBlock extends Shape {
    private final List<VoxelShape> hitBox;
    public static final EnumProperty<DoubleBlockHalf> HALF = Properties.DOUBLE_BLOCK_HALF;

    public DoubleBlock(Props props) {
        super(props.toSettings());
        this.setDefaultState(this.stateManager.getDefaultState().with(HALF, DoubleBlockHalf.LOWER));
        this.hitBox = props.get("hitBox", List.class);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        return hitBox.get(0);
    }

    @Override
    public boolean hasSidedTransparency(BlockState state) {
        return true;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockPos blockpos = context.getBlockPos();
        World level = context.getWorld();
        return blockpos.getY() < level.getTopY() - 1 && level.getBlockState(blockpos.up()).canReplace(context) ? super.getPlacementState(context) : null;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction facing, BlockState facingState, WorldAccess level, BlockPos blockPos, BlockPos facingPos) {
        DoubleBlockHalf doubleblockhalf = state.get(HALF);
        if (facing.getAxis() != Direction.Axis.Y || doubleblockhalf == DoubleBlockHalf.LOWER != (facing == Direction.UP) || facingState.isOf(this) && facingState.get(HALF) != doubleblockhalf) {
            return doubleblockhalf == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.canPlaceAt(level, blockPos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, facing, facingState, level, blockPos, facingPos);
        } else {
            return Blocks.AIR.getDefaultState();
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
    public boolean canPlaceAt(BlockState state, WorldView level, BlockPos blockPos) {
        if (state.get(HALF) != DoubleBlockHalf.UPPER) {
            return super.canPlaceAt(state, level, blockPos);
        } else {
            BlockState blockstate = level.getBlockState(blockPos.down());
            if (state.getBlock() != this) return super.canPlaceAt(state, level, blockPos);
            return blockstate.isOf(this) && blockstate.get(HALF) == DoubleBlockHalf.LOWER;
        }
    }

    @Override
    public long getRenderingSeed(BlockState blockState, BlockPos pos) {
        return MathHelper.hashCode(pos.getX(), pos.down(blockState.get(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), pos.getZ());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HALF);
    }
}
