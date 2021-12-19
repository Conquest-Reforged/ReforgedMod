package com.conquestreforged.core.block.builder;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.PushReaction;

public class BlockMaterials {
    public static final Material WOOD_SPECIAL = (new Material(MaterialColor.WOOD, false, true, true, true, false, true, PushReaction.NORMAL));
    public static final Material ROCK_SPECIAL = (new Material(MaterialColor.STONE, false, true, true, true, false, false, PushReaction.NORMAL));
}
