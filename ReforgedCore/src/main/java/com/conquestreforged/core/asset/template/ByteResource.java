package com.conquestreforged.core.asset.template;

import com.conquestreforged.core.asset.VirtualResource;
import com.google.common.io.ByteSource;
import net.minecraft.resources.IResourceManager;

import java.io.IOException;
import java.io.InputStream;

public class ByteResource extends ByteSource {

    private final IResourceManager resourceManager;
    private final VirtualResource resource;

    public ByteResource(VirtualResource resource, IResourceManager manager) {
        resourceManager = manager;
        this.resource = resource;
    }

    @Override
    public InputStream openStream() throws IOException {
        return resource.getInputStream(resourceManager);
    }
}
