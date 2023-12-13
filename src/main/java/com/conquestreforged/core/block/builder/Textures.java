package com.conquestreforged.core.block.builder;

import com.conquestreforged.core.asset.template.JsonOverride;
import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Textures implements JsonOverride {

    public static final Textures NONE = new Textures(Collections.emptyMap());

    private final Map<String, String> textures;
    private final String matchAll;

    public Textures(Map<String, String> textures) {
        this.textures = textures;
        this.matchAll = textures.get("*");
    }

    @Override
    public boolean appliesTo(String key, JsonElement value) {
        return key.equals("textures") && value.isJsonObject();
    }

    @Override
    public boolean apply(JsonElement input, JsonWriter output) throws IOException {
        JsonObject object = input.getAsJsonObject();

        output.beginObject();
        for (Map.Entry<String, JsonElement> entry : object.entrySet()) {
            output.name(entry.getKey());

            String texture = textures.getOrDefault(entry.getKey(), matchAll);
            if (texture == null) {
                Streams.write(entry.getValue(), output);
            } else {
                output.value(texture);
            }
        }
        output.endObject();

        return true;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private final Map<String, String> textures = new HashMap<>();

        public boolean isEmpty() {
            return textures.isEmpty();
        }

        public Builder add(String name, String texture) {
            textures.put(name, texture);
            return this;
        }

        public Textures build() {
            return new Textures(ImmutableMap.copyOf(textures));
        }
    }
}
