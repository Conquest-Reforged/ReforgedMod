package com.conquestreforged.blocks.init;

import com.conquestreforged.blocks.particles.AnimalParticleFactory;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class qParticleFactory {
    @SubscribeEvent
    public static void onParticleFactoryRegistration(ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.raven1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.raven2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.raven3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.raven4ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.ravenFlying1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.ravenFlying2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.ravenFlying3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.ravenFlying4ParticleType, sprite -> new AnimalParticleFactory(sprite));

        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.hawk1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.hawk2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.hawk3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.hawk4ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.hawkFlying1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.hawkFlying2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.hawkFlying3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.hawkFlying4ParticleType, sprite -> new AnimalParticleFactory(sprite));

        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.bat1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.bat2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.batFlying1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.batFlying2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.batFlying3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.batFlying4ParticleType, sprite -> new AnimalParticleFactory(sprite));

        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.bluejay1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.bluejay2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.bluejay3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.bluejay4ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.bluejayFlying1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.bluejayFlying2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.bluejayFlying3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.bluejayFlying4ParticleType, sprite -> new AnimalParticleFactory(sprite));

        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.duck1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.duck2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.duck3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.duck4ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.duckFlying1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.duckFlying2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.duckFlying3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.duckFlying4ParticleType, sprite -> new AnimalParticleFactory(sprite));

        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.hawk1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.hawk2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.hawk3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.hawk4ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.hawkFlying1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.hawkFlying2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.hawkFlying3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.hawkFlying4ParticleType, sprite -> new AnimalParticleFactory(sprite));

        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.owl1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.owl2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.owl3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.owl4ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.owlFlying1ParticleType, sprite -> new AnimalParticleFactory(sprite));

        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.pigeon1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.pigeon2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.pigeon3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.pigeon4ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.pigeonFlying1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.pigeonFlying2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.pigeonFlying3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.pigeonFlying4ParticleType, sprite -> new AnimalParticleFactory(sprite));

        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.puffin1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.puffinFlying1ParticleType, sprite -> new AnimalParticleFactory(sprite));

        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.seagull1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.seagull2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.seagull3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.seagull4ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.seagullFlying1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.seagullFlying2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.seagullFlying3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.seagullFlying4ParticleType, sprite -> new AnimalParticleFactory(sprite));

        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.toad1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.toad2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.toad3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.toad4ParticleType, sprite -> new AnimalParticleFactory(sprite));

        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.rat1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.rat2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.rat3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        Minecraft.getInstance().particleEngine.register(ParticleRegistrar.rat4ParticleType, sprite -> new AnimalParticleFactory(sprite));
    }
}
