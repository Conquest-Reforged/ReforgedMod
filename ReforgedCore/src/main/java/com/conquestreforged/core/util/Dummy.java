package com.conquestreforged.core.util;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class Dummy {

    private static final Supplier<Object> empty = () -> null;
    private static final Supplier<Item> item = () -> null;

    @SuppressWarnings("unchecked")
    public static <T> T dummy() {
        return (T) empty.get();
    }

    public static <T extends Block> T block() {
        return dummy();
    }

    public static <T extends Item> T item() {
        return dummy();
    }
}
