package com.conquestreforged.core.data;

import com.conquestreforged.core.asset.pack.VirtualResourcepack;
import com.conquestreforged.core.util.log.Log;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.HashCache;
import net.minecraft.data.DataProvider;
import net.minecraft.server.packs.resources.ResourceManager;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ForkJoinPool;

public class DataProviderCR implements net.minecraft.data.DataProvider {

    private static final Marker MARKER = MarkerManager.getMarker("DataGen");
    private static final Gson GSON = new Gson();

    private final DataGenerator dataGenerator;
    private final VirtualResourcepack resourcepack;

    public DataProviderCR(DataGenerator dataGenerator, VirtualResourcepack resourcepack) {
        this.dataGenerator = dataGenerator;
        this.resourcepack = resourcepack;
    }

    @Override
    public String getName() {
        return resourcepack.getName();
    }

    @Override
    @SuppressWarnings("UnstableApiUsage")
    public void run(HashCache cache) throws IOException {
        Queue<FileHash> queue = new ConcurrentLinkedQueue<>();
        ResourceManager resourceManager = resourcepack.getResourceManager();

        resourcepack.forEach((filepath, resource) -> ForkJoinPool.commonPool().submit(() -> {
            Path path = dataGenerator.getOutputFolder().resolve(filepath);
            String previousHash = cache.getHash(path);
            Files.createDirectories(path.getParent());
            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                JsonElement element = resource.getJson(resourceManager);
                String json = GSON.toJson(element);
                String hash = DataProvider.SHA1.hashUnencodedChars(json).toString();
                if (hash.equals(previousHash) && Files.exists(path)) {
                    return null;
                }
                writer.write(json);
                queue.add(new FileHash(path, hash));
                return null;
            }
        }));

        Log.info(MARKER, "Awaiting IO operations");
        long count = 0;
        while (!ForkJoinPool.commonPool().isQuiescent()) {
            FileHash hash = queue.poll();
            if (hash == null) {
                continue;
            }
            count++;
            cache.putNew(hash.getPath(), hash.getHash());
        }

        Log.info(MARKER, "Flushing remaining file hashes");
        for (FileHash hash : queue) {
            count++;
            cache.putNew(hash.getPath(), hash.getHash());
        }

        Log.info(MARKER, "Generated {} data files", count);
    }
}
