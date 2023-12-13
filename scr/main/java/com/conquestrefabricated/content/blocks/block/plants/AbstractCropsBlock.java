package com.conquestrefabricated.content.blocks.block.plants;

import com.conquestrefabricated.content.blocks.block.Layer;
import com.conquestrefabricated.content.blocks.block.Slab;
import com.conquestrefabricated.content.blocks.block.util.PlacementHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public abstract class AbstractCropsBlock extends CropBlock {

    public static final IntProperty LAYERS = Properties.LAYERS;

    protected AbstractCropsBlock(Settings builder) {
        super(builder);
        this.setDefaultState(this.stateManager.getDefaultState().with(LAYERS, 8).with(AGE, 0));
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView reader, BlockPos pos) {
        if (PlacementHelper.isDuringWorldGen(reader)) {
            return super.canPlaceAt(state, reader, pos);
        }
        return true;
    }

    @Override
    public boolean canPlantOnTop(BlockState state, BlockView reader, BlockPos pos) {
        if (PlacementHelper.isDuringWorldGen(reader)) {
            return super.canPlantOnTop(state, reader, pos);
        }
        return true;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockView iblockreader = context.getWorld();
        BlockPos blockpos = context.getBlockPos();
        BlockPos down = blockpos.down();
        BlockState blockStateDown = iblockreader.getBlockState(down);

        if (blockStateDown.contains(Layer.LAYERS) || blockStateDown.contains(Slab.LAYERS)) {
            return super.getPlacementState(context).with(LAYERS, blockStateDown.get(LAYERS));
        } else {
            return super.getPlacementState(context).with(LAYERS, 8);
        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess worldIn, BlockPos currentPos, BlockPos facingPos) {
        BlockPos down = currentPos.down();
        BlockState blockStateDown = worldIn.getBlockState(down);

        if (blockStateDown.contains(Layer.LAYERS) || blockStateDown.contains(Slab.LAYERS)) {
            return super.getStateForNeighborUpdate(stateIn, facing, facingState, worldIn, currentPos, facingPos).with(LAYERS, blockStateDown.get(LAYERS));
        } else {
            return super.getStateForNeighborUpdate(stateIn, facing, facingState, worldIn, currentPos, facingPos).with(LAYERS, 8);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE, LAYERS);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld serverWorld, BlockPos blockPos, net.minecraft.util.math.random.Random random) {
       /*
        if (!serverWorld.isAreaLoaded(blockPos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (serverWorld.getRawBrightness(blockPos, 0) >= 9) {
            int i = this.getAge(state);
            if (i < this.getMaxAge()) {
                float f = getGrowthSpeed(this, serverWorld, blockPos);
                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(serverWorld, blockPos, state, random.nextInt((int)(25.0F / f) + 1) == 0)) {
                    serverWorld.setBlock(blockPos, state.setValue(getAgeProperty(),i + 1), 2);
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(serverWorld, blockPos, state);
                }
            }
        }
*/
    }

    //Override to prevent use of #withAge (uses #getDefaultState, resetting Layers state)
    @Override
    public void applyGrowth(World worldIn, BlockPos pos, BlockState state) {
        int i = this.getAge(state) + this.getGrowthAmount(worldIn);
        int j = this.getMaxAge();
        if (i > j) {
            i = j;
        }

        worldIn.setBlockState(pos, state.with(AGE, i), 2);
    }

    //Override to prevent use of #withAge (uses #getDefaultState, resetting Layers state)
    @Override
    public void scheduledTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        /*
        if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (worldIn.getRawBrightness(pos, 0) >= 9) {
            int i = this.getAge(state);
            if (i < this.getMaxAge()) {
                float f = getGrowthSpeed(this, worldIn, pos);
                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt((int)(25.0F / f) + 1) == 0)) {
                    worldIn.setBlock(pos, state.setValue(AGE, i + 1), 2);
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
                }
            }
        }*/
    }
}
