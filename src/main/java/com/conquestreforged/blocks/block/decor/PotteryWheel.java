package com.conquestreforged.blocks.block.decor;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class PotteryWheel extends HorizontalDirectionalBlock {
    public static final EnumProperty<BedPart> PART = BlockStateProperties.BED_PART;
    protected static final VoxelShape BASE_X_AXIS = Block.box(0.0D, 0.0D, 1.0D, 16.0D, 4.0D, 15.0D);
    protected static final VoxelShape BASE_Z_AXIS = Block.box(1.0D, 0.0D, 0.0D, 15.0D, 4.0D, 16.0D);
    protected static final VoxelShape MIDDLE_X_AXIS = Block.box(0.0D, 4.0D, 2.0D, 16.0D, 10.0D, 14.0D);
    protected static final VoxelShape MIDDLE_Z_AXIS = Block.box(2.0D, 4.0D, 0.0D, 14.0D, 10.0D, 16.0D);
    protected static final VoxelShape TOP_X_AXIS = Block.box(0.0D, 10.0D, 4.0D, 16.0D, 16.0D, 12.0D);
    protected static final VoxelShape TOP_Z_AXIS = Block.box(4.0D, 10.0D, 0.0D, 12.0D, 16.0D, 16.0D);
    protected static final VoxelShape X_AXIS_AABB = Shapes.or(BASE_X_AXIS, MIDDLE_X_AXIS, TOP_X_AXIS);
    protected static final VoxelShape Z_AXIS_AABB = Shapes.or(BASE_Z_AXIS, MIDDLE_Z_AXIS, TOP_Z_AXIS);

    public PotteryWheel(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(PART, BedPart.FOOT));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos blockPos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        switch(direction.getAxis()) {
            case Z:
            default:
                return Z_AXIS_AABB;
            case X:
                return X_AXIS_AABB;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction direction = context.getHorizontalDirection();
        BlockPos blockpos = context.getClickedPos();
        BlockPos blockpos1 = blockpos.m_142300_(direction);
        Level level = context.getLevel();
        return level.getBlockState(blockpos1).canBeReplaced(context) && level.getWorldBorder().isWithinBounds(blockpos1) ? this.defaultBlockState().setValue(FACING, direction) : null;
    }

    @Override
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState facingState, LevelAccessor levelAccessor, BlockPos currentPos, BlockPos facingPos) {
        if (direction == getNeighbourDirection(blockState.getValue(PART), blockState.getValue(FACING))) {
            return facingState.is(this) && facingState.getValue(PART) != blockState.getValue(PART) ? super.updateShape(blockState, direction, facingState, levelAccessor, currentPos, facingPos) : Blocks.AIR.defaultBlockState();
        } else {
            return super.updateShape(blockState, direction, facingState, levelAccessor, currentPos, facingPos);
        }
    }

    @Override
    public PushReaction getPistonPushReaction(BlockState blockState) {
        return PushReaction.DESTROY;
    }

    @Override
    public boolean isPathfindable(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, PathComputationType type) {
        return false;
    }

    private static Direction getNeighbourDirection(BedPart part, Direction direction) {
        return part == BedPart.FOOT ? direction : direction.getOpposite();
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide && player.isCreative()) {
            BedPart bedpart = state.getValue(PART);
            if (bedpart == BedPart.FOOT) {
                BlockPos blockpos = pos.m_142300_(getNeighbourDirection(bedpart, state.getValue(FACING)));
                BlockState blockstate = level.getBlockState(blockpos);
                if (blockstate.is(this) && blockstate.getValue(PART) == BedPart.HEAD) {
                    level.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 35);
                    level.levelEvent(player, 2001, blockpos, Block.getId(blockstate));
                }
            }
        }
        super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack itemStack) {
        super.setPlacedBy(level, pos, state, entity, itemStack);
        if (!level.isClientSide) {
            BlockPos blockpos = pos.m_142300_(state.getValue(FACING));
            level.setBlock(blockpos, state.setValue(PART, BedPart.HEAD), 3);
            level.blockUpdated(pos, Blocks.AIR);
            state.updateNeighbourShapes(level, pos, 3);
        }
    }

    @Override
    public long getSeed(BlockState state, BlockPos pos) {
        BlockPos blockpos = pos.relative(state.getValue(FACING), state.getValue(PART) == BedPart.HEAD ? 0 : 1);
        return Mth.getSeed(blockpos.getX(), pos.getY(), blockpos.getZ());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, PART);
    }
}
