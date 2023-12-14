package com.conquestreforged.content.blocks.block.vanilla;

import com.conquestreforged.content.blocks.block.Layer;
import com.conquestreforged.content.blocks.block.Slab;
import com.conquestreforged.content.blocks.block.util.PlacementHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class TallGrassVanilla extends TallPlantBlock {

    public static final IntProperty LAYERS = Properties.LAYERS;

    public TallGrassVanilla(Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(HALF, DoubleBlockHalf.LOWER).with(LAYERS, 8));
    }

    @Override
    public boolean canPlantOnTop(BlockState state, BlockView world, BlockPos pos) {
        if (PlacementHelper.isDuringWorldGen(world)) {
            return super.canPlantOnTop(state, world, pos);
        }
        return true;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        if (state.get(HALF) != DoubleBlockHalf.UPPER) {
            return super.canPlaceAt(state, worldIn, pos);
        } else {
            BlockState blockstate = worldIn.getBlockState(pos.down());
            if (state.getBlock() != this) {
                return super.canPlaceAt(state, worldIn, pos); //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
            }
            if (blockstate.getBlock() == this && blockstate.get(HALF) == DoubleBlockHalf.LOWER) {
                return true;
            } else {
                return true;
            }
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockView iblockreader = context.getWorld();
        BlockPos blockpos = context.getBlockPos();
        BlockPos down = blockpos.down();
        BlockState blockStateDown = iblockreader.getBlockState(down);

        if (iblockreader.getBlockState(blockpos.up()).canReplace(context)) {
            if (blockStateDown.contains(Layer.LAYERS) || blockStateDown.contains(Slab.LAYERS) || blockStateDown.contains(TallGrassVanilla.LAYERS)) {
                return super.getPlacementState(context).with(LAYERS, blockStateDown.get(LAYERS));
            } else {
                return super.getPlacementState(context).with(LAYERS, 8);
            }
        } else {
            return null;
        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess worldIn, BlockPos currentPos, BlockPos facingPos) {
        DoubleBlockHalf doubleblockhalf = stateIn.get(HALF);
        BlockPos down = currentPos.down();
        BlockState blockStateDown = worldIn.getBlockState(down);

        if ((facing.getAxis() != Direction.Axis.Y || doubleblockhalf == DoubleBlockHalf.LOWER != (facing == Direction.UP) || facingState.getBlock() == this && facingState.get(HALF) != doubleblockhalf) && blockStateDown.contains(Layer.LAYERS) || blockStateDown.contains(Slab.LAYERS) || blockStateDown.contains(TallGrassVanilla.LAYERS)) {
            return doubleblockhalf == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !stateIn.canPlaceAt(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : stateIn.with(LAYERS, blockStateDown.get(LAYERS));
        } else if ((facing.getAxis() != Direction.Axis.Y || doubleblockhalf == DoubleBlockHalf.LOWER != (facing == Direction.UP) || facingState.getBlock() == this && facingState.get(HALF) != doubleblockhalf)) {
            return doubleblockhalf == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !stateIn.canPlaceAt(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : stateIn;
        } else {
            return Blocks.AIR.getDefaultState();
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HALF, LAYERS);
    }
}
