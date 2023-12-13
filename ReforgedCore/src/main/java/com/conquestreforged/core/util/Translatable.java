package com.conquestreforged.core.util;

import net.minecraft.client.resources.I18n;

public interface Translatable {

    String getName();

    String getTranslationKey();

    String getTranslationKey(String parent);

    default String getDisplayName() {
        String lookup = getTranslationKey();
        String translation = I18n.format(lookup);
        if (translation.equals(lookup)) {
            return getName();
        }
        return translation;
    }

    default String getDisplayName(String parent) {
        String lookup = getTranslationKey(parent);
        String translation = I18n.format(lookup);
        if (translation.equals(lookup)) {
            return getName();
        }
        return translation;
    }
}
