package com.conquestrefabricated.core.init;

import com.conquestrefabricated.core.block.data.BlockData;
import com.conquestrefabricated.core.block.data.BlockDataRegistry;
import com.conquestrefabricated.core.block.data.ColorType;
import com.conquestrefabricated.core.client.color.BlockColors;
import com.conquestrefabricated.core.util.log.Log;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.color.item.ItemColors;


@Environment(EnvType.CLIENT)
public class InitClient {

    public static void blockColors(net.minecraft.client.color.block.BlockColors blockColors) {
        Log.debug("Registering block colors");
        for (BlockData data : BlockDataRegistry.getInstance()) {
            if (data.getProps().getColorType() == ColorType.GRASS) {
             blockColors.registerColorProvider(BlockColors.GRASS, data.getBlock());
            } else if (data.getProps().getColorType() == ColorType.FOLIAGE) {
               blockColors.registerColorProvider(BlockColors.FOLIAGE, data.getBlock());
            } else if (data.getProps().getColorType() == ColorType.WATER) {
                blockColors.registerColorProvider(BlockColors.WATER, data.getBlock());
            }
        }
    }
    public static void itemColors(ItemColors itemColors, net.minecraft.client.color.block.BlockColors blockColors) {
        Log.debug("Registering item colors");

        ItemColorProvider itemColor = BlockColors.toItemColor(blockColors);
        for (BlockData data : BlockDataRegistry.getInstance()) {
            if (data.getProps().getColorType() == ColorType.GRASS || data.getProps().getColorType() == ColorType.FOLIAGE) {
                itemColors.register(itemColor, data.getItem());
            }
        }
    }

    public static void init() {
        Log.debug("Registering block render layers");
        BlockDataRegistry.getInstance().forEach(BlockData::addRenders);
    }
}
