package com.conquestreforged.blocks.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;

public class AnimalParticle extends TextureSheetParticle {

    private final SpriteSet sprites;

    public AnimalParticle(ClientLevel world, double x, double y, double z, SpriteSet sprites) {
        super(world, x, y, z);
        this.setPos(x, y, z);
        this.gravity = 0.0F;
        this.hasPhysics = false;
        this.sprites = sprites;
        this.lifetime = 80;
    }

    @Override
    public float getQuadSize(float p_217561_1_) {
        return 0.5F;
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

}
