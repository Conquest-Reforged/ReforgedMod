package com.conquestreforged.blocks.init.blocks;

import com.conquestreforged.blocks.block.decor.Scaffolding;
import com.conquestreforged.core.init.Context;
import com.conquestreforged.items.item.ScaffoldingItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.ForgeRegistries;

public class ScaffoldingInit {

    public static final Block METAL_SCAFFOLDING = createBlock("metal_scaffolding", Material.METAL, SoundType.METAL);
    public static final Block WOOD_SCAFFOLDING = createBlock("wood_scaffolding", Material.WOOD, SoundType.WOOD);

    public static void registerBlocks() {
        ForgeRegistries.BLOCKS.register(METAL_SCAFFOLDING);
        ForgeRegistries.BLOCKS.register(WOOD_SCAFFOLDING);
    }

    public static void registerItems() {
        ForgeRegistries.ITEMS.register(createItem(METAL_SCAFFOLDING));
        ForgeRegistries.ITEMS.register(createItem(WOOD_SCAFFOLDING));
    }

    private static Scaffolding createBlock(String name, Material material, SoundType soundType) {
        Scaffolding block = new Scaffolding(
                Block.Properties.of(material, material.getColor())
                        .strength(0.5F)
                        .sound(soundType)
        );
        block.setRegistryName(Context.getInstance().getNamespace(), name);
        return block;
    }

    private static Item createItem(Block block) {
        Item item = new ScaffoldingItem(block, (new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
        item.setRegistryName(block.getRegistryName());
        return item;
    }
}
