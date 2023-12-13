package com.conquestrefabricated.client.gui;

import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import org.jetbrains.annotations.Nullable;


public abstract class AbstractContainer extends ScreenHandler {

    protected AbstractContainer(@Nullable ScreenHandlerType<?> type, int id) {
        super(type, id);
    }

    @Override
    public Slot addSlot(Slot slot) {
        return super.addSlot(slot);
    }
}
