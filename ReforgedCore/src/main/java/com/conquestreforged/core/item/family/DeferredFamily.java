package com.conquestreforged.core.item.family;

import com.conquestreforged.core.util.OptimizedList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class DeferredFamily<T extends IForgeRegistryEntry<?>> extends Family<T> {

    private final T empty;
    private final ResourceLocation name;
    private final FamilyRegistry<T> registry;

    DeferredFamily(ResourceLocation name, T empty, FamilyRegistry<T> registry) {
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
    protected void addItem(ItemGroup group, NonNullList<ItemStack> list, T item) {

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
