package com.conquestreforged.blocks.block.decor;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;

//used for new flowers in the flowerpot

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class FlowerPot extends FlowerPotBlock {

    public FlowerPot(Properties properties) {
        super(Blocks.AIR, properties);
    }
}
