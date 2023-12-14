package com.conquestreforged.content.blocks.particles;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import org.jetbrains.annotations.Nullable;


@Environment(EnvType.CLIENT)
public class AnimalParticleFactory implements ParticleFactory<AnimalParticleData> {

    private final SpriteProvider sprites;

    public AnimalParticleFactory(SpriteProvider sprite) {
        this.sprites = sprite;
    }

    private AnimalParticleFactory() {
        throw new UnsupportedOperationException("Use the AnimalParticleFactory(IAnimatedSprite sprite) constructor");
    }

    @Nullable
    @Override
    public Particle createParticle(AnimalParticleData p_199234_1_, ClientWorld clientWorld, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        AnimalParticle newParticle = new AnimalParticle(clientWorld, x, y, z, sprites);
        newParticle.setSprite(sprites);
        return newParticle;
    }
}
