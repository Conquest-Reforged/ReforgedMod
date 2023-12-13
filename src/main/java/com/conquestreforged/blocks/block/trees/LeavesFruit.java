package com.conquestreforged.blocks.block.trees;

import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

@Render(RenderLayer.CUTOUT_MIPPED)
public class LeavesFruit extends CropBlock {

    public static final IntegerProperty DISTANCE = BlockStateProperties.DISTANCE;
    public static final BooleanProperty PERSISTENT = BlockStateProperties.PERSISTENT;
    private final ItemLike fruit;

    public LeavesFruit(Props props) {
        super(props.toProperties());
        this.fruit = props.get("fruit", ItemLike.class);
        this.registerDefaultState(this.stateDefinition.any().setValue(DISTANCE, 7).setValue(PERSISTENT, false).setValue(AGE, 0));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.block();
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }

    @Override
    public void m_7455_(BlockState state, ServerLevel world, BlockPos pos, Random rand) {
        if (!world.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (world.getRawBrightness(pos, 0) >= 9) {
            int i = this.getAge(state);
            if (i < this.getMaxAge()) {
                float f = getGrowthSpeed(this, world, pos);
                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(world, pos, state, rand.nextInt((int)(25.0F / f) + 1) == 0)) {
                    world.setBlock(pos, this.getStateForAge(i + 1), 2);
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(world, pos, state);
                }
            }
        }

        if (!state.getValue(PERSISTENT) && state.getValue(DISTANCE) == 7) {
//            state.dropBlockAsItem(world, pos, 0);
            //world.removeBlock(pos, true);
        }
    }

    @Override
    public void m_7458_(BlockState state, ServerLevel worldIn, BlockPos pos, Random rand) {
        if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (worldIn.getRawBrightness(pos, 0) >= 9) {
            int i = this.getAge(state);
            if (i < this.getMaxAge()) {
                float f = getGrowthSpeed(this, worldIn, pos);
                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt((int)(25.0F / f) + 1) == 0)) {
                    worldIn.setBlock(pos, this.getStateForAge(i + 1), 2);
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
                }
            }
        }

        worldIn.setBlock(pos, updateDistance(state, worldIn, pos), 3);

    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState state1, LevelAccessor world, BlockPos pos, BlockPos pos1) {
        int i = getDistance(state1) + 1;
        if (i != 1 || state.getValue(DISTANCE) != i) {
            world.scheduleTick(pos, this, 1);
        }

        return state;
    }

    private static BlockState updateDistance(BlockState state, LevelAccessor worldIn, BlockPos pos) {
        int i = 7;
        BlockPos.MutableBlockPos blockPosMutable = new BlockPos.MutableBlockPos();
        for(Direction direction : Direction.values()) {
            blockPosMutable.setWithOffset(pos, direction);
            i = Math.min(i, getDistance(worldIn.getBlockState(blockPosMutable)) + 1);
            if (i == 1) {
                break;
            }
        }
        return state.setValue(DISTANCE, Integer.valueOf(i));
    }

    private static int getDistance(BlockState neighbor) {
        if (neighbor.is(BlockTags.LOGS)) {
            return 0;
        } else {
            return (neighbor.getBlock() instanceof LeavesBlock || neighbor.getBlock() instanceof LeavesFruit) ? neighbor.getValue(DISTANCE) : 7;
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateList) {
        stateList.add(DISTANCE, PERSISTENT, AGE);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return updateDistance(this.defaultBlockState().setValue(PERSISTENT, true), context.getLevel(), context.getClickedPos());
    }

    @Override
    public VoxelShape getInteractionShape(BlockState state, BlockGetter reader, BlockPos pos) {
        return Shapes.block();
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        return true;
    }

    @Override
    protected boolean mayPlaceOn(BlockState p_200014_1_, BlockGetter p_200014_2_, BlockPos p_200014_3_) {
        return true;
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter reader, BlockPos pos, BlockState state) {
        return new ItemStack(this, 1);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (this.isMaxAge(state)) {
            if (level.isClientSide) {
                return InteractionResult.SUCCESS;
            } else {
                state = state.setValue(AGE, 0);
                level.setBlock(blockPos, state, 3);
                this.dropFruit(level, blockPos, state);
                return InteractionResult.SUCCESS;

            }
        }
        return InteractionResult.FAIL;
    }

    private void dropFruit(Level world, BlockPos pos, BlockState state) {
        if (!world.isClientSide) {
            float f = 0.7F;
            double d0 = (double) (world.random.nextFloat() * 0.7F) + 0.15000000596046448D;
            double d1 = (double) (world.random.nextFloat() * 0.7F) + 0.06000000238418579D + 0.6D;
            double d2 = (double) (world.random.nextFloat() * 0.7F) + 0.15000000596046448D;
            ItemStack itemstack1 = new ItemStack(fruit, 1);
            ItemEntity entityitem = new ItemEntity(world, (double) pos.getX() + d0, (double) pos.getY() + d1, (double) pos.getZ() + d2, itemstack1);
            entityitem.setDefaultPickUpDelay();
            world.addFreshEntity(entityitem);
        }
    }

    @Override
    public OffsetType m_5858_() {
        return OffsetType.NONE;
    }
}
