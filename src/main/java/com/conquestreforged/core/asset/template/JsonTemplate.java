package com.conquestreforged.core.asset.template;

import com.conquestreforged.core.util.ByteStream;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.stream.JsonWriter;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;

import java.io.*;
import java.util.Map;

public class JsonTemplate {

    private static final JsonParser parser = new JsonParser();
    private static final Object lock = new Object();

    private final String path;
    private final Identifier location;

    private JsonObject cached;

    JsonTemplate(String location) {
        String root = "";
        if (location.startsWith("assets/")) {
            root = "assets/";
            location = location.substring("assets/".length());
        } else if (location.startsWith("data/")) {
            root = "data/";
            location = location.substring("data/".length());
        }
        int i = location.indexOf('/');
        String domain = location.substring(0, i);
        String path = location.substring(i + 1);
        this.location = new Identifier(domain, path);
        this.path = root + domain + "/" + path;
    }

    @Override
    public String toString() {
        return "JsonTemplate{location=" + location + '}';
    }

    public JsonElement getJson(ResourceManager resourceManager, JsonOverride overrides) throws IOException {
        JsonTreeWriter writer = new JsonTreeWriter();
        apply(resourceManager, writer, overrides);
        return writer.get();
    }

    public void apply(ResourceManager resourceManager, JsonWriter writer, JsonOverride overrides) throws IOException {
        JsonObject object = getJson(resourceManager);
        write(writer, overrides, object);
    }

    public InputStream getInputStream(ResourceManager resourceManager, JsonOverride overrides) throws IOException {
        try (ByteStream.Output out = new ByteStream.Output()) {
            try (JsonWriter writer = new JsonWriter(new OutputStreamWriter(out))) {
                apply(resourceManager, writer, overrides);
            }
            return out.toInputStream();
        }
    }

    private JsonObject getJson(ResourceManager resourceManager) throws IOException {
        synchronized (lock) {
            if (cached == null) {
                try  {
                    Resource resource = resourceManager.getResource(location).get();
                    try (InputStream in = resource.getInputStream()) {
                        try (Reader reader = new InputStreamReader(in)) {
                            JsonElement element = parser.parse(reader);
                            if (element.isJsonObject()) {
                                cached = element.getAsJsonObject();
                            } else {
                                throw new IOException("resource is not a template object");
                            }
                        }
                    }
                } catch (Throwable t) {
                    throw new IOException(this.path, t);
                }
            }
        }
        return cached;
    }

    private void write(JsonWriter writer, JsonOverride overrides, JsonElement element) throws IOException {
        if (element.isJsonArray()) {
            writer.beginArray();
            for (JsonElement entry : element.getAsJsonArray()) {
                write(writer, overrides, entry);
            }
            writer.endArray();
            return;
        }

        if (element.isJsonObject()) {
            writer.beginObject();
            for (Map.Entry<String, JsonElement> entry : element.getAsJsonObject().entrySet()) {
                String key = entry.getKey();
                JsonElement value = entry.getValue();
                writer.name(key);
                boolean overwritten = overrides.appliesTo(key, value) && overrides.apply(value, writer);
                if (!overwritten) {
                    write(writer, overrides, value);
                }
            }
            writer.endObject();
            return;
        }

        Streams.write(element, writer);
    }
}
