package com.conquestrefabricated.core.asset.template;

import com.conquestrefabricated.core.asset.override.EmptyOverride;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public interface JsonOverride {

    boolean apply(JsonElement input, JsonWriter output) throws IOException;

    boolean appliesTo(String key, JsonElement value);

    default JsonOverride add(JsonOverride other) {
        if (this == EmptyOverride.EMPTY) {
            return other;
        }
        if (other == EmptyOverride.EMPTY) {
            return this;
        }
        JsonOverride self = this;
        return new JsonOverride() {

            private final JsonOverride a = self;
            private final JsonOverride b = other;

            @Override
            public boolean apply(JsonElement input, JsonWriter output) throws IOException {
                return a.apply(input, output) || b.apply(input, output);
            }

            @Override
            public boolean appliesTo(String key, JsonElement value) {
                return a.appliesTo(key, value) || b.appliesTo(key, value);
            }
        };
    }
}
