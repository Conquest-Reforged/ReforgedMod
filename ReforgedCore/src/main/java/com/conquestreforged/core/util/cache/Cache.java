package com.conquestreforged.core.util.cache;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
