package com.conquestreforged.core.block.builder;

import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.PushReaction;

public class BlockMaterials {
    public static final Material WOOD_SPECIAL = (new Material(MaterialColor.WOOD, false, true, true, true, false, true, false, PushReaction.NORMAL));
    public static final Material ROCK_SPECIAL = (new Material(MaterialColor.STONE, false, true, true, true, false, false, false, PushReaction.NORMAL));
}
