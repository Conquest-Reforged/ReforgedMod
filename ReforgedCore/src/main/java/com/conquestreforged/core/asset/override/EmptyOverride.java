package com.conquestreforged.core.asset.override;

import com.conquestreforged.core.asset.template.JsonOverride;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class EmptyOverride implements JsonOverride {

    public static final EmptyOverride EMPTY = new EmptyOverride();

    private EmptyOverride() {

    }

    @Override
    public boolean apply(JsonElement input, JsonWriter output) throws IOException {
        return false;
    }

    @Override
    public boolean appliesTo(String key, JsonElement value) {
        return false;
    }
}
