package com.conquestreforged.blocks.block.vanilla;

import com.conquestreforged.blocks.block.util.PlacementHelper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.PotatoBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class PotatoesVanilla extends PotatoBlock {

    public PotatoesVanilla(Properties properties) {
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
