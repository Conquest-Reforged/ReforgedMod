package com.conquestreforged.core.item.family;

import com.conquestreforged.core.block.factory.TypeList;
import com.conquestreforged.core.util.cache.Cache;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class DeferredFamilyRegistry<T extends IForgeRegistryEntry<?>> extends Cache<ResourceLocation, DeferredFamily<T>> implements FamilyFactory<T> {

    public static final DeferredFamilyRegistry<Block> BLOCKS = new DeferredFamilyRegistry<>(Blocks.AIR, FamilyRegistry.BLOCKS);

    private final T empty;
    private final DeferredFamily<T> none;
    private final FamilyRegistry<T> registry;

    private DeferredFamilyRegistry(T empty, FamilyRegistry<T> registry) {
        this.empty = empty;
        this.registry = registry;
        this.none = new DeferredFamily<>(null, empty, registry);
    }

    @Override
    public DeferredFamily<T> compute(ResourceLocation name) {
        return new DeferredFamily<T>(name, empty, registry);
    }

    @Override
    public Family<T> create(ResourceLocation name, ItemGroup group, TypeList types) {
        if (name == null) {
            return none;
        }
        return get(name);
    }

    public void registerAll() {
        forEach((name, family) -> family.register());
    }
}
