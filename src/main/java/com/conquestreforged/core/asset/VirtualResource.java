package com.conquestreforged.core.asset;

import com.google.gson.JsonElement;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;

import java.io.IOException;
import java.io.InputStream;

public interface VirtualResource {

    String getPath();

    String getNamespace();

    ResourceType getType();

    JsonElement getJson(ResourceManager resourceManager) throws IOException;

    InputStream getInputStream(ResourceManager resourceManager) throws IOException;
}
