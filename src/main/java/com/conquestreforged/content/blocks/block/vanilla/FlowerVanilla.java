package com.conquestreforged.content.blocks.block.vanilla;

import com.conquestreforged.content.blocks.block.util.PlacementHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class FlowerVanilla extends PlantBlock {

    protected static final VoxelShape SHAPE = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    public FlowerVanilla(Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState());

    }

    @Override
    public boolean canPlantOnTop(BlockState state, BlockView world, BlockPos pos) {
        if (PlacementHelper.isDuringWorldGen(world)) {
            return super.canPlantOnTop(state, world, pos);
        }
        return true;
    }
}
