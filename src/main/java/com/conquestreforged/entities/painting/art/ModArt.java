package com.conquestreforged.entities.painting.art;

import com.conquestreforged.api.painting.art.Art;
import com.conquestreforged.api.painting.art.ArtRenderer;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author dags <dags@dags.me>
 */
public class ModArt implements Art<ArtType> {

    public static final List<Art<ArtType>> ALL = Collections.unmodifiableList(
            Stream.of(ArtType.values()).map(ModArt::new).collect(Collectors.toList())
    );

    private final ArtType art;

    public ModArt(ArtType art) {
        this.art = art;
    }

    @Override
    public int u() {
        return art.offsetX;
    }

    @Override
    public int v() {
        return art.offsetY;
    }

    @Override
    public int width() {
        return art.sizeX;
    }

    @Override
    public int height() {
        return art.sizeY;
    }

    @Override
    public int textureWidth() {
        return 256;
    }

    @Override
    public int textureHeight() {
        return 256;
    }

    @Override
    public ArtType getReference() {
        return art;
    }

    @Override
    public String getName() {
        return art.shapeId;
    }

    @Override
    public String getDisplayName(String parent) {
        return art.getDisplayName(parent);
    }

    @Override
    public List<Art<ArtType>> getAll() {
        return ALL;
    }

    @Override
    public ArtRenderer getRenderer() {
        return ArtRenderer.MOD;
    }

    public static Art<ArtType> of(ArtType art) {
        return Art.find(art, ALL);
    }

    public static Art<ArtType> fromName(String name) {
        return Art.find(ArtType.fromName(name), ALL);
    }
}
