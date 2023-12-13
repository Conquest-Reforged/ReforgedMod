package com.conquestrefabricated.client.gui.palette.texture;

import com.conquestrefabricated.core.util.OptionalValue;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;

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

    public void addTo(DefaultedList<ItemStack> list) {
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

    public DefaultedList<ItemStack> getItemsCopy() {
        DefaultedList<ItemStack> list = DefaultedList.of();
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
                itemStacks.add(i, item.getDefaultStack());
                return;
            }
        }
        // add to end
        itemStacks.add(item.getDefaultStack());
    }

    private static final Comparator<Item> BY_NAME = (i1, i2) -> {
        if (Registry.ITEM.getId(i1) == null || Registry.ITEM.getId(i2) == null) {
            return 0;
        }
        return Registry.ITEM.getId(i1).compareTo(Registry.ITEM.getId(i2));
    };

    private static Comparator<ItemStack> wrap(Comparator<Item> comparator) {
        return (s1, s2) -> comparator.compare(s1.getItem(), s2.getItem());
    }
}
