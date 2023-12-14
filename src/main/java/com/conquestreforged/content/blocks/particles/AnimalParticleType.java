package com.conquestreforged.content.blocks.particles;

import com.mojang.serialization.Codec;
import net.minecraft.particle.ParticleType;

public class AnimalParticleType extends ParticleType<AnimalParticleData> {
    private static boolean ALWAYS_SHOW_REGARDLESS_OF_DISTANCE_FROM_PLAYER = true;
    public AnimalParticleType() {
        super(ALWAYS_SHOW_REGARDLESS_OF_DISTANCE_FROM_PLAYER, AnimalParticleData.DESERIALIZER);
    }

    @Override
    public Codec<AnimalParticleData> getCodec() {
        return null;
    }
}