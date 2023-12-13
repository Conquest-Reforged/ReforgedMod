package com.conquestreforged.client.gui.dependency;

import com.google.gson.JsonObject;
import net.minecraft.resources.data.IMetadataSectionSerializer;

public class PackIdDeserializer implements IMetadataSectionSerializer<String> {

    public static final PackIdDeserializer INSTANCE = new PackIdDeserializer();

    @Override
    public String getSectionName() {
        return "pack";
    }

    @Override
    public String deserialize(JsonObject json) {
        if (json.has("pack_id")) {
            return json.get("pack_id").getAsString();
        }
        return "";
    }
}
