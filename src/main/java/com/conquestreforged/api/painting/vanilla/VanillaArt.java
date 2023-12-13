package com.conquestreforged.api.painting.vanilla;

import com.conquestreforged.api.painting.art.Art;
import com.conquestreforged.api.painting.art.ArtRenderer;
import net.minecraft.world.entity.decoration.Motive;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dags <dags@dags.me>
 */
public class VanillaArt implements Art<Motive> {

    public static final List<Art<Motive>> ALL = Collections.unmodifiableList(
            ForgeRegistries.PAINTING_TYPES.getValues().stream().map(VanillaArt::new).collect(Collectors.toList())
    );

    private final Motive art;

    private VanillaArt(Motive art) {
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
        return art.m_31896_();
    }

    @Override
    public int height() {
        return art.m_31901_();
    }

    @Override
    public int textureWidth() {
        return art.m_31896_();
    }

    @Override
    public int textureHeight() {
        return art.m_31901_();
    }

    @Override
    public Motive getReference() {
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
    public List<Art<Motive>> getAll() {
        return ALL;
    }

    @Override
    public ArtRenderer getRenderer() {
        return ArtRenderer.VANILLA;
    }

    public static Art<Motive> fromName(String name) {
        Motive type = ForgeRegistries.PAINTING_TYPES.getValue(new ResourceLocation(name));
        return Art.find(type, ALL);
    }
}
