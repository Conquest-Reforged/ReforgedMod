package com.conquestrefabricated.content.blocks.init.blocks;

import com.conquestrefabricated.content.blocks.block.decor.Scaffolding;
import com.conquestrefabricated.content.items.item.ScaffoldingItem;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

public class ScaffoldingInit {

    public static final Block METAL_SCAFFOLDING = createBlock("metal_scaffolding", Material.METAL, BlockSoundGroup.METAL);
    public static final Block WOOD_SCAFFOLDING = createBlock("wood_scaffolding", Material.WOOD, BlockSoundGroup.WOOD);

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, "conquest:metal_scaffolding", METAL_SCAFFOLDING);
        Registry.register(Registry.BLOCK, "conquest:wood_scaffolding", WOOD_SCAFFOLDING);
    }

    public static void registerItems() {
        Registry.register(Registry.ITEM, "conquest:metal_scaffolding", createItem(METAL_SCAFFOLDING));
        Registry.register(Registry.ITEM, "conquest:wood_scaffolding", createItem(WOOD_SCAFFOLDING));
    }

    private static Scaffolding createBlock(String name, Material material, BlockSoundGroup soundType) {
        Scaffolding block = new Scaffolding(
                AbstractBlock.Settings.of(material, material.getColor())
                        .strength(0.5F)
                        .sounds(soundType)
        );
       // block.setRegistryName(Context.getInstance().getNamespace(), name);
        return block;
    }

    private static Item createItem(Block block) {
        Item item = new ScaffoldingItem(block, (new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        //item.setRegistryName(block.getRegistryName());
        return item;
    }
}
