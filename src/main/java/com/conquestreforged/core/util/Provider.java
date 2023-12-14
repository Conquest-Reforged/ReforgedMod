package com.conquestreforged.core.util;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * Used to provide references to objects that can be used during initialization
 * with out creating circular dependency issues (ie Block constructors that rely on
 * Items and vice-versa
 */
public class Provider<T extends ItemConvertible> implements ItemConvertible {

    private final String name;
    private final Supplier<T> supplier;
    private final Supplier<T> defaultValue;

    private T value;

    private Provider(String name, Supplier<T> supplier, Supplier<T> defaultValue) {
        this.name = name;
        this.supplier = supplier;
        this.defaultValue = defaultValue;
    }

    public T get() {
        if (value == null) {
            value = supplier.get();
            if (value == null) {
                new NullPointerException("Invalid item: " + name).printStackTrace();
                value = defaultValue.get();
            }
        }
        return value;
    }

    public Stack toStack() {
        return new Stack(this);
    }

    @Override
    public net.minecraft.item.Item asItem() {
        T t = get();
        if (t == null) {
            throw new NullPointerException("Invalid item: " + name);
        }
        return t.asItem();
    }

    public static Block block(String name) {
        return block(new Identifier(name));
    }

    public static Block block(Identifier name) {
        return block("" + name, () -> Registry.BLOCK.get(name));
    }

    public static Block block(String name, Supplier<net.minecraft.block.Block> getter) {
        return new Block(name, getter);
    }

    public static Item item(String name) {
        return item(new Identifier(name));
    }

    public static Item item(Identifier name) {
        return item("" + name, () -> Registry.ITEM.get(name));
    }

    public static Item item(String name, Supplier<net.minecraft.item.Item> getter) {
        return new Item(name, getter);
    }

    public static class Block extends Provider<net.minecraft.block.Block> {

        public Block(String name, Supplier<net.minecraft.block.Block> supplier) {
            super(name, supplier, () -> Blocks.AIR);
        }
    }

    public static class Item extends Provider<net.minecraft.item.Item> {

        public Item(String name, Supplier<net.minecraft.item.Item> supplier) {
            super(name, supplier, () -> Items.AIR);
        }
    }

    public static class Stack implements Supplier<ItemStack> {

        private final ItemConvertible provider;

        public Stack(ItemConvertible provider) {
            this.provider = provider;
        }

        @Override
        public ItemStack get() {
            return new ItemStack(provider.asItem());
        }

        public Optional<ItemStack> getSafely() {
            net.minecraft.item.Item item = provider.asItem();
            if (item == Items.AIR) {
                return Optional.empty();
            }
            return Optional.of(new ItemStack(item));
        }
    }
}
