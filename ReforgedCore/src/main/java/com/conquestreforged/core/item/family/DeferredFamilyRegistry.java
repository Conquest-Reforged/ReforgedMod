package com.conquestreforged.core.item.family;

import com.conquestreforged.core.block.factory.TypeList;
import com.conquestreforged.core.util.cache.Cache;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.resources.ResourceLocation;
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
    public Family<T> create(ResourceLocation name, CreativeModeTab group, TypeList types) {
        if (name == null) {
            return none;
        }
        return get(name);
    }

    public void registerAll() {
        forEach((name, family) -> family.register());
    }
}
