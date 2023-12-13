package com.conquestrefabricated.core.asset.pack;

import com.conquestrefabricated.core.asset.meta.VirtualMeta;
import com.conquestrefabricated.core.util.log.Log;
import net.minecraft.resource.*;
import net.minecraft.resource.metadata.PackResourceMetadata;
import net.minecraft.text.LiteralTextContent;
import net.minecraft.text.Text;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class PackFinder implements ResourcePackProvider {

    private static final Map<ResourceType, PackFinder> finders = new ConcurrentHashMap<>();

    private final ResourceType type;
    private final List<VirtualResourcepack> resourcePacks = new LinkedList<>();

    public PackFinder(ResourceType type) {
        this.type = type;
    }

    public void register(VirtualResourcepack pack) {
        resourcePacks.add(pack);
    }

    //todo not entirely sure if this is updated right
    @Override
    public void register(Consumer<ResourcePackProfile> map, ResourcePackProfile.Factory factory) {
        Log.info("Adding virtual packs: {}", type);
        for (VirtualResourcepack pack : resourcePacks) {
            String name = pack.getName();
            boolean client = type == ResourceType.CLIENT_RESOURCES;
            Supplier<ResourcePack> supplier = () -> pack;
            PackResourceMetadata metadata = new VirtualMeta(name, "").toMetadata();
            ResourcePackProfile.InsertionPosition priority = ResourcePackProfile.InsertionPosition.BOTTOM;
            //especially this line
            ResourcePackProfile info = factory.create(name, Text.of(name), client, supplier, metadata, priority, ResourcePackSource.PACK_SOURCE_NONE);
            map.accept(info);
            Log.info("Added virtual pack: {}", name);
        }
    }

    public void register(ResourceManager resourceManager, Consumer<ResourcePackProvider> packList) {
        Consumer<ResourcePack> consumer = pack -> {};
        if (resourceManager instanceof NamespaceResourceManager) {
            consumer = ((NamespaceResourceManager) resourceManager)::addPack;
        }
        //else if (resourceManager instanceof SimpleReloadableResourceManager) {
        //    consumer = ((SimpleReloadableResourceManager) resourceManager)::add;
        //}
        packList.accept(this);
        resourcePacks.forEach(consumer);
    }

    public static PackFinder getInstance(ResourceType type) {
        return finders.computeIfAbsent(type, PackFinder::new);
    }
}
