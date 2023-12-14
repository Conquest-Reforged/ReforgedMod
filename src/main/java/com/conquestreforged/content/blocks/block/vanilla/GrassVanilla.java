package com.conquestreforged.content.blocks.block.vanilla;

import com.conquestreforged.content.blocks.block.util.PlacementHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.FernBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class GrassVanilla extends FernBlock {

    public GrassVanilla(Settings properties) {
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