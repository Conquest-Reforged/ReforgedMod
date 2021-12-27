package com.conquestreforged.core.asset.pack;

import com.conquestreforged.core.asset.meta.VirtualMeta;
import com.conquestreforged.core.util.log.Log;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.*;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;

import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.server.packs.repository.RepositorySource;
import net.minecraft.server.packs.resources.FallbackResourceManager;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleReloadableResourceManager;

public class PackFinder implements RepositorySource {

    private static final Map<PackType, PackFinder> finders = new ConcurrentHashMap<>();

    private final PackType type;
    private final List<VirtualResourcepack> resourcePacks = new LinkedList<>();

    public PackFinder(PackType type) {
        this.type = type;
    }

    public void register(VirtualResourcepack pack) {
        resourcePacks.add(pack);
    }

    //todo not entirely sure if this is updated right
    @Override
    public void loadPacks(Consumer<Pack> map, Pack.PackConstructor factory) {
        Log.info("Adding virtual packs: {}", type);
        for (VirtualResourcepack pack : resourcePacks) {
            String name = pack.getName();
            boolean client = type == PackType.CLIENT_RESOURCES;
            Supplier<PackResources> supplier = () -> pack;
            PackMetadataSection metadata = new VirtualMeta(name, "").toMetadata();
            Pack.Position priority = Pack.Position.BOTTOM;
            //especially this line
            Pack info = factory.create(name, new TextComponent(name), client, supplier, metadata, priority, PackSource.DEFAULT, false);
            map.accept(info);
            Log.info("Added virtual pack: {}", name);
        }
    }

    public void register(ResourceManager resourceManager, Consumer<RepositorySource> packList) {
        Consumer<PackResources> consumer = pack -> {};
        if (resourceManager instanceof FallbackResourceManager) {
            consumer = ((FallbackResourceManager) resourceManager)::add;
        } else if (resourceManager instanceof SimpleReloadableResourceManager) {
            consumer = ((SimpleReloadableResourceManager) resourceManager)::add;
        }
        packList.accept(this);
        resourcePacks.forEach(consumer);
    }

    public static PackFinder getInstance(PackType type) {
        return finders.computeIfAbsent(type, PackFinder::new);
    }
}
