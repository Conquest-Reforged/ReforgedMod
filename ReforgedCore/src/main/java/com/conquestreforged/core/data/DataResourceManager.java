package com.conquestreforged.core.data;

import net.minecraft.resources.IResource;
import net.minecraft.resources.IResourceManager;
import net.minecraft.resources.ResourcePackType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ExistingFileHelper;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class DataResourceManager implements IResourceManager {

    private final ResourcePackType type;
    private final ExistingFileHelper helper;

    public DataResourceManager(ResourcePackType type, ExistingFileHelper helper) {
        this.type = type;
        this.helper = helper;
    }

    @Override
    public Set<String> getResourceNamespaces() {
        return Collections.emptySet();
    }

    @Override
    public IResource getResource(ResourceLocation location) throws IOException {
        int pre = location.getPath().indexOf('/');
        int suf = location.getPath().lastIndexOf('.');
        String prefix = location.getPath().substring(0, pre);
        String suffix = location.getPath().substring(suf);
        String path = location.getPath().substring(pre + 1, suf);
        ResourceLocation name = new ResourceLocation(location.getNamespace(), path);
        return helper.getResource(name, type, suffix, prefix);
    }

    @Override
    public boolean hasResource(ResourceLocation location) {
        int pre = location.getPath().indexOf('/');
        int suf = location.getPath().lastIndexOf('.');
        String prefix = location.getPath().substring(0, pre);
        String suffix = location.getPath().substring(suf);
        String path = location.getPath().substring(pre + 1, suf);
        ResourceLocation name = new ResourceLocation(location.getNamespace(), path);
        return helper.exists(name, type, suffix, prefix);
    }

    @Override
    public List<IResource> getAllResources(ResourceLocation location) throws IOException {
        return Collections.emptyList();
    }

    @Override
    public Collection<ResourceLocation> getAllResourceLocations(String path, Predicate<String> filter) {
        return Collections.emptyList();
    }
}
