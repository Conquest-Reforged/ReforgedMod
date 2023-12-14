package com.conquestreforged.content.blocks.particles;

import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;

public class AnimalParticle extends SpriteBillboardParticle {

    private final SpriteProvider sprites;

    public AnimalParticle(ClientWorld world, double x, double y, double z, SpriteProvider sprites) {
        super(world, x, y, z);
        this.setPos(x, y, z);
        this.gravityStrength = 0.0F;
        this.collidesWithWorld = false;
        this.sprites = sprites;
        this.maxAge = 80;
    }

    @Override
    public float getSize(float p_217561_1_) {
        return 0.5F;
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

}
