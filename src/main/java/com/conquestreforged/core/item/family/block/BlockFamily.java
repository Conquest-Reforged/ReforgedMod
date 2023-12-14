package com.conquestreforged.core.item.family.block;

import com.conquestreforged.core.block.factory.TypeList;
import com.conquestreforged.core.item.family.Family;
import com.conquestreforged.core.util.OptimizedList;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;

import java.util.Collections;
import java.util.Comparator;

public class BlockFamily extends Family<Block> {

    public static final BlockFamily EMPTY = new BlockFamily();

    private BlockFamily() {
        super(ItemGroup.SEARCH, BlockFamily.BY_NAME, Collections.emptyList());
    }

    public BlockFamily(ItemGroup group, TypeList order) {
        super(group, order, new OptimizedList<>());
    }

    @Override
    protected Block emptyValue() {
        return Blocks.AIR;
    }

    @Override
    protected void addItem(ItemGroup group, DefaultedList<ItemStack> list, Block block) {
        block.appendStacks(group, list);
    }

    @Override
    public boolean isAbsent() {
        return this == EMPTY;
    }

    private static final Comparator<Block> BY_NAME = (b1, b2) -> {
        String name1 = Registry.ITEM.getId(b1.asItem()).getPath();
        String name2 = Registry.ITEM.getId(b2.asItem()).getPath();
        return name1.compareTo(name2);
    };
}
