package com.conquestrefabricated.core.util.cache;

import java.util.*;
import java.util.function.BiConsumer;

public abstract class Cache<K, V> implements Disposable {

    private static final List<Cache<?, ?>> cacheList = new LinkedList<>();

    private Map<K, V> cache = Collections.emptyMap();

    protected Cache() {
        cacheList.add(this);
    }

    public final V get(K k) {
        if (cache.isEmpty()) {
            cache = new HashMap<>();
        }
        return cache.computeIfAbsent(k, this::compute);
    }

    public final void put(K k, V v) {
        if (cache.isEmpty()) {
            cache = new HashMap<>();
        }
        cache.put(k, v);
    }

    public final void forEach(BiConsumer<K, V> consumer) {
        cache.forEach(consumer);
    }

    @Override
    public void dispose() {
        cache.clear();
        cache = Collections.emptyMap();
    }

    public abstract V compute(K k);

    public static void clearAll() {
        Iterator<Cache<?, ?>> iterator = cacheList.iterator();
        while (iterator.hasNext()) {
            iterator.next().dispose();
            iterator.remove();
        }
    }
}
