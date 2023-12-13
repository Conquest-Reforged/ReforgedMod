package com.conquestreforged.client.gui.palette.texture;

import com.conquestreforged.core.util.OptionalValue;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class TextureGroup implements OptionalValue {

    protected static final TextureGroup NONE = new TextureGroup("none");

    private final String name;
    private final LinkedList<ItemStack> itemStacks = new LinkedList<>();

    private Comparator<Item> order = TextureGroup.BY_NAME;

    public TextureGroup(String name) {
        this.name = name;
    }

    @Override
    public boolean isAbsent() {
        return this == NONE;
    }

    public String getName() {
        return name;
    }

    public void addTo(NonNullList<ItemStack> list) {
        for (ItemStack stack : itemStacks) {
            list.add(stack.copy());
        }
    }

    public ItemStack getHead() {
        if (itemStacks.isEmpty()) {
            return ItemStack.EMPTY;
        }
        return itemStacks.getFirst().copy();
    }

    public List<ItemStack> getItems() {
        return itemStacks;
    }

    public NonNullList<ItemStack> getItemsCopy() {
        NonNullList<ItemStack> list = NonNullList.create();
        addTo(list);
        return list;
    }

    protected void sort(Comparator<Item> order) {
        this.order = order;
        this.itemStacks.sort(wrap(order));
    }

    protected void add(Item item) {
        for (int i = 0; i < itemStacks.size(); i++) {
            ItemStack current = itemStacks.get(i);
            if (order.compare(item, current.getItem()) < 0) {
                // insert at pos i pushing everything behind to the right
                itemStacks.add(i, item.getDefaultInstance());
                return;
            }
        }
        // add to end
        itemStacks.add(item.getDefaultInstance());
    }

    private static final Comparator<Item> BY_NAME = (i1, i2) -> {
        if (i1.getRegistryName() == null || i2.getRegistryName() == null) {
            return 0;
        }
        return i1.getRegistryName().compareTo(i2.getRegistryName());
    };

    private static Comparator<ItemStack> wrap(Comparator<Item> comparator) {
        return (s1, s2) -> comparator.compare(s1.getItem(), s2.getItem());
    }
}
