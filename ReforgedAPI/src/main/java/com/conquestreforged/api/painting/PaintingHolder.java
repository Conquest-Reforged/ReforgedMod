package com.conquestreforged.api.painting;

import com.conquestreforged.api.painting.art.Art;
import net.minecraft.item.ItemStack;

public interface PaintingHolder {

    Art<?> getArt(ItemStack stack);

    Painting getType(ItemStack stack);

    static String getArtData(ItemStack stack) {
        if (stack.getTag() == null) {
            return null;
        }
        return stack.getTag().getCompound(Art.DATA_TAG).getString(Art.ART_TAG);
    }

    static String getTypeData(ItemStack stack) {
        if (stack.getTag() == null) {
            return null;
        }
        return stack.getTag().getCompound(Art.DATA_TAG).getString(Art.TYPE_TAG);
    }
}
