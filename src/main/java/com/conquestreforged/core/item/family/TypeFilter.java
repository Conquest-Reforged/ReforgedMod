package com.conquestreforged.core.item.family;

import com.google.common.collect.ImmutableSet;

import java.util.*;
import java.util.function.Predicate;

public interface TypeFilter extends Predicate<Object> {

    TypeFilter ANY = o -> true;
    TypeFilter NONE = o -> false;

    default TypeFilter invert() {
        TypeFilter self = this;
        return o -> !self.test(o);
    }

    @SafeVarargs
    static <T> TypeFilter of(Class<? extends T>... types) {
        Set<Class<? extends T>> set = new HashSet<>();
        Collections.addAll(set, types);
        return of(Arrays.asList(types));
    }

    static <T> TypeFilter of(Collection<Class<? extends T>> collection) {
        Set<Class<?>> set = ImmutableSet.copyOf(collection);
        return o -> o != null && set.contains(o.getClass());
    }
}
