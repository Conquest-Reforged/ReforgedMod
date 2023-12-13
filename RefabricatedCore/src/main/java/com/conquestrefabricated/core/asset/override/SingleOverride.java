package com.conquestrefabricated.core.asset.override;

import com.conquestrefabricated.core.asset.template.JsonOverride;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class SingleOverride implements JsonOverride {

    private final boolean any;
    private final String key;
    private final JsonElement find;
    private final JsonElement replace;

    public SingleOverride(String key, JsonElement replace) {
        this(key, new JsonPrimitive("*"), replace);
    }

    public SingleOverride(String key, JsonElement find, JsonElement replace) {
        this.key = key;
        this.find = find;
        this.replace = replace;
        this.any = find.getAsString().equals("*");
    }

    @Override
    public boolean apply(JsonElement input, JsonWriter writer) throws IOException {
        if (any || find.equals(input)) {
            Streams.write(replace, writer);
            return true;
        }
        return false;
    }

    @Override
    public boolean appliesTo(String key, JsonElement value) {
        return this.key.equals(key) && value.isJsonPrimitive();
    }
}
