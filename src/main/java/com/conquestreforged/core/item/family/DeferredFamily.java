package com.conquestreforged.core.item.family;

import com.conquestreforged.core.util.OptimizedList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class DeferredFamily<T extends IForgeRegistryEntry<?>> extends Family<T> {

    private final T empty;
    private final ResourceLocation name;
    private final FamilyRegistry<T> registry;

    DeferredFamily(ResourceLocation name, T empty, FamilyRegistry<T> registry) {
        super(CreativeModeTab.TAB_SEARCH, new OptimizedList<>());
        this.name = name;
        this.empty = empty;
        this.registry = registry;
    }

    @Override
    protected T emptyValue() {
        return empty;
    }

    @Override
    protected void addItem(CreativeModeTab group, NonNullList<ItemStack> list, T item) {

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
