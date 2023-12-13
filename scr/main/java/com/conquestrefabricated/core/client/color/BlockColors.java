package com.conquestrefabricated.core.client.color;

import net.minecraft.block.BlockState;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.item.BlockItem;

public class BlockColors {

    public static final BlockColorProvider GRASS = (state, reader, pos, tint) -> {
        if (reader != null && pos != null) {
            return BiomeColors.getGrassColor(reader, pos);
        }
        return defaultGrassColor();
    };

    public static final BlockColorProvider FOLIAGE = (state, reader, pos, tint) -> {
        if (reader != null && pos != null) {
            return BiomeColors.getFoliageColor(reader, pos);
        }
        return defaultFoliageColor();
    };

    public static final BlockColorProvider WATER = (state, reader, pos, tint) -> {
        if (reader != null && pos != null) {
            return BiomeColors.getWaterColor(reader, pos);
        }
        return defaultWaterColor();
    };

    public static ItemColorProvider toItemColor(net.minecraft.client.color.block.BlockColors colors) {
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
        return GrassColors.getColor(0.5, 1.0);
    }

    private static int defaultFoliageColor() {
        return FoliageColors.getDefaultColor();
    }

    private static int defaultWaterColor() {
        return -1;
    }
}
