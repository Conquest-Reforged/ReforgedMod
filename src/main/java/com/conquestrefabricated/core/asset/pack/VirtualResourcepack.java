package com.conquestrefabricated.core.asset.pack;

import com.conquestrefabricated.core.asset.VirtualResource;
import com.conquestrefabricated.core.asset.meta.VirtualMeta;
import com.google.gson.Gson;
import net.minecraft.resource.AbstractFileResourcePack;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourcePack;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class VirtualResourcepack extends AbstractFileResourcePack implements Supplier<ResourcePack> {

    private final ResourceManager resourceManager;
    private final Map<String, VirtualResource> resources;

    private VirtualResourcepack(ResourceType type, ResourceManager resourceManager, String name, Map<String, VirtualResource> resources) {
        super(new File(name));
        this.resources = resources;
        this.resourceManager = resourceManager;
        PackFinder.getInstance(type).register(this);
    }

    public int size() {
        return resources.size();
    }

    public boolean isEmpty() {
        return resources.isEmpty();
    }

    public ResourceManager getResourceManager() {
        return resourceManager;
    }

    @Override
    protected InputStream openFile(String resourcePath) throws IOException {
        VirtualResource resource = resources.get(resourcePath);
        if (resource == null) {
            throw new FileNotFoundException(resourcePath);
        }
        return resource.getInputStream(resourceManager);
    }

    @Override
    protected boolean containsFile(String resourcePath) {
        return resources.containsKey(resourcePath);
    }

    @Override
    public Collection<Identifier> findResources(ResourceType type, String namespace, String path, Predicate<Identifier> filter) {
        String prefix = type.getDirectory() + "/" + namespace + "/";

        return resources.keySet().stream()
                .filter(s -> s.startsWith(prefix))
                .map(s -> {
                    String s1 = s.substring(prefix.length());
                    int i = s1.indexOf('/');
                    if (i >= 0) {
                        String s2 = s1.substring(i + 1);
                        if (s2.startsWith(path + "/")) {
                            String[] astring = s2.substring(path.length() + 2).split("/");
                            if (astring.length >=1 && filter.test(Identifier.tryParse(s2))) {
                                String s3 = s1.substring(0, i);
                                return new Identifier(s3, s2);
                            }
                        }
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    public Set<String> getNamespaces(ResourceType type) {
        return resources.values().stream()
                .filter(r -> r.getType() == type)
                .map(VirtualResource::getNamespace)
                .collect(Collectors.toSet());
    }

    @Override
    public void close() {

    }

    public void forEach(BiConsumer<String, VirtualResource> visitor) {
        resources.forEach(visitor);
    }

    public List<Future<?>> export(Path dir, Gson gson) {
        List<Future<?>> tasks = new ArrayList<>(resources.size());
        for (Map.Entry<String, VirtualResource> entry : resources.entrySet()) {
            final Path path = dir.resolve(entry.getKey());
            final VirtualResource resource = entry.getValue();
            tasks.add(ForkJoinPool.commonPool().submit(() -> {
                try {
                    Files.createDirectories(path.getParent());
                    try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                        gson.toJson(resource.getJson(resourceManager), writer);
                    }
                } catch (Throwable ignored) {

                }
            }));
        }
        return tasks;
    }

    public static Builder builder(String name) {
        return new Builder(name);
    }

    @Override
    public ResourcePack get() {
        return null;
    }

    public static class Builder {

        private final String namespace;
        private final List<VirtualResource> resources = new LinkedList<>();
        private ResourceType type = ResourceType.CLIENT_RESOURCES;

        private Builder(String namespace) {
            this.namespace = namespace;
        }

        public Builder type(ResourceType type) {
            this.type = type;
            return this;
        }

        public Builder add(VirtualResource resource) {
            resources.add(resource);
            return this;
        }

        public VirtualResourcepack build(ResourceManager resourceManager) {
            Map<String, VirtualResource> map = new HashMap<>();
            // first so can be overridden
            map.put("pack.mcmeta", new VirtualMeta(namespace, namespace));
            // add resources second
            resources.forEach(r -> map.put(r.getPath(), r));

            String suffix = type == ResourceType.CLIENT_RESOURCES ? "_resources" : "_data";
            return new VirtualResourcepack(type, resourceManager, namespace + suffix, map);
        }
    }
}
