package com.conquestreforged.client.gui;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;

import javax.annotation.Nullable;

public abstract class AbstractContainer extends AbstractContainerMenu {

    protected AbstractContainer(@Nullable MenuType<?> type, int id) {
        super(type, id);
    }

    @Override
    public Slot addSlot(Slot slot) {
        return super.addSlot(slot);
    }
}
