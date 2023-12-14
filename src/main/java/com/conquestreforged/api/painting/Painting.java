package com.conquestreforged.api.painting;

import com.conquestreforged.api.painting.art.Art;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public interface Painting {

    String getName();

    String getTranslationKey();

    Identifier getRegistryName();

    default Identifier getItemName() {
        return getRegistryName();
    }

    default ItemStack createStack(Art art) {
        return createStack(art, 1);
    }

    default ItemStack createStack(Art art, int count) {
        Item item = Registry.ITEM.get(getItemName());

        NbtCompound painting = new NbtCompound();
        painting.putString(Art.TYPE_TAG, getName());
        painting.putString(Art.ART_TAG, art.getName());

        NbtCompound data = new NbtCompound();
        data.put(Art.DATA_TAG, painting);

        ItemStack stack = new ItemStack(item, count);
        stack.setNbt(data);
        return stack;
    }
}
