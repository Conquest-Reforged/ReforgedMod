package com.conquestreforged.core.data;

import com.conquestreforged.core.asset.pack.VirtualResourcepack;
import com.google.gson.Gson;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import java.io.IOException;

public class DataProviderCR implements DataProvider {

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
    public void run(DataWriter cache) throws IOException {
        /*
        Queue<FileHash> queue = new ConcurrentLinkedQueue<>();
        ResourceManager resourceManager = resourcepack.getResourceManager();

        resourcepack.forEach((filepath, resource) -> ForkJoinPool.commonPool().submit(() -> {
            Path path = dataGenerator.getOutput().resolve(filepath);
            Files.createDirectories(path.getParent());
            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                JsonElement element = resource.getJson(resourceManager);
                String json = GSON.toJson(element);
                if (Files.exists(path)) {
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
            cache.updateSha1(hash.getPath(), hash.getHash());
        }

        Log.info(MARKER, "Flushing remaining file hashes");
        for (FileHash hash : queue) {
            count++;
            cache.updateSha1(hash.getPath(), hash.getHash());
        }

        Log.info(MARKER, "Generated {} data files", count);*/
    }
}
