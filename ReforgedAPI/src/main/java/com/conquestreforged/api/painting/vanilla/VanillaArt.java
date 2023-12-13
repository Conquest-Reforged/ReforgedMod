package com.conquestreforged.api.painting.vanilla;

import com.conquestreforged.api.painting.art.Art;
import com.conquestreforged.api.painting.art.ArtRenderer;
import net.minecraft.entity.item.PaintingType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dags <dags@dags.me>
 */
public class VanillaArt implements Art<PaintingType> {

    public static final List<Art<PaintingType>> ALL = Collections.unmodifiableList(
            ForgeRegistries.PAINTING_TYPES.getValues().stream().map(VanillaArt::new).collect(Collectors.toList())
    );

    private final PaintingType art;

    private VanillaArt(PaintingType art) {
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
    public PaintingType getReference() {
        return art;
    }

    @Override
    public String getName() {
        return art.getRegistryName() + "";
    }

    @Override
    public String getDisplayName(String parent) {
        return art.getRegistryName().getPath();
    }

    @Override
    public List<Art<PaintingType>> getAll() {
        return ALL;
    }

    @Override
    public ArtRenderer getRenderer() {
        return ArtRenderer.VANILLA;
    }

    public static Art<PaintingType> fromName(String name) {
        PaintingType type = ForgeRegistries.PAINTING_TYPES.getValue(new ResourceLocation(name));
        return Art.find(type, ALL);
    }
}
