package com.conquestreforged.core.asset.template;

import com.conquestreforged.core.asset.VirtualResource;
import com.google.gson.JsonElement;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;

import java.io.IOException;
import java.io.InputStream;

public class TemplateResource implements VirtualResource {

    private final String path;
    private final String namespace;
    private final JsonTemplate template;
    private final JsonOverride overrides;
    private final ResourceType packType;

    public TemplateResource(ResourceType type, String namespace, String path, JsonOverride overrides, JsonTemplate template) {
        this.namespace = namespace;
        this.overrides = overrides;
        this.template = template;
        this.packType = type;
        this.path = path;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public String getNamespace() {
        return namespace;
    }

    @Override
    public ResourceType getType() {
        return packType;
    }

    @Override
    public JsonElement getJson(ResourceManager resourceManager) throws IOException {
        return template.getJson(resourceManager, overrides);
    }

    @Override
    public InputStream getInputStream(ResourceManager resourceManager) throws IOException {
        return template.getInputStream(resourceManager, overrides);
    }

    @Override
    public String toString() {
        return "TemplateResource{" +
                "path=" + path +
                ", template=" + template +
                '}';
    }

    public static TemplateResource asset(String namespace, String path, JsonOverride overrides, JsonTemplate template) {
        return new TemplateResource(
                ResourceType.CLIENT_RESOURCES,
                namespace,
                path,
                overrides,
                template
        );
    }

    public static TemplateResource data(String namespace, String path, JsonOverride overrides, JsonTemplate template) {
        return new TemplateResource(
                ResourceType.SERVER_DATA,
                namespace,
                path,
                overrides,
                template
        );
    }
}