package com.conquestreforged.core.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;

/**
 * Utilizes Collections.emptyList and Collections.singletonList when contents
 * fit those use-cases, falling back to a standard ArrayList when grown above
 * a size of 1
 */
public class OptimizedList<T> implements List<T> {

    private List<T> backing = Collections.emptyList();

    public void trim() {
        if (backing instanceof ArrayList) {
            ((ArrayList<T>) backing).trimToSize();
        }
    }

    @Override
    public int size() {
        return backing.size();
    }

    @Override
    public boolean isEmpty() {
        return backing.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return backing.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return backing.iterator();
    }

    @Override
    public Object[] toArray() {
        return backing.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return backing.toArray(a);
    }

    @Override
    public boolean add(T t) {
        if (backing.isEmpty()) {
            backing = Collections.singletonList(t);
            return true;
        }
        if (backing.size() == 1) {
            backing = new ArrayList<>(backing);
            backing.add(t);
            return true;
        }
        return backing.add(t);
    }

    @Override
    public boolean remove(Object o) {
        if (backing.isEmpty()) {
            return false;
        }
        if (backing.size() == 1) {
            if (backing.get(0).equals(o)) {
                backing = Collections.emptyList();
                return true;
            }
            return false;
        }
        return backing.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return backing.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return backing.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return backing.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return backing.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (backing.isEmpty()) {
            return false;
        }
        if (backing.size() == 1) {
            if (!c.contains(backing.get(0))) {
                backing = Collections.emptyList();
                return true;
            }
            return false;
        }
        return backing.retainAll(c);
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        if (backing.size() <= 1) {
            return;
        }
        backing.sort(comparator);
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        if (backing.isEmpty()) {
            return;
        }
        if (backing.size() == 1) {
            set(0, operator.apply(backing.get(0)));
            return;
        }
        backing.replaceAll(operator);
    }

    @Override
    public void clear() {
        if (backing.isEmpty()) {
            return;
        }
        if (backing.size() == 1) {
            backing = Collections.emptyList();
            return;
        }
        backing.clear();
    }

    @Override
    public T get(int index) {
        return backing.get(index);
    }

    @Override
    public T set(int index, T element) {
        if (backing.isEmpty()) {
            throw outOfBounds(0, index);
        }
        if (backing.size() == 1) {
            if (index != 0) {
                throw outOfBounds(1, index);
            }
            T previous = backing.get(0);
            backing = Collections.singletonList(element);
            return previous;
        }
        return backing.set(index, element);
    }

    @Override
    public void add(int index, T element) {
        if (backing.isEmpty()) {
            if (index != 0) {
                throw outOfBounds(0, index);
            }
            backing = Collections.singletonList(element);
            return;
        }

        if (backing.size() == 1) {
            if (index < 0 || index > 1) {
                throw outOfBounds(1, index);
            }
            List<T> next = new ArrayList<>();
            next.add(index == 0 ? element : backing.get(0));
            next.add(index == 0 ? backing.get(0) : element);
            backing = next;
            return;
        }

        backing.add(index, element);
    }

    @Override
    public T remove(int index) {
        if (backing.isEmpty()) {
            throw outOfBounds(0, index);
        }
        if (backing.size() == 1) {
            if (index != 0) {
                throw outOfBounds(1, index);
            }
            T previous = backing.get(0);
            backing = Collections.emptyList();
            return previous;
        }
        return backing.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return backing.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return backing.lastIndexOf(o);
    }

    @Override
    public ListIterator<T> listIterator() {
        return backing.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return backing.listIterator(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return backing.subList(fromIndex, toIndex);
    }

    private IndexOutOfBoundsException outOfBounds(int size, int index) {
        return new IndexOutOfBoundsException("Size: " + size + ", Index:" + index);
    }

    @SafeVarargs
    public static <T> OptimizedList<T> of(T... values) {
        OptimizedList<T> list = new OptimizedList<>();
        Collections.addAll(list, values);
        return list;
    }
}
