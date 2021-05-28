package com.conquestreforged.core.item.family.block;

import com.conquestreforged.core.block.factory.TypeList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class VariantFamily extends BlockFamily {

    private static final VariantFamily EMPTY = new VariantFamily();

    private VariantFamily() {
        super(ItemGroup.TAB_SEARCH, TypeList.EMPTY);
    }

    public VariantFamily(ItemGroup group, TypeList type) {
        super(group, type);
    }

    @Override
    public void addRootItem(ItemGroup group, NonNullList<ItemStack> list) {
        if (group == ItemGroup.TAB_SEARCH || group == getGroup()) {
            list.add(new ItemStack(getRoot()));
        }
    }

    @Override
    public boolean isAbsent() {
        return this == EMPTY;
    }
}
