package com.conquestreforged.core.block.builder;

import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.piston.PistonBehavior;

public class BlockMaterials {
    public static final Material WOOD_SPECIAL = (new Material(MapColor.OAK_TAN, false, true, true, true, false, true, PistonBehavior.NORMAL));
    public static final Material ROCK_SPECIAL = (new Material(MapColor.STONE_GRAY, false, true, true, true, false, false, PistonBehavior.NORMAL));
}
