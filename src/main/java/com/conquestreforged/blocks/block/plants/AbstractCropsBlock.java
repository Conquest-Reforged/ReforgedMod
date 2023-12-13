package com.conquestreforged.blocks.block.plants;

import com.conquestreforged.blocks.block.Layer;
import com.conquestreforged.blocks.block.Slab;
import com.conquestreforged.blocks.block.util.PlacementHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;

import java.util.Random;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public abstract class AbstractCropsBlock extends CropBlock {

    public static final IntegerProperty LAYERS = BlockStateProperties.LAYERS;

    protected AbstractCropsBlock(Properties builder) {
        super(builder);
        this.registerDefaultState(this.stateDefinition.any().setValue(LAYERS, 8).setValue(AGE, 0));
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        if (PlacementHelper.isDuringWorldGen(reader)) {
            return super.canSurvive(state, reader, pos);
        }
        return true;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter reader, BlockPos pos) {
        if (PlacementHelper.isDuringWorldGen(reader)) {
            return super.mayPlaceOn(state, reader, pos);
        }
        return true;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockGetter iblockreader = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockPos down = blockpos.below();
        BlockState blockStateDown = iblockreader.getBlockState(down);

        if (blockStateDown.hasProperty(Layer.LAYERS) || blockStateDown.hasProperty(Slab.LAYERS)) {
            return super.getStateForPlacement(context).setValue(LAYERS, blockStateDown.getValue(LAYERS));
        } else {
            return super.getStateForPlacement(context).setValue(LAYERS, 8);
        }
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
        BlockPos down = currentPos.below();
        BlockState blockStateDown = worldIn.getBlockState(down);

        if (blockStateDown.hasProperty(Layer.LAYERS) || blockStateDown.hasProperty(Slab.LAYERS)) {
            return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos).setValue(LAYERS, blockStateDown.getValue(LAYERS));
        } else {
            return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos).setValue(LAYERS, 8);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE, LAYERS);
    }

    @Override
    public void m_7455_(BlockState state, ServerLevel serverWorld, BlockPos blockPos, Random random) {
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

    }

    //Override to prevent use of #withAge (uses #getDefaultState, resetting Layers state)
    @Override
    public void growCrops(Level worldIn, BlockPos pos, BlockState state) {
        int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
        int j = this.getMaxAge();
        if (i > j) {
            i = j;
        }

        worldIn.setBlock(pos, state.setValue(AGE, i), 2);
    }

    //Override to prevent use of #withAge (uses #getDefaultState, resetting Layers state)
    @Override
    public void m_7458_(BlockState state, ServerLevel worldIn, BlockPos pos, Random rand) {
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
        }
    }
}
