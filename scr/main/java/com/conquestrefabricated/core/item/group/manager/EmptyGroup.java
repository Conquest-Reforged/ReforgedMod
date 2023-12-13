package com.conquestrefabricated.core.item.group.manager;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;


public class EmptyGroup extends ItemGroup {

    EmptyGroup() {
        super(ItemGroup.GROUPS.length-1, "empty");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Items.AIR);
    }
}
