package com.conquestrefabricated.content.blocks.block.vanilla;

import com.conquestrefabricated.content.blocks.block.util.PlacementHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.CarrotsBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class CarrotsVanilla extends CarrotsBlock {

    public CarrotsVanilla(Settings properties) {
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
