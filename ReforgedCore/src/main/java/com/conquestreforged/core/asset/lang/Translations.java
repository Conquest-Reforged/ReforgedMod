package com.conquestreforged.core.asset.lang;

import com.conquestreforged.core.util.Translatable;
import com.conquestreforged.core.util.cache.Cache;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class Translations extends Cache<String, String> {

    private static final Translations instance = new Translations();

    private Translations() {

    }

    public void add(Translatable translatable) {
        put(translatable.getTranslationKey(), translatable.getDisplayName());
    }

    public void add(String type, IForgeRegistryEntry<?> entry, String translation) {
        if (entry.getRegistryName() != null) {
            String key = getKey(type, entry.getRegistryName());
            put(key, translation);
        }
    }

    public void add(String type, ResourceLocation name, String translation) {
        String key = getKey(type, name);
        put(key, translation);
    }

    public void add(String key, String translation) {
        put(key, translation);
    }

    @Override
    public String compute(String s) {
        return "";
    }

    public static Translations getInstance() {
        return instance;
    }

    public static String getKey(String type, ResourceLocation name) {
        return getKey(type, name.getNamespace(), name.getPath());
    }

    public static String getKey(String type, String namespace, String path) {
        return type + "." + namespace + "." + path;
    }

    public static String translate(String in) {
        char[] out = new char[in.length()];
        boolean first = true;
        for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);
            if (first) {
                first = false;
                c = Character.toUpperCase(c);
            } else if (c == '_') {
                c = ' ';
                first = true;
            }
            out[i] = c;
        }
        return new String(out);
    }
}
