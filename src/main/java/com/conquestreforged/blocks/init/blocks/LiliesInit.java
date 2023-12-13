package com.conquestreforged.blocks.init.blocks;

import com.conquestreforged.blocks.block.plants.LilyPad;
import com.conquestreforged.core.init.Context;
import com.conquestreforged.items.item.LilypadItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.ForgeRegistries;

public class LiliesInit {

    public static final Block BIG_WATER_LILIES = createBlock("big_water_lilies", Material.GRASS, SoundType.GRASS, true);
    public static final Block DUCKWEED = createBlock("duckweed", Material.GRASS, SoundType.GRASS, false);
    public static final Block FLOATING_ICE = createBlock("floating_ice", Material.ICE, SoundType.GLASS, false);

    public static void registerBlocks() {
        ForgeRegistries.BLOCKS.register(BIG_WATER_LILIES);
        ForgeRegistries.BLOCKS.register(DUCKWEED);
        ForgeRegistries.BLOCKS.register(FLOATING_ICE);
    }

    public static void registerItems() {
        ForgeRegistries.ITEMS.register(createItem(BIG_WATER_LILIES));
        ForgeRegistries.ITEMS.register(createItem(DUCKWEED));
        ForgeRegistries.ITEMS.register(createItem(FLOATING_ICE));
    }

    private static LilyPad createBlock(String name, Material material, SoundType soundType, boolean hasCollision) {
        BlockBehaviour.Properties props = BlockBehaviour.Properties.of(material, material.getColor())
                .strength(0.5F)
                .sound(soundType);
        if (!hasCollision) {
            props.noCollission();
        }

        LilyPad block = new LilyPad(props);
        block.setRegistryName(Context.getInstance().getNamespace(), name);
        return block;
    }

    private static Item createItem(Block block) {
        Item item = new LilypadItem(block, (new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
        item.setRegistryName(block.getRegistryName());
        return item;
    }
}
