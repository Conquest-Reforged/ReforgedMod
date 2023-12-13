package com.conquestreforged.core.item.family.block;

import com.conquestreforged.core.block.factory.TypeList;
import com.conquestreforged.core.item.family.Family;
import com.conquestreforged.core.util.OptimizedList;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

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
    protected void addItem(ItemGroup group, NonNullList<ItemStack> list, Block block) {
        block.fillItemGroup(group, list);
    }

    @Override
    public boolean isAbsent() {
        return this == EMPTY;
    }

    private static final Comparator<Block> BY_NAME = (b1, b2) -> {
        String name1 = b1.getRegistryName().getPath();
        String name2 = b2.getRegistryName().getPath();
        return name1.compareTo(name2);
    };
}
