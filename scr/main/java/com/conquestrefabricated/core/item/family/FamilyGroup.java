package com.conquestrefabricated.core.item.family;

import com.conquestrefabricated.core.item.group.TaggedGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FamilyGroup extends TaggedGroup<FamilyGroup> {

    public static final List<FamilyGroup> FAMILY_GROUPS = new LinkedList<>();
    private static final Family.Filler ALL_ITEMS = Family::addAllItems;
    private static final Family.Filler ROOT_ITEMS = Family::addRootItem;
    private static Family.Filler filler = Family::addAllItems;

    private final Supplier<ItemStack> icon;

    public FamilyGroup(int order, String label, Supplier<ItemStack> icon) {
        super(order, label);
        this.icon = icon;
        FAMILY_GROUPS.add(this);
    }

    @Override
    public FamilyGroup self() {
        return this;
    }

    @Override
    public ItemStack createIcon() {
        return icon.get();
    }

    @Override
    public void populate(DefaultedList<ItemStack> items) {
        FamilyRegistry.BLOCKS.values().forEach(family -> filler.fill(family, this, items));
        addTaggedBlocks(items);

        FamilyRegistry.ITEMS.values().forEach(family -> filler.fill(family, this, items));
        addTaggedItems(items);
    }

    public static void setAddAllItems() {
        if (filler != ALL_ITEMS) {
            filler = ALL_ITEMS;
            FAMILY_GROUPS.forEach(FamilyGroup::invalidate);
        }
    }

    public static void setAddRootItems() {
        if (filler != ROOT_ITEMS) {
            filler = ROOT_ITEMS;
            FAMILY_GROUPS.forEach(FamilyGroup::invalidate);
        }
    }

    public static Stream<FamilyGroup> stream() {
        return FAMILY_GROUPS.stream().sorted(Comparator.comparing(FamilyGroup::getOrderIndex));
    }
}
