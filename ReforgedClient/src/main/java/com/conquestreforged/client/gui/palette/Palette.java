package com.conquestreforged.client.gui.palette;

import com.conquestreforged.core.init.dev.Environment;
import com.conquestreforged.core.item.family.Family;
import com.conquestreforged.core.item.family.FamilyRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Palette {

    public static IInventory createPalette(ItemStack first, List<ItemStack> family) {
        List<ItemStack> result = new ArrayList<>(family.size());
        result.add(copyOne(first));
        for (ItemStack stack : family) {
            if (stack.isItemEqual(first)) {
                if (ItemStack.areItemStackTagsEqual(first, stack)) {
                    continue;
                }
            }
            result.add(copyOne(stack));
        }
        return new Inventory(result.toArray(new ItemStack[0]));
    }

    public static Optional<IInventory> getPalette(ItemStack stack) {
        return getPalette(stack, stack.getItem());
    }

    private static Optional<IInventory> getPalette(ItemStack stack, Item item) {
        if (item instanceof BlockItem) {
            return getPalette(stack, ((BlockItem) item).getBlock());
        }
        return Optional.empty();
    }

    private static Optional<IInventory> getPalette(ItemStack stack, Block block) {
        if (block == Blocks.AIR) {
            return Optional.empty();
        }

        Family<Block> family = FamilyRegistry.BLOCKS.getFamily(block);
        if (family.isAbsent()) {
            if (Environment.isProduction()) {
                return Optional.empty();
            }
            return Optional.of(createPalette(stack, createDebugPalette(5, 50)));
        }

        NonNullList<ItemStack> items = NonNullList.create();
        family.addAllItems(family.getGroup(), items);

        return Optional.of(createPalette(stack, items));
    }

    private static List<ItemStack> createDebugPalette(int min, int max) {
        Random random = new Random(System.currentTimeMillis());
        int size = min + random.nextInt((max - min));

        NonNullList<ItemStack> items = NonNullList.create();
        List<Block> blocks = new ArrayList<>(ForgeRegistries.BLOCKS.getValues());
        while (items.size() < size) {
            int index = random.nextInt(blocks.size());
            ItemStack itemStack = new ItemStack(blocks.get(index));
            if (itemStack.isEmpty()) {
                continue;
            }
            items.add(itemStack);
        }

        return items;
    }

    private static ItemStack copyOne(ItemStack stack) {
        stack = stack.copy();
        stack.setCount(1);
        return stack;
    }
}
