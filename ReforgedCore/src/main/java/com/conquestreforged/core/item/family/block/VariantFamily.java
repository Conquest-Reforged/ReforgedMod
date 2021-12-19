package com.conquestreforged.core.item.family.block;

import com.conquestreforged.core.block.factory.TypeList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.NonNullList;

public class VariantFamily extends BlockFamily {

    private static final VariantFamily EMPTY = new VariantFamily();

    private VariantFamily() {
        super(CreativeModeTab.TAB_SEARCH, TypeList.EMPTY);
    }

    public VariantFamily(CreativeModeTab group, TypeList type) {
        super(group, type);
    }

    @Override
    public void addRootItem(CreativeModeTab group, NonNullList<ItemStack> list) {
        if (group == CreativeModeTab.TAB_SEARCH || group == getGroup()) {
            list.add(new ItemStack(getRoot()));
        }
    }

    @Override
    public boolean isAbsent() {
        return this == EMPTY;
    }
}
