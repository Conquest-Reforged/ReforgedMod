package com.conquestrefabricated.core.item.group;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.TagKey;
import net.minecraft.util.collection.DefaultedList;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class TaggedGroup<T extends TaggedGroup> extends ConquestItemGroup {

    private final List<TagKey<Block>> blocks = new LinkedList<>();
    private final List<TagKey<Item>> items = new LinkedList<>();

    public TaggedGroup(int index, String label) {
        super(index, label);
    }

    public abstract T self();

    @SafeVarargs
    public final T blocks(TagKey<Block>... blocks) {
        Collections.addAll(this.blocks, blocks);
        return self();
    }

    @SafeVarargs
    public final T items(TagKey<Item>... items) {
        Collections.addAll(this.items, items);
        return self();
    }

    public void addTaggedBlocks(DefaultedList<ItemStack> items) {
        for (TagKey<Block> tag : this.blocks) {
            //tag.values().forEach(block -> block.appendStacks(this, items));
        }
    }

    public void addTaggedItems(DefaultedList<ItemStack> items) {
        for (TagKey<Item> tag : this.items) {
            //tag.values().forEach(item -> item.appendStacks(this, items));
        }
    }
}
