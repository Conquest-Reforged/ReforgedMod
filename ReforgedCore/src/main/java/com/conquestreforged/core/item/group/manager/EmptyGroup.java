package com.conquestreforged.core.item.group.manager;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class EmptyGroup extends CreativeModeTab {

    EmptyGroup() {
        super("empty");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(Items.AIR);
    }
}
