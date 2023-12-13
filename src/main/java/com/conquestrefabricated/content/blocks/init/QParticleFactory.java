package com.conquestrefabricated.content.blocks.init;

import com.conquestrefabricated.content.blocks.particles.AnimalParticleFactory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;


@Environment(EnvType.CLIENT)
public class QParticleFactory {
   // @SubscribeEvent
    public static void onParticleFactoryRegistration() {
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.raven1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.raven2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.raven3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.raven4ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.ravenFlying1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.ravenFlying2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.ravenFlying3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.ravenFlying4ParticleType, sprite -> new AnimalParticleFactory(sprite));

        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.hawk1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.hawk2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.hawk3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.hawk4ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.hawkFlying1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.hawkFlying2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.hawkFlying3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.hawkFlying4ParticleType, sprite -> new AnimalParticleFactory(sprite));

        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.bat1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.bat2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.batFlying1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.batFlying2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.batFlying3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.batFlying4ParticleType, sprite -> new AnimalParticleFactory(sprite));

        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.bluejay1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.bluejay2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.bluejay3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.bluejay4ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.bluejayFlying1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.bluejayFlying2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.bluejayFlying3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.bluejayFlying4ParticleType, sprite -> new AnimalParticleFactory(sprite));

        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.duck1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.duck2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.duck3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.duck4ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.duckFlying1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.duckFlying2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.duckFlying3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.duckFlying4ParticleType, sprite -> new AnimalParticleFactory(sprite));

        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.owl1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.owl2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.owl3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.owl4ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.owlFlying1ParticleType, sprite -> new AnimalParticleFactory(sprite));

        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.pigeon1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.pigeon2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.pigeon3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.pigeon4ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.pigeonFlying1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.pigeonFlying2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.pigeonFlying3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.pigeonFlying4ParticleType, sprite -> new AnimalParticleFactory(sprite));

        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.puffin1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.puffinFlying1ParticleType, sprite -> new AnimalParticleFactory(sprite));

        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.seagull1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.seagull2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.seagull3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.seagull4ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.seagullFlying1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.seagullFlying2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.seagullFlying3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.seagullFlying4ParticleType, sprite -> new AnimalParticleFactory(sprite));

        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.toad1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.toad2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.toad3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.toad4ParticleType, sprite -> new AnimalParticleFactory(sprite));

        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.rat1ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.rat2ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.rat3ParticleType, sprite -> new AnimalParticleFactory(sprite));
        ParticleFactoryRegistry.getInstance().register(ParticleRegistrar.rat4ParticleType, sprite -> new AnimalParticleFactory(sprite));
    }
}
