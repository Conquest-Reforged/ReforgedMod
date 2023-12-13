package com.conquestreforged.core.item.group;

import com.conquestreforged.core.asset.lang.Translations;
import com.conquestreforged.core.init.Context;
import com.conquestreforged.core.item.family.FamilyGroup;
import com.conquestreforged.core.item.group.sort.ItemList;
import com.conquestreforged.core.item.group.sort.Sorter;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ConquestItemGroup extends CreativeModeTab {

    private static final String pathFormat = "/assets/%s/groups/%s.txt";

    private final int index;
    private final Component translationKey;
    private final Sorter<ItemStack> sorter;
    private List<ItemStack> cached = Collections.emptyList();

    public ConquestItemGroup(int index, String label) {
        super(-1, label);
        String namespace = Context.getInstance().getNamespace();
        this.index = index;
        this.translationKey = new TranslatableComponent(Translations.getKey("itemGroup", namespace, label));
        this.sorter = getItemSorter(namespace, label);
        Translations.getInstance().add(translationKey.getString(), Translations.translate(label));
    }

    @Override
    public Component getDisplayName() {
        return translationKey;
    }

    public void invalidate() {
        cached = Collections.emptyList();
    }

    public int getOrderIndex() {
        return index;
    }

    @Override
    public final void fillItemList(NonNullList<ItemStack> items) {
        if (cached.isEmpty()) {
            NonNullList<ItemStack> list = NonNullList.create();
            populate(list);
            sorter.apply(list);
            cached = new ArrayList<>(list);
        }
        items.addAll(cached);
    }

    private Sorter<ItemStack> getItemSorter(String namespace, String label) {
        String path = String.format(pathFormat, namespace, label);
        try (InputStream in = FamilyGroup.class.getResourceAsStream(path)) {
            if (in == null) {
                return Sorter.none();
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
                return ItemList.read(reader);
            }
        } catch (IOException e) {
            // errors if unable to close the resource or reading the stream fails
            e.printStackTrace();
        }
        return Sorter.none();
    }

    public abstract void populate(NonNullList<ItemStack> items);
}
