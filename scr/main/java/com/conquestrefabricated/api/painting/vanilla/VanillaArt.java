package com.conquestrefabricated.api.painting.vanilla;

import com.conquestrefabricated.api.painting.art.Art;
import com.conquestrefabricated.api.painting.art.ArtRenderer;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dags <dags@dags.me>
 */
public class VanillaArt implements Art<PaintingVariant> {

    public static final List<Art<PaintingVariant>> ALL = Collections.unmodifiableList(
            Registry.PAINTING_VARIANT.stream().map(VanillaArt::new).collect(Collectors.toList())
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
        return Registry.PAINTING_VARIANT.getId(art) + "";
    }

    @Override
    public String getDisplayName(String parent) {
        return Registry.PAINTING_VARIANT.getKey(art).get().getValue().getPath();
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
        PaintingVariant type = Registry.PAINTING_VARIANT.get(new Identifier(name));
        return Art.find(type, ALL);
    }
}
