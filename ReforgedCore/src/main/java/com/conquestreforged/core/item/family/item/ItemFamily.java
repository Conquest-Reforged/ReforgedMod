package com.conquestreforged.core.item.family.item;

import com.conquestreforged.core.item.family.Family;
import com.conquestreforged.core.util.OptimizedList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.NonNullList;

public class ItemFamily extends Family<Item> {

    public static final ItemFamily EMPTY = new ItemFamily(ItemGroup.SEARCH);

    public ItemFamily(ItemGroup group) {
        super(group, new OptimizedList<>());
    }

    @Override
    protected Item emptyValue() {
        return Items.AIR;
    }

    @Override
    protected void addItem(ItemGroup group, NonNullList<ItemStack> list, Item item) {
        item.fillItemGroup(item.getGroup(), list);
    }

    @Override
    public boolean isAbsent() {
        return this == EMPTY;
    }
}
