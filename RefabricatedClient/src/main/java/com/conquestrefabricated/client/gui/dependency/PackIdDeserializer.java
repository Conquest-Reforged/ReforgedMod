package com.conquestrefabricated.client.gui.dependency;

import com.google.gson.JsonObject;
import net.minecraft.resource.metadata.ResourceMetadataReader;

public class PackIdDeserializer implements ResourceMetadataReader<String> {

    public static final PackIdDeserializer INSTANCE = new PackIdDeserializer();

    @Override
    public String getKey() {
        return "pack";
    }

    @Override
    public String fromJson(JsonObject json) {
        if (json.has("pack_id")) {
            return json.get("pack_id").getAsString();
        }
        return "";
    }
}
