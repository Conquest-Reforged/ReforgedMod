package com.conquestreforged.core.client.color;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.BlockItem;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.GrassColors;
import net.minecraft.world.biome.BiomeColors;

public class BlockColors {

    public static final IBlockColor GRASS = (state, reader, pos, tint) -> {
        if (reader != null && pos != null) {
            return BiomeColors.func_228358_a_(reader, pos);
        }
        return defaultGrassColor();
    };

    public static final IBlockColor FOLIAGE = (state, reader, pos, tint) -> {
        if (reader != null && pos != null) {
            return BiomeColors.func_228361_b_(reader, pos);
        }
        return defaultFoliageColor();
    };

    public static final IBlockColor WATER = (state, reader, pos, tint) -> {
        if (reader != null && pos != null) {
            return BiomeColors.getWaterColor(reader, pos);
        }
        return defaultWaterColor();
    };

    public static IItemColor toItemColor(net.minecraft.client.renderer.color.BlockColors colors) {
        return (stack, tint) -> {
            BlockState state = ((BlockItem) stack.getItem()).getBlock().getDefaultState();
            return colors.getColor(state, null, null, tint);
        };
    }

    /*
     * Defaults as per nmc BlockColors
     * net.minecraft.client.renderer.color.BlockColors
     */

    private static int defaultGrassColor() {
        return GrassColors.get(0.5, 1.0);
    }

    private static int defaultFoliageColor() {
        return FoliageColors.getDefault();
    }

    private static int defaultWaterColor() {
        return -1;
    }
}
