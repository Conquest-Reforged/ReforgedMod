package com.conquestrefabricated.content.blocks.block;

import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.properties.Waterloggable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

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

    private static final BooleanProperty OPEN = Properties.OPEN;
    private static final BooleanProperty IN_WALL = Properties.IN_WALL;
    private static final VoxelShape AABB_HITBOX_ZAXIS = Block.createCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
    private static final VoxelShape AABB_HITBOX_XAXIS = Block.createCuboidShape(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);
    private static final VoxelShape AABB_HITBOX_ZAXIS_INWALL = Block.createCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 13.0D, 10.0D);
    private static final VoxelShape AABB_HITBOX_XAXIS_INWALL = Block.createCuboidShape(6.0D, 0.0D, 0.0D, 10.0D, 13.0D, 16.0D);
    private static final VoxelShape field_208068_x = Block.createCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 24.0D, 10.0D);
    private static final VoxelShape AABB_COLLISION_BOX_XAXIS = Block.createCuboidShape(6.0D, 0.0D, 0.0D, 10.0D, 24.0D, 16.0D);
    private static final VoxelShape field_208069_z = VoxelShapes.union(Block.createCuboidShape(0.0D, 5.0D, 7.0D, 2.0D, 16.0D, 9.0D), Block.createCuboidShape(14.0D, 5.0D, 7.0D, 16.0D, 16.0D, 9.0D));
    private static final VoxelShape AABB_COLLISION_BOX_ZAXIS = VoxelShapes.union(Block.createCuboidShape(7.0D, 5.0D, 0.0D, 9.0D, 16.0D, 2.0D), Block.createCuboidShape(7.0D, 5.0D, 14.0D, 9.0D, 16.0D, 16.0D));
    private static final VoxelShape field_208066_B = VoxelShapes.union(Block.createCuboidShape(0.0D, 2.0D, 7.0D, 2.0D, 13.0D, 9.0D), Block.createCuboidShape(14.0D, 2.0D, 7.0D, 16.0D, 13.0D, 9.0D));
    private static final VoxelShape field_208067_C = VoxelShapes.union(Block.createCuboidShape(7.0D, 2.0D, 0.0D, 9.0D, 13.0D, 2.0D), Block.createCuboidShape(7.0D, 2.0D, 14.0D, 9.0D, 13.0D, 16.0D));

    public FenceGate(Settings properties) {
        super(properties);
        this.setDefaultState((this.stateManager.getDefaultState()).with(OPEN, false).with(IN_WALL, false).with(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(IN_WALL)) {
            return state.get(FACING).getAxis() == Direction.Axis.X ? AABB_HITBOX_XAXIS_INWALL : AABB_HITBOX_ZAXIS_INWALL;
        } else {
            return state.get(FACING).getAxis() == Direction.Axis.X ? AABB_HITBOX_XAXIS : AABB_HITBOX_ZAXIS;
        }
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(OPEN)) {
            return VoxelShapes.empty();
        } else {
            return state.get(FACING).getAxis() == Direction.Axis.Z ? field_208068_x : AABB_COLLISION_BOX_XAXIS;
        }
    }

    @Override
    public VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
        if (state.get(IN_WALL)) {
            return state.get(FACING).getAxis() == Direction.Axis.X ? field_208067_C : field_208066_B;
        } else {
            return state.get(FACING).getAxis() == Direction.Axis.X ? AABB_COLLISION_BOX_ZAXIS : field_208069_z;
        }
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        switch (type) {
            case LAND:
            case AIR:
                return state.get(OPEN);
            case WATER:
            default:
                return false;
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        World world = context.getWorld();
        BlockPos blockpos = context.getBlockPos();
        Direction direction = context.getPlayerFacing();
        Direction.Axis axis = direction.getAxis();
        FluidState ifluidstate = context.getWorld().getFluidState(context.getBlockPos());
        boolean flag1 = axis == Direction.Axis.Z && (this.isWall(world.getBlockState(blockpos.west())) || this.isWall(world.getBlockState(blockpos.east()))) || axis == Direction.Axis.X && (this.isWall(world.getBlockState(blockpos.north())) || this.isWall(world.getBlockState(blockpos.south())));
        return this.getDefaultState().with(FACING, direction).with(IN_WALL, flag1).with(WATERLOGGED, ifluidstate.getFluid() == Fluids.WATER);
    }

    @Override
    public ActionResult onUse(BlockState state, World level, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        if (state.get(OPEN)) {
            state = state.with(OPEN, false);
            level.setBlockState(blockPos, state, 10);
        } else {
            Direction Direction = player.getHorizontalFacing();

            if (state.get(FACING) == Direction.getOpposite()) {
                state = state.with(FACING, Direction);
            }

            state = state.with(OPEN, true);
            level.setBlockState(blockPos, state, 10);
        }

        level.syncWorldEvent(player, state.get(OPEN) ? 1008 : 1014, blockPos, 0);
        return ActionResult.SUCCESS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, OPEN, IN_WALL, POWERED, WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public void neighborUpdate(BlockState blockState, World level, BlockPos blockPos, Block block, BlockPos blockPos1, boolean bool) {

    }

    private boolean isWall(BlockState blockstate) {
        return blockstate.isIn(BlockTags.WALLS);
    }
}