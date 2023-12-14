package com.conquestreforged.content.blocks.particles;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;

import java.util.Locale;

public class AnimalParticleData implements ParticleEffect {

    private ParticleType animalParticleType;

    public AnimalParticleData(ParticleType animalParticleType) {
        this.animalParticleType = animalParticleType;
    }

    public AnimalParticleData() {}

    @Override
    public ParticleType<AnimalParticleData> getType() {
        return animalParticleType;
    }

    @Override
    public void write(PacketByteBuf p_197553_1_) {
    }

    @Override
    public String asString() {
        return String.format(Locale.ROOT, "%s %.2f %i %i %i", this.getType());
    }

    public static final Factory<AnimalParticleData> DESERIALIZER = new Factory<AnimalParticleData>() {

        @Override
        public AnimalParticleData read(ParticleType<AnimalParticleData> p_197544_1_, StringReader p_197544_2_) throws CommandSyntaxException {
            return new AnimalParticleData();
        }

        @Override
        public AnimalParticleData read(ParticleType<AnimalParticleData> p_197543_1_, PacketByteBuf p_197543_2_) {
            return new AnimalParticleData();
        }
    };

}
