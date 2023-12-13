package com.conquestreforged.core.client.color;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.client.renderer.BiomeColors;

public class BlockColors {

    public static final BlockColor GRASS = (state, reader, pos, tint) -> {
        if (reader != null && pos != null) {
            return BiomeColors.getAverageGrassColor(reader, pos);
        }
        return defaultGrassColor();
    };

    public static final BlockColor FOLIAGE = (state, reader, pos, tint) -> {
        if (reader != null && pos != null) {
            return BiomeColors.getAverageFoliageColor(reader, pos);
        }
        return defaultFoliageColor();
    };

    public static final BlockColor WATER = (state, reader, pos, tint) -> {
        if (reader != null && pos != null) {
            return BiomeColors.getAverageWaterColor(reader, pos);
        }
        return defaultWaterColor();
    };

    public static ItemColor toItemColor(net.minecraft.client.color.block.BlockColors colors) {
        return (stack, tint) -> {
            BlockState state = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
            return colors.getColor(state, null, null, tint);
        };
    }

    /*
     * Defaults as per nmc BlockColors
     * net.minecraft.client.renderer.color.BlockColors
     */

    private static int defaultGrassColor() {
        return GrassColor.get(0.5, 1.0);
    }

    private static int defaultFoliageColor() {
        return FoliageColor.getDefaultColor();
    }

    private static int defaultWaterColor() {
        return -1;
    }
}
