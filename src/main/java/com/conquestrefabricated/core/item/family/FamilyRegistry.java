package com.conquestrefabricated.core.item.family;

import com.conquestrefabricated.core.item.family.block.BlockFamily;
import com.conquestrefabricated.core.item.family.item.ItemFamily;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class FamilyRegistry<T extends ItemConvertible> {

    public static final FamilyRegistry<Block> BLOCKS = new FamilyRegistry<>(BlockFamily.EMPTY);
    public static final FamilyRegistry<Item> ITEMS = new FamilyRegistry<>(ItemFamily.EMPTY);

    private final Family<T> empty;
    private final Map<Identifier, Family<T>> families = new HashMap<>();

    public FamilyRegistry(Family<T> empty) {
        this.empty = empty;
    }

    public void register(Family<T> family) {
        for (T member : family.getMembers()) {
            register(member, family);
        }
    }

    public void register(T member, Family<T> family) {
        if (family.isAbsent()) {
            return;
        }
        families.put(Registry.ITEM.getId(member.asItem()), family);
    }

    public void registerToFamily(Identifier parent, T child) {
        Family<T> family = getFamily(parent);
        if (family.isPresent()) {
            family.add(child);
        }
    }

    public Family<T> getFamily(T member) {
        return getFamily(Registry.ITEM.getId(member.asItem()));
    }

    public Family<T> getFamily(Identifier name) {
        return families.getOrDefault(name, empty);
    }

    public Stream<Family<T>> values() {
        return families.values().stream().distinct();
    }

    /**
     * Trims all registered families to size to save on unallocated array slots
     */
    public static void bake() {
        BLOCKS.values().forEach(Family::trim);
        ITEMS.values().forEach(Family::trim);
    }
}
