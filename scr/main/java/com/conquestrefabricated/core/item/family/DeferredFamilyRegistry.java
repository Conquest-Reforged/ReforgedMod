package com.conquestrefabricated.core.item.family;

import com.conquestrefabricated.core.block.factory.TypeList;
import com.conquestrefabricated.core.util.cache.Cache;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;

public class DeferredFamilyRegistry<T extends ItemConvertible> extends Cache<Identifier, DeferredFamily<T>> implements FamilyFactory<T> {

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
    public DeferredFamily<T> compute(Identifier name) {
        return new DeferredFamily<T>(name, empty, registry);
    }

    @Override
    public Family<T> create(Identifier name, ItemGroup group, TypeList types) {
        if (name == null) {
            return none;
        }
        return get(name);
    }

    public void registerAll() {
        forEach((name, family) -> family.register());
    }
}
