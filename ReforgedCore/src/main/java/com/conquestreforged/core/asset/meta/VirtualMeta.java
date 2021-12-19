package com.conquestreforged.core.asset.meta;

import com.conquestreforged.core.asset.VirtualResource;
import com.conquestreforged.core.util.ByteStream;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonWriter;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

public class VirtualMeta implements VirtualResource {

    public static final int PACK_FORMAT = 5;

    private final String description;
    private final String namespace;

    public VirtualMeta(String namespace, String description) {
        this.description = description;
        this.namespace = namespace;
    }

    public PackMetadataSection toMetadata() {
        return PackMetadataSection.SERIALIZER.fromJson(toJson());
    }

    @Override
    public String getPath() {
        return "pack.mcmeta";
    }

    @Override
    public String getNamespace() {
        return namespace;
    }

    @Override
    public PackType getType() {
        return PackType.CLIENT_RESOURCES;
    }

    @Override
    public JsonElement getJson(ResourceManager resourceManager) throws IOException {
        return toJson();
    }

    @Override
    public InputStream getInputStream(ResourceManager resourceManager) throws IOException {
        ByteStream.Output out = new ByteStream.Output();
        try (JsonWriter writer = new JsonWriter(new OutputStreamWriter(out))) {
            Streams.write(toJson(), writer);
        }
        return out.toInputStream();
    }

    private JsonObject toJson() {
        JsonObject pack = new JsonObject();
        pack.addProperty("description", description);
        pack.addProperty("pack_format", PACK_FORMAT);

        JsonObject meta = new JsonObject();
        meta.add("pack", pack);
        meta.add("language", new JsonObject());
        return pack;
    }
}
