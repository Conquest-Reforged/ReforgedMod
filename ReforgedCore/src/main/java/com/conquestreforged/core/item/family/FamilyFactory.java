package com.conquestreforged.core.item.family;

import com.conquestreforged.core.block.factory.TypeList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.resources.ResourceLocation;

import java.util.function.BiFunction;

public interface FamilyFactory<T> {

    Family<T> create(ResourceLocation name, CreativeModeTab group, TypeList types);

    static <T> FamilyFactory<T> of(BiFunction<CreativeModeTab, TypeList, Family<T>> func) {
        return (n, g, t) -> func.apply(g, t);
    }
}
