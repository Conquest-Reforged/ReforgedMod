package com.conquestrefabricated.core.asset.override;

import com.conquestrefabricated.core.asset.template.JsonOverride;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Map;

public class MapOverride implements JsonOverride {

    private static final JsonElement ANY_KEY = new JsonPrimitive("*");

    private final String key;
    private final JsonElement any;
    private final Map<JsonElement, JsonElement> overrides;

    public MapOverride(String key, Map<JsonElement, JsonElement> overrides) {
        this.key = key;
        this.overrides = overrides;
        this.any = overrides.get(ANY_KEY);
    }

    @Override
    public boolean apply(JsonElement input, JsonWriter writer) throws IOException {
        JsonElement output = overrides.getOrDefault(input, any);
        if (output != null) {
            Streams.write(output, writer);
            return true;
        }
        return false;
    }

    @Override
    public boolean appliesTo(String key, JsonElement value) {
        return this.key.equals(key) && value.isJsonPrimitive();
    }
}
