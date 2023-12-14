package com.conquestreforged.core.item.family;

import com.conquestreforged.core.block.factory.TypeList;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;

import java.util.function.BiFunction;

public interface FamilyFactory<T> {

    Family<T> create(Identifier name, ItemGroup group, TypeList types);

    static <T> FamilyFactory<T> of(BiFunction<ItemGroup, TypeList, Family<T>> func) {
        return (n, g, t) -> func.apply(g, t);
    }
}
