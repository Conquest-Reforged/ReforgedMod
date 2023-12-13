package com.conquestrefabricated.core.asset.template;

import com.conquestrefabricated.core.asset.VirtualResource;
import com.google.common.io.ByteSource;
import net.minecraft.resource.ResourceManager;

import java.io.IOException;
import java.io.InputStream;

public class ByteResource extends ByteSource {

    private final ResourceManager resourceManager;
    private final VirtualResource resource;

    public ByteResource(VirtualResource resource, ResourceManager manager) {
        resourceManager = manager;
        this.resource = resource;
    }

    @Override
    public InputStream openStream() throws IOException {
        return resource.getInputStream(resourceManager);
    }
}
