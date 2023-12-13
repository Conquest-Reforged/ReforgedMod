package com.conquestreforged.core.item.family;

import com.conquestreforged.core.block.factory.TypeList;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;

import java.util.function.BiFunction;

public interface FamilyFactory<T> {

    Family<T> create(ResourceLocation name, ItemGroup group, TypeList types);

    static <T> FamilyFactory<T> of(BiFunction<ItemGroup, TypeList, Family<T>> func) {
        return (n, g, t) -> func.apply(g, t);
    }
}
