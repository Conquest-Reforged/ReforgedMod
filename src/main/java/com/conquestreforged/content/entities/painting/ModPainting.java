package com.conquestreforged.content.entities.painting;

import com.conquestreforged.api.painting.Painting;
import com.conquestreforged.api.util.Translateable;
import net.minecraft.util.Identifier;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

/**
 * @author dags <dags@dags.me>
 */
public class ModPainting implements Translateable, Painting {

    private static final Identifier ITEM = new Identifier("conquest", "painting");
    private static final ModPainting UNKNOWN = new ModPainting("unknown");
    private static final Map<String, ModPainting> types = new ConcurrentHashMap<>();

    private final String name;
    private final Identifier texture;

    private ModPainting(String name) {
        this.name = name;
        this.texture = new Identifier("conquest", "textures/entity/painting/" + name + ".png");
    }

    public boolean isPresent() {
        return this != UNKNOWN;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Identifier getItemName() {
        return ITEM;
    }

    @Override
    public Identifier getRegistryName() {
        return texture;
    }

    @Override
    public String getTranslationKey() {
        return getTranslationKey("conquest");
    }

    @Override
    public String getTranslationKey(String parent) {
        return parent + "." + getName();
    }

    public static ModPainting fromId(String id) {
        if (id == null) {
            return UNKNOWN;
        }
        return types.getOrDefault(id, UNKNOWN);
    }

    public static ModPainting fromName(String name) {
        ModPainting type = fromId(name);
        if (type != UNKNOWN) {
            return type;
        }

        System.out.println(name);

        for (ModPainting t : types.values()) {
            if (name.equalsIgnoreCase(t.getName())) {
                return t;
            }
            if (name.equalsIgnoreCase(t.getDisplayName())) {
                return t;
            }
        }

        return UNKNOWN;
    }

    public static ModPainting register(String id) {
        ModPainting painting = new ModPainting(id);
        types.put(id, painting);
        return painting;
    }

    public static Stream<String> getIds() {
        return types.values().stream().map(ModPainting::getName);
    }
}
