package com.conquestrefabricated.content.blocks.init.blocks;

import com.conquestrefabricated.content.blocks.block.plants.LilyPad;
import com.conquestrefabricated.content.items.item.LilypadItem;
import com.conquestrefabricated.core.init.Context;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

public class LiliesInit {

    public static final Block BIG_WATER_LILIES = createBlock("big_water_lilies", Material.SOLID_ORGANIC, BlockSoundGroup.GRASS, true);
    public static final Block DUCKWEED = createBlock("duckweed", Material.SOLID_ORGANIC, BlockSoundGroup.GRASS, false);
    public static final Block FLOATING_ICE = createBlock("floating_ice", Material.ICE, BlockSoundGroup.GLASS, false);

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, Context.getInstance().getNamespace()+":"+"big_water_lilies", BIG_WATER_LILIES);
        Registry.register(Registry.BLOCK, Context.getInstance().getNamespace()+":"+"duckweed", DUCKWEED);
        Registry.register(Registry.BLOCK, Context.getInstance().getNamespace()+":"+"floating_ice", FLOATING_ICE);
    }

    public static void registerItems() {
        Registry.register(Registry.ITEM, Context.getInstance().getNamespace()+":"+"big_water_lilies", createItem(BIG_WATER_LILIES));
        Registry.register(Registry.ITEM, Context.getInstance().getNamespace()+":"+"duckweed", createItem(DUCKWEED));
        Registry.register(Registry.ITEM, Context.getInstance().getNamespace()+":"+"floating_ice", createItem(FLOATING_ICE));
    }

    private static LilyPad createBlock(String name, Material material, BlockSoundGroup soundType, boolean hasCollision) {
        AbstractBlock.Settings props = AbstractBlock.Settings.of(material, material.getColor())
                .strength(0.5F)
                .sounds(soundType);
        if (!hasCollision) {
            props = props.noCollision();
        }

        LilyPad block = new LilyPad(props);
      //  block.setRegistryName(Context.getInstance().getNamespace(), name);
        return block;
    }

    private static Item createItem(Block block) {
        Item item = new LilypadItem(block, (new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
     //   item.setRegistryName(block.getRegistryName());
        return item;
    }
}
