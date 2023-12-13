package com.conquestrefabricated.core.item.family;

import com.conquestrefabricated.core.util.OptimizedList;
import com.conquestrefabricated.core.util.OptionalValue;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

import java.util.*;

public abstract class Family<T> implements OptionalValue, Comparator<T> {

    private final List<T> members;
    private final ItemGroup group;
    private final Comparator<T> order;

    private T root = null;

    public Family(ItemGroup group, List<T> members) {
        this(group, (t1, t2) -> 0, members);
    }

    public Family(ItemGroup group, Comparator<T> order, List<T> members) {
        this.group = group;
        this.order = order;
        this.members = members;
    }

    protected abstract T emptyValue();

    protected abstract void addItem(ItemGroup group, DefaultedList<ItemStack> list, T item);

    public void trim() {
        if (members instanceof ArrayList) {
            ((ArrayList<T>) members).trimToSize();
            return;
        }
        if (members instanceof OptimizedList) {
            ((OptimizedList<T>) members).trim();
        }
    }

    public ItemGroup getGroup() {
        return group;
    }

    public T getRoot() {
        if (members.isEmpty()) {
            return emptyValue();
        }
        return members.get(0);
    }

    public Optional<T> getMember(int index) {
        if (index < members.size()) {
            return Optional.ofNullable(members.get(index));
        }
        return Optional.empty();
    }

    public Optional<T> getMember(Class<? extends T> type) {
        return members.stream().filter(t -> t.getClass() == type).findFirst();
    }

    public List<T> getMembers() {
        return Collections.unmodifiableList(members);
    }

    public int size() {
        return members.size();
    }

    public int indexOf(T member) {
        return members.indexOf(member);
    }

    public Family<T> setRoot(T root) {
        this.root = root;
        if (!members.contains(root)) {
            members.add(root);
        }
        members.sort(this);
        return this;
    }

    public Family<T> add(T member) {
        if (!members.contains(member)) {
            members.add(member);
            members.sort(this);
        }
        return this;
    }

    public Family<T> add(T... members) {
        for (T t : members) {
            add(t);
        }
        return this;
    }

    public void addAllItems(ItemGroup group, DefaultedList<ItemStack> list) {
        addAllItems(group, list, TypeFilter.ANY);
    }

    public void addAllItems(ItemGroup group, DefaultedList<ItemStack> list, TypeFilter filter) {
        if (group == ItemGroup.SEARCH || group == this.group) {
            for (T t : members) {
                if (filter.test(t)) {
                    addItem(group, list, t);
                }
            }
        }
    }

    public void addRootItem(ItemGroup group, DefaultedList<ItemStack> list) {
        if (group == ItemGroup.SEARCH || group == this.group) {
            addItem(group, list, getRoot());
        }
    }

    @Override
    public final int compare(T t1, T t2) {
        if (root != null) {
            if (t1 == root && t2 != root) {
                return -1;
            }
            if (t2 == root && t1 != root) {
                return 1;
            }
        }
        if (order != null) {
            return order.compare(t1, t2);
        }
        return 0;
    }

    public interface Filler {

        void fill(Family family, ItemGroup group, DefaultedList<ItemStack> items);
    }
}
