package com.conquestreforged.core.data;

import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class DataResourceManager implements ResourceManager {

    private final PackType type;
    private final ExistingFileHelper helper;

    public DataResourceManager(PackType type, ExistingFileHelper helper) {
        this.type = type;
        this.helper = helper;
    }

    @Override
    public Set<String> getNamespaces() {
        return Collections.emptySet();
    }

    @Override
    public Resource m_142591_(ResourceLocation location) throws IOException {
        int pre = location.getPath().indexOf('/');
        int suf = location.getPath().lastIndexOf('.');
        String prefix = location.getPath().substring(0, pre);
        String suffix = location.getPath().substring(suf);
        String path = location.getPath().substring(pre + 1, suf);
        ResourceLocation name = new ResourceLocation(location.getNamespace(), path);
        return helper.getResource(name, type, suffix, prefix);
    }

    @Override
    public boolean m_7165_(ResourceLocation location) {
        int pre = location.getPath().indexOf('/');
        int suf = location.getPath().lastIndexOf('.');
        String prefix = location.getPath().substring(0, pre);
        String suffix = location.getPath().substring(suf);
        String path = location.getPath().substring(pre + 1, suf);
        ResourceLocation name = new ResourceLocation(location.getNamespace(), path);
        return helper.exists(name, type, suffix, prefix);
    }

    @Override
    public List<Resource> m_7396_(ResourceLocation location) throws IOException {
        return Collections.emptyList();
    }

    @Override
    public Collection<ResourceLocation> m_6540_(String path, Predicate<String> filter) {
        return Collections.emptyList();
    }

    //todo unsure about this one
    @Override
    public Stream<PackResources> listPacks() {
        return Stream.of();
    }
}
