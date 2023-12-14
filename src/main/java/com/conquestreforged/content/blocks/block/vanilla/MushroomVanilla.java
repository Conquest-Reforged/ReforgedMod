package com.conquestreforged.content.blocks.block.vanilla;

import com.conquestreforged.content.blocks.block.Layer;
import com.conquestreforged.content.blocks.block.Slab;
import com.conquestreforged.content.blocks.block.plants.Bush;
import com.conquestreforged.content.blocks.block.util.PlacementHelper;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;


public class MushroomVanilla extends Bush {

    public MushroomVanilla(AbstractBlock.Settings properties) {
        super(properties);

    }

    @Override
    public boolean canPlantOnTop(BlockState state, BlockView world, BlockPos pos) {
        if (PlacementHelper.isDuringWorldGen(world)) {
            return super.canPlantOnTop(state, world, pos);
        }
        return true;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        if (PlacementHelper.isDuringWorldGen(world)) {
            return super.canPlaceAt(state, world, pos);
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

}
