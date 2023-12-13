package com.conquestreforged.blocks.particles;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;

import java.util.Locale;

import net.minecraft.core.particles.ParticleOptions.Deserializer;

public class AnimalParticleData implements ParticleOptions {

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
    public void writeToNetwork(FriendlyByteBuf p_197553_1_) {
    }

    @Override
    public String writeToString() {
        return String.format(Locale.ROOT, "%s %.2f %i %i %i", this.getType().getRegistryName());
    }

    public static final Deserializer<AnimalParticleData> DESERIALIZER = new Deserializer<AnimalParticleData>() {

        @Override
        public AnimalParticleData fromCommand(ParticleType<AnimalParticleData> p_197544_1_, StringReader p_197544_2_) throws CommandSyntaxException {
            return new AnimalParticleData();
        }

        @Override
        public AnimalParticleData fromNetwork(ParticleType<AnimalParticleData> p_197543_1_, FriendlyByteBuf p_197543_2_) {
            return new AnimalParticleData();
        }
    };

}
