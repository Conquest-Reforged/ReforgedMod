package com.conquestreforged.client.gui.dependency;

import com.google.gson.JsonObject;
import net.minecraft.server.packs.metadata.MetadataSectionSerializer;

public class PackIdDeserializer implements MetadataSectionSerializer<String> {

    public static final PackIdDeserializer INSTANCE = new PackIdDeserializer();

    @Override
    public String getMetadataSectionName() {
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
