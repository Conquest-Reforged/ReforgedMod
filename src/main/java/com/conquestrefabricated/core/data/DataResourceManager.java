package com.conquestrefabricated.core.data;

import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourcePack;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class DataResourceManager implements ResourceManager {

    private final ResourceType type;
    private final ExistingFileHelper helper;

    public DataResourceManager(ResourceType type, ExistingFileHelper helper) {
        this.type = type;
        this.helper = helper;
    }

    @Override
    public Set<String> getAllNamespaces() {
        return Collections.emptySet();
    }

    @Override
    public Optional<Resource> getResource(Identifier location) {
        int pre = location.getPath().indexOf('/');
        int suf = location.getPath().lastIndexOf('.');
        String prefix = location.getPath().substring(0, pre);
        String suffix = location.getPath().substring(suf);
        String path = location.getPath().substring(pre + 1, suf);
        Identifier name = new Identifier(location.getNamespace(), path);

        try {
            return Optional.ofNullable(helper.getResource(name, type, suffix, prefix));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    @Override
    public boolean containsResource(Identifier location) {
        int pre = location.getPath().indexOf('/');
        int suf = location.getPath().lastIndexOf('.');
        String prefix = location.getPath().substring(0, pre);
        String suffix = location.getPath().substring(suf);
        String path = location.getPath().substring(pre + 1, suf);
        Identifier name = new Identifier(location.getNamespace(), path);
        return helper.exists(name, type, suffix, prefix);
    }*/

    @Override
    public List<Resource> getAllResources(Identifier location) {
        return Collections.emptyList();
    }

    @Override
    public Map<Identifier, Resource> findResources(String path, Predicate<Identifier> filter) {
        return Map.of();
    }

    @Override
    public Map<Identifier, List<Resource>> findAllResources(String string, Predicate<Identifier> predicate) {
        return Map.of();
    }

    //todo unsure about this one
    @Override
    public Stream<ResourcePack> streamResourcePacks() {
        return Stream.of();
    }
}
