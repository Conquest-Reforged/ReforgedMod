package com.conquestrefabricated.content.blocks.block.vanilla;

import com.conquestrefabricated.content.blocks.block.Layer;
import com.conquestrefabricated.content.blocks.block.Slab;
import com.conquestrefabricated.content.blocks.block.util.PlacementHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CactusBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class CactusVanilla extends CactusBlock {

    public static final IntProperty LAYERS = Properties.LAYERS;

    public CactusVanilla(Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(LAYERS, 8));
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        if (PlacementHelper.isDuringWorldGen(worldIn)) {
            return super.canPlaceAt(state, worldIn, pos);
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

}
