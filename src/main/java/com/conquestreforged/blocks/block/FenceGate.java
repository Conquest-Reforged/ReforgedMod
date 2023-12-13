package com.conquestreforged.blocks.block;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.properties.Waterloggable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@Assets(
        state = @State(name = "%s_fence_gate", template = "parent_fence_gate"),
        item = @Model(name = "item/%s_fence_gate", parent = "block/%s_fence_gate", template = "item/acacia_fence_gate"),
        block = {
                @Model(name = "block/%s_fence_gate", template = "block/acacia_fence_gate"),
                @Model(name = "block/%s_fence_gate_open", template = "block/acacia_fence_gate_open"),
                @Model(name = "block/%s_fence_gate_wall", template = "block/acacia_fence_gate_wall"),
                @Model(name = "block/%s_fence_gate_wall_open", template = "block/acacia_fence_gate_wall_open")
        }
)
public class FenceGate extends FenceGateBlock implements Waterloggable {

    private static final BooleanProperty OPEN = BlockStateProperties.OPEN;
    private static final BooleanProperty IN_WALL = BlockStateProperties.IN_WALL;
    private static final VoxelShape AABB_HITBOX_ZAXIS = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
    private static final VoxelShape AABB_HITBOX_XAXIS = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);
    private static final VoxelShape AABB_HITBOX_ZAXIS_INWALL = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 13.0D, 10.0D);
    private static final VoxelShape AABB_HITBOX_XAXIS_INWALL = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 13.0D, 16.0D);
    private static final VoxelShape field_208068_x = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 24.0D, 10.0D);
    private static final VoxelShape AABB_COLLISION_BOX_XAXIS = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 24.0D, 16.0D);
    private static final VoxelShape field_208069_z = Shapes.or(Block.box(0.0D, 5.0D, 7.0D, 2.0D, 16.0D, 9.0D), Block.box(14.0D, 5.0D, 7.0D, 16.0D, 16.0D, 9.0D));
    private static final VoxelShape AABB_COLLISION_BOX_ZAXIS = Shapes.or(Block.box(7.0D, 5.0D, 0.0D, 9.0D, 16.0D, 2.0D), Block.box(7.0D, 5.0D, 14.0D, 9.0D, 16.0D, 16.0D));
    private static final VoxelShape field_208066_B = Shapes.or(Block.box(0.0D, 2.0D, 7.0D, 2.0D, 13.0D, 9.0D), Block.box(14.0D, 2.0D, 7.0D, 16.0D, 13.0D, 9.0D));
    private static final VoxelShape field_208067_C = Shapes.or(Block.box(7.0D, 2.0D, 0.0D, 9.0D, 13.0D, 2.0D), Block.box(7.0D, 2.0D, 14.0D, 9.0D, 13.0D, 16.0D));

    public FenceGate(Properties properties) {
        super(properties);
        this.registerDefaultState((this.stateDefinition.any()).setValue(OPEN, false).setValue(IN_WALL, false).setValue(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if (state.getValue(IN_WALL)) {
            return state.getValue(FACING).getAxis() == Direction.Axis.X ? AABB_HITBOX_XAXIS_INWALL : AABB_HITBOX_ZAXIS_INWALL;
        } else {
            return state.getValue(FACING).getAxis() == Direction.Axis.X ? AABB_HITBOX_XAXIS : AABB_HITBOX_ZAXIS;
        }
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if (state.getValue(OPEN)) {
            return Shapes.empty();
        } else {
            return state.getValue(FACING).getAxis() == Direction.Axis.Z ? field_208068_x : AABB_COLLISION_BOX_XAXIS;
        }
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter world, BlockPos pos) {
        if (state.getValue(IN_WALL)) {
            return state.getValue(FACING).getAxis() == Direction.Axis.X ? field_208067_C : field_208066_B;
        } else {
            return state.getValue(FACING).getAxis() == Direction.Axis.X ? AABB_COLLISION_BOX_ZAXIS : field_208069_z;
        }
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter world, BlockPos pos, PathComputationType type) {
        switch (type) {
            case LAND:
            case AIR:
                return state.getValue(OPEN);
            case WATER:
            default:
                return false;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level world = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        Direction direction = context.getHorizontalDirection();
        Direction.Axis axis = direction.getAxis();
        FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());
        boolean flag1 = axis == Direction.Axis.Z && (this.isWall(world.getBlockState(blockpos.m_142125_())) || this.isWall(world.getBlockState(blockpos.m_142126_()))) || axis == Direction.Axis.X && (this.isWall(world.getBlockState(blockpos.m_142127_())) || this.isWall(world.getBlockState(blockpos.m_142128_())));
        return this.defaultBlockState().setValue(FACING, direction).setValue(IN_WALL, flag1).setValue(WATERLOGGED, ifluidstate.getType() == Fluids.WATER);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (state.getValue(OPEN)) {
            state = state.setValue(OPEN, false);
            level.setBlock(blockPos, state, 10);
        } else {
            Direction Direction = player.getDirection();

            if (state.getValue(FACING) == Direction.getOpposite()) {
                state = state.setValue(FACING, Direction);
            }

            state = state.setValue(OPEN, true);
            level.setBlock(blockPos, state, 10);
        }

        level.levelEvent(player, state.getValue(OPEN) ? 1008 : 1014, blockPos, 0);
        return InteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, OPEN, IN_WALL, POWERED, WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, BlockPos blockPos1, boolean bool) {

    }

    private boolean isWall(BlockState blockstate) {
        return blockstate.is(BlockTags.WALLS);
    }
}