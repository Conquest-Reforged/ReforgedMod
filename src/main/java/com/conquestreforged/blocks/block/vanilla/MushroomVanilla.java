package com.conquestreforged.blocks.block.vanilla;

import com.conquestreforged.blocks.block.Layer;
import com.conquestreforged.blocks.block.Slab;
import com.conquestreforged.blocks.block.plants.Bush;
import com.conquestreforged.blocks.block.util.PlacementHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;


public class MushroomVanilla extends Bush {

    public MushroomVanilla(BlockBehaviour.Properties properties) {
        super(properties);

    }

    @Override
    public boolean mayPlaceOn(BlockState state, BlockGetter world, BlockPos pos) {
        if (PlacementHelper.isDuringWorldGen(world)) {
            return super.mayPlaceOn(state, world, pos);
        }
        return true;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        if (PlacementHelper.isDuringWorldGen(world)) {
            return super.canSurvive(state, world, pos);
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

}
