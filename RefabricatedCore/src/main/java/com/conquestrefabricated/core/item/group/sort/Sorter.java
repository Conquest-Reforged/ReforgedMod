package com.conquestrefabricated.core.item.group.sort;

import net.minecraft.util.collection.DefaultedList;

public interface Sorter<T> {

    Sorter NONE = l -> {};

    void apply(DefaultedList<T> list);

    @SuppressWarnings("unchecked")
    static <T> Sorter<T> none() {
        return (Sorter<T>) NONE;
    }
}
