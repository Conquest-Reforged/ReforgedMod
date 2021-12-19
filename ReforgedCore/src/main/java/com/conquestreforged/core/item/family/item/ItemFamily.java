package com.conquestreforged.core.item.family.item;

import com.conquestreforged.core.item.family.Family;
import com.conquestreforged.core.util.OptimizedList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.core.NonNullList;

public class ItemFamily extends Family<Item> {

    public static final ItemFamily EMPTY = new ItemFamily(CreativeModeTab.TAB_SEARCH);

    public ItemFamily(CreativeModeTab group) {
        super(group, new OptimizedList<>());
    }

    @Override
    protected Item emptyValue() {
        return Items.AIR;
    }

    @Override
    protected void addItem(CreativeModeTab group, NonNullList<ItemStack> list, Item item) {
        item.fillItemCategory(item.getItemCategory(), list);
    }

    @Override
    public boolean isAbsent() {
        return this == EMPTY;
    }
}
