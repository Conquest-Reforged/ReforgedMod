package com.conquestreforged.blocks.block.vanilla;

import com.conquestreforged.blocks.block.util.PlacementHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.BlockGetter;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class FlowerVanilla extends BushBlock {

    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    public FlowerVanilla(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any());

    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter world, BlockPos pos) {
        if (PlacementHelper.isDuringWorldGen(world)) {
            return super.mayPlaceOn(state, world, pos);
        }
        return true;
    }
}
