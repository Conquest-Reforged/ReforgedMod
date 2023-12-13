package com.conquestreforged.blocks.block.vanilla;

import com.conquestreforged.blocks.block.Layer;
import com.conquestreforged.blocks.block.Slab;
import com.conquestreforged.blocks.block.util.PlacementHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.CactusBlock;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class CactusVanilla extends CactusBlock {

    public static final IntegerProperty LAYERS = BlockStateProperties.LAYERS;

    public CactusVanilla(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(LAYERS, 8));
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        if (PlacementHelper.isDuringWorldGen(worldIn)) {
            return super.canSurvive(state, worldIn, pos);
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

}
