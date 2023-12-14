package com.conquestreforged.core.block.factory;

import com.conquestreforged.core.util.OptimizedList;
import com.conquestreforged.core.util.cache.Cache;
import net.minecraft.block.AirBlock;
import net.minecraft.block.Block;

import java.util.*;

public class TypeList implements Iterable<Class<? extends Block>>, Comparator<Block> {

    public static final TypeList EMPTY = new TypeList(Collections.emptyList());
    private static final Cache<TypeKey, TypeList> cache = new TypeListCache();

    private final List<Class<? extends Block>> types;

    private TypeList(List<Class<? extends Block>> types) {
        this.types = types;
    }

    public boolean isEmpty() {
        return types.isEmpty();
    }

    public Class<? extends Block> first() {
        if (types.size() > 0) {
            return types.get(0);
        }
        return AirBlock.class;
    }

    public static TypeList of(Collection<Class<? extends Block>> types) {
        return new TypeList(new ArrayList<>(types));
    }

    @SafeVarargs
    public static TypeList of(Class<? extends Block>... types) {
        if (types.length == 0) {
            throw new RuntimeException("No Types provided!");
        }
        return cache.get(new TypeKey(types));
    }

    @Override
    public Iterator<Class<? extends Block>> iterator() {
        return types.iterator();
    }

    @Override
    public int compare(Block b1, Block b2) {
        return getIndex(b1) - getIndex(b2);
    }

    private int getIndex(Object o) {
        int max = -1;
        for (int i = 0; i < types.size(); i++) {
            Class<?> type = types.get(i);
            if (type.isInstance(o)) {
                max = Math.max(max, i);
            }
        }
        return max == -1 ? types.size() : max;
    }

    private static class TypeListCache extends Cache<TypeKey, TypeList> {

        @Override
        public TypeList compute(TypeKey typeKey) {
            OptimizedList<Class<? extends Block>> list = OptimizedList.of(typeKey.types);
            list.trim();
            return new TypeList(list);
        }
    }

    private static class TypeKey {

        private final Class<? extends Block>[] types;

        private TypeKey(Class<? extends Block>[] types) {
            this.types = types;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TypeKey typeKey = (TypeKey) o;
            return Arrays.equals(types, typeKey.types);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(types);
        }
    }
}
