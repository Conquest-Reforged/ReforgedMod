package com.conquestreforged.core.item.family.block;

import com.conquestreforged.core.block.factory.TypeList;
import com.conquestreforged.core.item.family.Family;
import com.conquestreforged.core.util.OptimizedList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.NonNullList;

import java.util.Collections;
import java.util.Comparator;

public class BlockFamily extends Family<Block> {

    public static final BlockFamily EMPTY = new BlockFamily();

    private BlockFamily() {
        super(CreativeModeTab.TAB_SEARCH, BlockFamily.BY_NAME, Collections.emptyList());
    }

    public BlockFamily(CreativeModeTab group, TypeList order) {
        super(group, order, new OptimizedList<>());
    }

    @Override
    protected Block emptyValue() {
        return Blocks.AIR;
    }

    @Override
    protected void addItem(CreativeModeTab group, NonNullList<ItemStack> list, Block block) {
        block.fillItemCategory(group, list);
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
