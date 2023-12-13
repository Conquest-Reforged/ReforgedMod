package com.conquestreforged.core.data;

import java.nio.file.Path;

public class FileHash {

    private final Path path;
    private final String hash;

    public FileHash(Path path, String hash) {
        this.path = path;
        this.hash = hash;
    }

    public Path getPath() {
        return path;
    }

    public String getHash() {
        return hash;
    }
}
