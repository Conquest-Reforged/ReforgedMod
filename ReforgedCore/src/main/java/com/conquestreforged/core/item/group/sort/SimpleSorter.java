package com.conquestreforged.core.item.group.sort;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import java.util.Comparator;

public class SimpleSorter implements Sorter<ItemStack> {

    private final Comparator<ItemStack> comparator;

    public SimpleSorter(Comparator<ItemStack> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void apply(NonNullList<ItemStack> list) {
        list.sort(comparator);
    }
}
