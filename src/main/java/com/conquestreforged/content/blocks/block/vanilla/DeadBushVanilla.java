package com.conquestreforged.content.blocks.block.vanilla;

import com.conquestreforged.content.blocks.block.util.PlacementHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.DeadBushBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class DeadBushVanilla extends DeadBushBlock {

    public DeadBushVanilla(Settings properties) {
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