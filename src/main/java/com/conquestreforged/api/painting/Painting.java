package com.conquestreforged.api.painting;

import com.conquestreforged.api.painting.art.Art;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;


public interface Painting {

    String getName();

    String getTranslationKey();

    ResourceLocation getRegistryName();

    default ResourceLocation getItemName() {
        return getRegistryName();
    }

    default ItemStack createStack(Art art) {
        return createStack(art, 1);
    }

    default ItemStack createStack(Art art, int count) {
        Item item = BuiltInRegistries.ITEM.get(getItemName());

        CompoundTag painting = new CompoundTag();
        painting.putString(Art.TYPE_TAG, getName());
        painting.putString(Art.ART_TAG, art.getName());

        CompoundTag data = new CompoundTag();
        data.put(Art.DATA_TAG, painting);

        ItemStack stack = new ItemStack(item, count);
        stack.setTag(data);
        return stack;
    }
}
