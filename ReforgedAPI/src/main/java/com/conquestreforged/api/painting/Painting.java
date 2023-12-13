package com.conquestreforged.api.painting;

import com.conquestreforged.api.painting.art.Art;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

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
        Item item = ForgeRegistries.ITEMS.getValue(getItemName());

        CompoundNBT painting = new CompoundNBT();
        painting.putString(Art.TYPE_TAG, getName());
        painting.putString(Art.ART_TAG, art.getName());

        CompoundNBT data = new CompoundNBT();
        data.put(Art.DATA_TAG, painting);

        ItemStack stack = new ItemStack(item, count);
        stack.setTag(data);
        return stack;
    }
}
