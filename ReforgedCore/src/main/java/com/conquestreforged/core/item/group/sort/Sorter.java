package com.conquestreforged.core.item.group.sort;

import net.minecraft.core.NonNullList;

public interface Sorter<T> {

    Sorter NONE = l -> {};

    void apply(NonNullList<T> list);

    @SuppressWarnings("unchecked")
    static <T> Sorter<T> none() {
        return (Sorter<T>) NONE;
    }
}
