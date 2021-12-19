package com.conquestreforged.core.item.group;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.SetTag;
import net.minecraft.core.NonNullList;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class TaggedGroup<T extends TaggedGroup> extends ConquestItemGroup {

    private final List<SetTag<Block>> blocks = new LinkedList<>();
    private final List<SetTag<Item>> items = new LinkedList<>();

    public TaggedGroup(int index, String label) {
        super(index, label);
    }

    public abstract T self();

    @SafeVarargs
    public final T blocks(SetTag<Block>... blocks) {
        Collections.addAll(this.blocks, blocks);
        return self();
    }

    @SafeVarargs
    public final T items(SetTag<Item>... items) {
        Collections.addAll(this.items, items);
        return self();
    }

    public void addTaggedBlocks(NonNullList<ItemStack> items) {
        for (SetTag<Block> tag : this.blocks) {
            tag.getValues().forEach(block -> block.fillItemCategory(this, items));
        }
    }

    public void addTaggedItems(NonNullList<ItemStack> items) {
        for (SetTag<Item> tag : this.items) {
            tag.getValues().forEach(item -> item.fillItemCategory(this, items));
        }
    }
}
