package com.conquestrefabricated.content.blocks.block.lights;

import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.block.properties.Waterloggable;
import com.conquestrefabricated.core.util.RenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

@Render(RenderLayer.CUTOUT)
public class Torch extends Block implements Waterloggable {

    public static final DirectionProperty FACING = FacingBlock.FACING;
    public static final IntProperty LIGHT_0_3 = IntProperty.of("light", 0, 3);
    protected static final VoxelShape EAST_OPEN_AABB = Block.createCuboidShape(0.0D, 0.0D, 4.0D, 10.0D, 16.0D, 11.0D);
    protected static final VoxelShape WEST_OPEN_AABB = Block.createCuboidShape(6.0D, 0.0D, 4.0D, 16.0D, 16.0D, 11.0D);
    protected static final VoxelShape SOUTH_OPEN_AABB = Block.createCuboidShape(4.0D, 0.0D, 0.0D, 11.0D, 16.0D, 10.0D);
    protected static final VoxelShape NORTH_OPEN_AABB = Block.createCuboidShape(4.0D, 0.0D, 6.0D, 11.0D, 16.0D, 16.0D);
    protected static final VoxelShape BOTTOM_AABB = Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
    protected static final VoxelShape TOP_AABB = Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);

    public Torch(Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(LIGHT_0_3, 0).with(WATERLOGGED, false));

    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(FACING, context.getSide());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        {
            switch (state.get(FACING)) {
                case NORTH:
                default:
                    return NORTH_OPEN_AABB;
                case SOUTH:
                    return SOUTH_OPEN_AABB;
                case WEST:
                    return WEST_OPEN_AABB;
                case EAST:
                    return EAST_OPEN_AABB;
                case DOWN:
                    return TOP_AABB;
                case UP:
                    return BOTTOM_AABB;
            }
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, LIGHT_0_3, WATERLOGGED);
    }

    @Override
    public ActionResult onUse(BlockState state, World level, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        if (!player.getAbilities().allowModifyWorld) {
            return ActionResult.FAIL;
        } else {
            if (player.getStackInHand(hand).getItem() == Items.FLINT_AND_STEEL) {
                level.setBlockState(blockPos, state.with(LIGHT_0_3, 3),3);
                return ActionResult.SUCCESS;
            } else {
                return ActionResult.FAIL;
            }
        }
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess world, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.get(WATERLOGGED)) {
            world.createAndScheduleFluidTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.getStateForNeighborUpdate(stateIn, facing, facingState, world, currentPos, facingPos);
    }
}
