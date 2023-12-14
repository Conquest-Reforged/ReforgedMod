package com.conquestreforged.core.item.family;

import com.conquestreforged.core.util.OptimizedList;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;

public class DeferredFamily<T extends ItemConvertible> extends Family<T> {

    private final T empty;
    private final Identifier name;
    private final FamilyRegistry<T> registry;

    DeferredFamily(Identifier name, T empty, FamilyRegistry<T> registry) {
        super(ItemGroup.SEARCH, new OptimizedList<>());
        this.name = name;
        this.empty = empty;
        this.registry = registry;
    }

    @Override
    protected T emptyValue() {
        return empty;
    }

    @Override
    protected void addItem(ItemGroup group, DefaultedList<ItemStack> list, T item) {

    }

    @Override
    public boolean isAbsent() {
        return true;
    }

    public void register() {
        if (name != null) {
            Family<T> family = registry.getFamily(name);
            for (T block : getMembers()) {
                family.add(block);
                registry.register(block, family);
            }
        }
    }
}
