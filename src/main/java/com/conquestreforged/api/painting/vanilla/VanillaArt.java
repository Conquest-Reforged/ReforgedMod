package com.conquestreforged.api.painting.vanilla;

import com.conquestreforged.api.painting.art.Art;
import com.conquestreforged.api.painting.art.ArtRenderer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.PaintingVariant;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dags <dags@dags.me>
 */
public class VanillaArt implements Art<PaintingVariant> {

    public static final List<Art<PaintingVariant>> ALL = Collections.unmodifiableList(
            BuiltInRegistries.PAINTING_VARIANT.stream().map(VanillaArt::new).collect(Collectors.toList())
    );

    private final PaintingVariant art;

    private VanillaArt(PaintingVariant art) {
        this.art = art;
    }

    @Override
    public int u() {
        return 0;
    }

    @Override
    public int v() {
        return 0;
    }

    @Override
    public int width() {
        return art.getWidth();
    }

    @Override
    public int height() {
        return art.getHeight();
    }

    @Override
    public int textureWidth() {
        return art.getWidth();
    }

    @Override
    public int textureHeight() {
        return art.getHeight();
    }

    @Override
    public PaintingVariant getReference() {
        return art;
    }

    @Override
    public String getName() {
        return BuiltInRegistries.PAINTING_VARIANT.getId(art) + "";
    }

    @Override
    public String getDisplayName(String parent) {
        return BuiltInRegistries.PAINTING_VARIANT.getKey(art).getPath();
    }

    @Override
    public List<Art<PaintingVariant>> getAll() {
        return ALL;
    }

    @Override
    public ArtRenderer getRenderer() {
        return ArtRenderer.VANILLA;
    }

    public static Art<PaintingVariant> fromName(String name) {
        PaintingVariant type = BuiltInRegistries.PAINTING_VARIANT.get(new ResourceLocation(name));
        return Art.find(type, ALL);
    }
}
