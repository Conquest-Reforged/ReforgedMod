package com.conquestreforged.core.item.family;

import com.conquestreforged.core.item.family.block.BlockFamily;
import com.conquestreforged.core.item.family.item.ItemFamily;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class FamilyRegistry<T extends IForgeRegistryEntry<?>> {

    public static final FamilyRegistry<Block> BLOCKS = new FamilyRegistry<>(BlockFamily.EMPTY);
    public static final FamilyRegistry<Item> ITEMS = new FamilyRegistry<>(ItemFamily.EMPTY);

    private final Family<T> empty;
    private final Map<ResourceLocation, Family<T>> families = new HashMap<>();

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
        families.put(member.getRegistryName(), family);
    }

    public void registerToFamily(ResourceLocation parent, T child) {
        Family<T> family = getFamily(parent);
        if (family.isPresent()) {
            family.add(child);
        }
    }

    public Family<T> getFamily(T member) {
        return getFamily(member.getRegistryName());
    }

    public Family<T> getFamily(ResourceLocation name) {
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
