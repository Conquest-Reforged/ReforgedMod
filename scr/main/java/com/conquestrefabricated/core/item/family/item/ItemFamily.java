package com.conquestrefabricated.core.item.family.item;

import com.conquestrefabricated.core.item.family.Family;
import com.conquestrefabricated.core.util.OptimizedList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.collection.DefaultedList;

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
    protected void addItem(ItemGroup group, DefaultedList<ItemStack> list, Item item) {
        item.appendStacks(item.getGroup(), list);
    }

    @Override
    public boolean isAbsent() {
        return this == EMPTY;
    }
}
