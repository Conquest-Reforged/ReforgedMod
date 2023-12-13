package com.conquestreforged.core.asset;

import com.google.gson.JsonElement;
import net.minecraft.resources.IResourceManager;
import net.minecraft.resources.ResourcePackType;

import java.io.IOException;
import java.io.InputStream;

public interface VirtualResource {

    String getPath();

    String getNamespace();

    ResourcePackType getType();

    JsonElement getJson(IResourceManager resourceManager) throws IOException;

    InputStream getInputStream(IResourceManager resourceManager) throws IOException;
}
