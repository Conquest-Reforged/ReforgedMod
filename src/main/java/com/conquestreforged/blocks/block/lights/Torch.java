package com.conquestreforged.blocks.block.lights;

import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.block.properties.Waterloggable;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@Render(RenderLayer.CUTOUT)
public class Torch extends Block implements Waterloggable {

    public static final DirectionProperty FACING = DirectionalBlock.FACING;
    public static final IntegerProperty LIGHT_0_3 = IntegerProperty.create("light", 0, 3);
    protected static final VoxelShape EAST_OPEN_AABB = Block.box(0.0D, 0.0D, 4.0D, 10.0D, 16.0D, 11.0D);
    protected static final VoxelShape WEST_OPEN_AABB = Block.box(6.0D, 0.0D, 4.0D, 16.0D, 16.0D, 11.0D);
    protected static final VoxelShape SOUTH_OPEN_AABB = Block.box(4.0D, 0.0D, 0.0D, 11.0D, 16.0D, 10.0D);
    protected static final VoxelShape NORTH_OPEN_AABB = Block.box(4.0D, 0.0D, 6.0D, 11.0D, 16.0D, 16.0D);
    protected static final VoxelShape BOTTOM_AABB = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
    protected static final VoxelShape TOP_AABB = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);

    public Torch(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIGHT_0_3, 0).setValue(WATERLOGGED, false));

    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getClickedFace());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        {
            switch (state.getValue(FACING)) {
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
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, LIGHT_0_3, WATERLOGGED);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!player.getAbilities().mayBuild) {
            return InteractionResult.FAIL;
        } else {
            if (player.getItemInHand(hand).getItem() == Items.FLINT_AND_STEEL) {
                level.setBlock(blockPos, state.setValue(LIGHT_0_3, 3),3);
                return InteractionResult.SUCCESS;
            } else {
                return InteractionResult.FAIL;
            }
        }
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.getValue(WATERLOGGED)) {
            world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }

        return super.updateShape(stateIn, facing, facingState, world, currentPos, facingPos);
    }
}
