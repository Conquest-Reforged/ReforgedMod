package com.conquestreforged.core.asset.pack;

import com.conquestreforged.core.asset.meta.VirtualMeta;
import com.conquestreforged.core.util.log.Log;
import net.minecraft.resources.FallbackResourceManager;
import net.minecraft.resources.IPackFinder;
import net.minecraft.resources.IResourceManager;
import net.minecraft.resources.IResourcePack;
import net.minecraft.resources.ResourcePackInfo;
import net.minecraft.resources.ResourcePackType;
import net.minecraft.resources.SimpleReloadableResourceManager;
import net.minecraft.resources.data.PackMetadataSection;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class PackFinder implements IPackFinder {

    private static final Map<ResourcePackType, PackFinder> finders = new ConcurrentHashMap<>();

    private final ResourcePackType type;
    private final List<VirtualResourcepack> resourcePacks = new LinkedList<>();

    public PackFinder(ResourcePackType type) {
        this.type = type;
    }

    public void register(VirtualResourcepack pack) {
        resourcePacks.add(pack);
    }

    @Override
    public <T extends ResourcePackInfo> void addPackInfosToMap(Map<String, T> map, ResourcePackInfo.IFactory<T> factory) {
        Log.info("Adding virtual packs: {}", type);
        for (VirtualResourcepack pack : resourcePacks) {
            String name = pack.getName();
            boolean client = type == ResourcePackType.CLIENT_RESOURCES;
            Supplier<IResourcePack> supplier = () -> pack;
            PackMetadataSection metadata = new VirtualMeta(name, "").toMetadata();
            ResourcePackInfo.Priority priority = ResourcePackInfo.Priority.BOTTOM;
            T info = factory.create(name, client, supplier, pack, metadata, priority);
            map.put(name, info);
            Log.info("Added virtual pack: {}", name);
        }
    }

    public void register(IResourceManager resourceManager, Consumer<IPackFinder> packList) {
        Consumer<IResourcePack> consumer = pack -> {};
        if (resourceManager instanceof FallbackResourceManager) {
            consumer = ((FallbackResourceManager) resourceManager)::addResourcePack;
        } else if (resourceManager instanceof SimpleReloadableResourceManager) {
            consumer = ((SimpleReloadableResourceManager) resourceManager)::addResourcePack;
        }
        packList.accept(this);
        resourcePacks.forEach(consumer);
    }

    public static PackFinder getInstance(ResourcePackType type) {
        return finders.computeIfAbsent(type, PackFinder::new);
    }
}
