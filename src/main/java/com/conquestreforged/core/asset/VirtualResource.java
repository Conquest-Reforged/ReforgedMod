package com.conquestreforged.core.asset;

import com.google.gson.JsonElement;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.PackType;

import java.io.IOException;
import java.io.InputStream;

public interface VirtualResource {

    String getPath();

    String getNamespace();

    PackType getType();

    JsonElement getJson(ResourceManager resourceManager) throws IOException;

    InputStream getInputStream(ResourceManager resourceManager) throws IOException;
}
