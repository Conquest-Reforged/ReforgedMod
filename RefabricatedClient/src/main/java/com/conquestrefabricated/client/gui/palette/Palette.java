package com.conquestrefabricated.client.gui.palette;

import com.conquestrefabricated.core.init.dev.Environment;
import com.conquestrefabricated.core.item.family.Family;
import com.conquestrefabricated.core.item.family.FamilyRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Palette {

    public static Inventory createPalette(ItemStack first, List<ItemStack> family) {
        List<ItemStack> result = new ArrayList<>(family.size());
        result.add(copyOne(first));
        for (ItemStack stack : family) {
            if (stack.isItemEqualIgnoreDamage(first)) {
                if (ItemStack.areNbtEqual(first, stack)) {
                    continue;
                }
            }
            result.add(copyOne(stack));
        }
        return new SimpleInventory(result.toArray(new ItemStack[0]));
    }

    public static Optional<Inventory> getPalette(ItemStack stack) {
        return getPalette(stack, stack.getItem());
    }

    private static Optional<Inventory> getPalette(ItemStack stack, Item item) {
        if (item instanceof BlockItem) {
            return getPalette(stack, ((BlockItem) item).getBlock());
        }
        return Optional.empty();
    }

    private static Optional<Inventory> getPalette(ItemStack stack, Block block) {
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

        DefaultedList<ItemStack> items = DefaultedList.of();
        family.addAllItems(family.getGroup(), items);

        return Optional.of(createPalette(stack, items));
    }

    private static List<ItemStack> createDebugPalette(int min, int max) {
        Random random = new Random(System.currentTimeMillis());
        int size = min + random.nextInt((max - min));

        DefaultedList<ItemStack> items = DefaultedList.of();
        List<Block> blocks = new ArrayList<>(Registry.BLOCK.stream().toList());
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
