package com.conquestreforged.content.blocks.block.trees;

import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.block.*;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

@Render(RenderLayer.CUTOUT_MIPPED)
public class LeavesFruit extends CropBlock {

    public static final IntProperty DISTANCE = Properties.DISTANCE_1_7;
    public static final BooleanProperty PERSISTENT = Properties.PERSISTENT;
    private final ItemConvertible fruit;

    public LeavesFruit(Props props) {
        super(props.toSettings());
        this.fruit = props.get("fruit", ItemConvertible.class);
        this.setDefaultState(this.stateManager.getDefaultState().with(DISTANCE, 7).with(PERSISTENT, false).with(AGE, 0));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.fullCube();
    }

    @Override
    public boolean isTranslucent(BlockState state, BlockView blockGetter, BlockPos blockPos) {
        return false;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, net.minecraft.util.math.random.Random rand) {
        /*
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
        }*/

        if (!state.get(PERSISTENT) && state.get(DISTANCE) == 7) {
//            state.dropBlockAsItem(world, pos, 0);
            //world.removeBlock(pos, true);
        }
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        /*if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (worldIn.getRawBrightness(pos, 0) >= 9) {
            int i = this.getAge(state);
            if (i < this.getMaxAge()) {
                float f = getGrowthSpeed(this, worldIn, pos);
                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt((int)(25.0F / f) + 1) == 0)) {
                    worldIn.setBlock(pos, this.getStateForAge(i + 1), 2);
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
                }
            }
        }*/

        //worldIn.setBlock(pos, updateDistance(state, worldIn, pos), 3);

    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction facing, BlockState state1, WorldAccess world, BlockPos pos, BlockPos pos1) {
        int i = getDistance(state1) + 1;
        if (i != 1 || state.get(DISTANCE) != i) {
            world.createAndScheduleBlockTick(pos, this, 1);
        }

        return state;
    }

    private static BlockState updateDistance(BlockState state, WorldAccess worldIn, BlockPos pos) {
        int i = 7;
        BlockPos.Mutable blockPosMutable = new BlockPos.Mutable();
        for(Direction direction : Direction.values()) {
            blockPosMutable.set(pos, direction);
            i = Math.min(i, getDistance(worldIn.getBlockState(blockPosMutable)) + 1);
            if (i == 1) {
                break;
            }
        }
        return state.with(DISTANCE, Integer.valueOf(i));
    }

    private static int getDistance(BlockState neighbor) {
        if (neighbor.isIn(BlockTags.LOGS)) {
            return 0;
        } else {
            return (neighbor.getBlock() instanceof LeavesBlock || neighbor.getBlock() instanceof LeavesFruit) ? neighbor.get(DISTANCE) : 7;
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateList) {
        stateList.add(DISTANCE, PERSISTENT, AGE);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return updateDistance(this.getDefaultState().with(PERSISTENT, true), context.getWorld(), context.getBlockPos());
    }

    @Override
    public VoxelShape getRaycastShape(BlockState state, BlockView reader, BlockPos pos) {
        return VoxelShapes.fullCube();
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView reader, BlockPos pos) {
        return true;
    }

    @Override
    public boolean canPlantOnTop(BlockState p_200014_1_, BlockView p_200014_2_, BlockPos p_200014_3_) {
        return true;
    }

    @Override
    public ItemStack getPickStack(BlockView reader, BlockPos pos, BlockState state) {
        return new ItemStack(this, 1);
    }

    @Override
    public ActionResult onUse(BlockState state, World level, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        if (this.isMature(state)) {
            if (level.isClient) {
                return ActionResult.SUCCESS;
            } else {
                state = state.with(AGE, 0);
                level.setBlockState(blockPos, state, 3);
                this.dropFruit(level, blockPos, state);
                return ActionResult.SUCCESS;

            }
        }
        return ActionResult.FAIL;
    }

    private void dropFruit(World world, BlockPos pos, BlockState state) {
        if (!world.isClient) {
            float f = 0.7F;
            double d0 = (double) (world.random.nextFloat() * 0.7F) + 0.15000000596046448D;
            double d1 = (double) (world.random.nextFloat() * 0.7F) + 0.06000000238418579D + 0.6D;
            double d2 = (double) (world.random.nextFloat() * 0.7F) + 0.15000000596046448D;
            ItemStack itemstack1 = new ItemStack(fruit, 1);
            ItemEntity entityitem = new ItemEntity(world, (double) pos.getX() + d0, (double) pos.getY() + d1, (double) pos.getZ() + d2, itemstack1);
            entityitem.setToDefaultPickupDelay();
            world.spawnEntity(entityitem);
        }
    }


    public OffsetType getOffsetType() {
        return OffsetType.NONE;
    }
}
