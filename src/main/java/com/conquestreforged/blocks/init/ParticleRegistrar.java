package com.conquestreforged.blocks.init;

import com.conquestreforged.blocks.particles.AnimalParticleData;
import com.conquestreforged.blocks.particles.AnimalParticleType;
import net.minecraft.core.particles.ParticleType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleRegistrar {

    public static ParticleType<AnimalParticleData> raven1ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> raven2ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> raven3ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> raven4ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> ravenFlying1ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> ravenFlying2ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> ravenFlying3ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> ravenFlying4ParticleType = new AnimalParticleType();

    public static ParticleType<AnimalParticleData> hawk1ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> hawk2ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> hawk3ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> hawk4ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> hawkFlying1ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> hawkFlying2ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> hawkFlying3ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> hawkFlying4ParticleType = new AnimalParticleType();

    public static ParticleType<AnimalParticleData> bat1ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> bat2ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> batFlying1ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> batFlying2ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> batFlying3ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> batFlying4ParticleType = new AnimalParticleType();

    public static ParticleType<AnimalParticleData> bluejay1ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> bluejay2ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> bluejay3ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> bluejay4ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> bluejayFlying1ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> bluejayFlying2ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> bluejayFlying3ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> bluejayFlying4ParticleType = new AnimalParticleType();

    public static ParticleType<AnimalParticleData> duck1ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> duck2ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> duck3ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> duck4ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> duckFlying1ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> duckFlying2ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> duckFlying3ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> duckFlying4ParticleType = new AnimalParticleType();

    public static ParticleType<AnimalParticleData> owl1ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> owl2ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> owl3ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> owl4ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> owlFlying1ParticleType = new AnimalParticleType();

    public static ParticleType<AnimalParticleData> pigeon1ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> pigeon2ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> pigeon3ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> pigeon4ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> pigeonFlying1ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> pigeonFlying2ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> pigeonFlying3ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> pigeonFlying4ParticleType = new AnimalParticleType();

    public static ParticleType<AnimalParticleData> puffin1ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> puffinFlying1ParticleType = new AnimalParticleType();

    public static ParticleType<AnimalParticleData> seagull1ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> seagull2ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> seagull3ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> seagull4ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> seagullFlying1ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> seagullFlying2ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> seagullFlying3ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> seagullFlying4ParticleType = new AnimalParticleType();

    public static ParticleType<AnimalParticleData> rat1ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> rat2ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> rat3ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> rat4ParticleType = new AnimalParticleType();

    public static ParticleType<AnimalParticleData> toad1ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> toad2ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> toad3ParticleType = new AnimalParticleType();
    public static ParticleType<AnimalParticleData> toad4ParticleType = new AnimalParticleType();

    @SubscribeEvent
    public static void onIParticleTypeRegistration(RegistryEvent.Register<ParticleType<?>> iParticleTypeRegisterEvent) {
        registerAnimalParticle(raven1ParticleType,"raven_1", iParticleTypeRegisterEvent);
        registerAnimalParticle(raven2ParticleType,"raven_2", iParticleTypeRegisterEvent);
        registerAnimalParticle(raven3ParticleType,"raven_3", iParticleTypeRegisterEvent);
        registerAnimalParticle(raven4ParticleType,"raven_4", iParticleTypeRegisterEvent);
        registerAnimalParticle(ravenFlying1ParticleType,"raven_flying_1", iParticleTypeRegisterEvent);
        registerAnimalParticle(ravenFlying2ParticleType,"raven_flying_2", iParticleTypeRegisterEvent);
        registerAnimalParticle(ravenFlying3ParticleType,"raven_flying_3", iParticleTypeRegisterEvent);
        registerAnimalParticle(ravenFlying4ParticleType,"raven_flying_4", iParticleTypeRegisterEvent);

        registerAnimalParticle(hawk1ParticleType,"hawk_1", iParticleTypeRegisterEvent);
        registerAnimalParticle(hawk2ParticleType,"hawk_2", iParticleTypeRegisterEvent);
        registerAnimalParticle(hawk3ParticleType,"hawk_3", iParticleTypeRegisterEvent);
        registerAnimalParticle(hawk4ParticleType,"hawk_4", iParticleTypeRegisterEvent);
        registerAnimalParticle(hawkFlying1ParticleType,"hawk_flying_1", iParticleTypeRegisterEvent);
        registerAnimalParticle(hawkFlying2ParticleType,"hawk_flying_2", iParticleTypeRegisterEvent);
        registerAnimalParticle(hawkFlying3ParticleType,"hawk_flying_3", iParticleTypeRegisterEvent);
        registerAnimalParticle(hawkFlying4ParticleType,"hawk_flying_4", iParticleTypeRegisterEvent);

        registerAnimalParticle(bat1ParticleType,"bat_1", iParticleTypeRegisterEvent);
        registerAnimalParticle(bat2ParticleType,"bat_2", iParticleTypeRegisterEvent);
        registerAnimalParticle(batFlying1ParticleType,"bat_flying_1", iParticleTypeRegisterEvent);
        registerAnimalParticle(batFlying2ParticleType,"bat_flying_2", iParticleTypeRegisterEvent);
        registerAnimalParticle(batFlying3ParticleType,"bat_flying_3", iParticleTypeRegisterEvent);
        registerAnimalParticle(batFlying4ParticleType,"bat_flying_4", iParticleTypeRegisterEvent);

        registerAnimalParticle(bluejay1ParticleType,"bluejay_1", iParticleTypeRegisterEvent);
        registerAnimalParticle(bluejay2ParticleType,"bluejay_2", iParticleTypeRegisterEvent);
        registerAnimalParticle(bluejay3ParticleType,"bluejay_3", iParticleTypeRegisterEvent);
        registerAnimalParticle(bluejay4ParticleType,"bluejay_4", iParticleTypeRegisterEvent);
        registerAnimalParticle(bluejayFlying1ParticleType,"bluejay_flying_1", iParticleTypeRegisterEvent);
        registerAnimalParticle(bluejayFlying2ParticleType,"bluejay_flying_2", iParticleTypeRegisterEvent);
        registerAnimalParticle(bluejayFlying3ParticleType,"bluejay_flying_3", iParticleTypeRegisterEvent);
        registerAnimalParticle(bluejayFlying4ParticleType,"bluejay_flying_4", iParticleTypeRegisterEvent);

        registerAnimalParticle(duck1ParticleType,"duck_1", iParticleTypeRegisterEvent);
        registerAnimalParticle(duck2ParticleType,"duck_2", iParticleTypeRegisterEvent);
        registerAnimalParticle(duck3ParticleType,"duck_3", iParticleTypeRegisterEvent);
        registerAnimalParticle(duck4ParticleType,"duck_4", iParticleTypeRegisterEvent);
        registerAnimalParticle(duckFlying1ParticleType,"duck_flying_1", iParticleTypeRegisterEvent);
        registerAnimalParticle(duckFlying2ParticleType,"duck_flying_2", iParticleTypeRegisterEvent);
        registerAnimalParticle(duckFlying3ParticleType,"duck_flying_3", iParticleTypeRegisterEvent);
        registerAnimalParticle(duckFlying4ParticleType,"duck_flying_4", iParticleTypeRegisterEvent);

        registerAnimalParticle(owl1ParticleType,"owl_1", iParticleTypeRegisterEvent);
        registerAnimalParticle(owl2ParticleType,"owl_2", iParticleTypeRegisterEvent);
        registerAnimalParticle(owl3ParticleType,"owl_3", iParticleTypeRegisterEvent);
        registerAnimalParticle(owl4ParticleType,"owl_4", iParticleTypeRegisterEvent);
        registerAnimalParticle(owlFlying1ParticleType,"owl_flying_1", iParticleTypeRegisterEvent);

        registerAnimalParticle(pigeon1ParticleType,"pigeon_1", iParticleTypeRegisterEvent);
        registerAnimalParticle(pigeon2ParticleType,"pigeon_2", iParticleTypeRegisterEvent);
        registerAnimalParticle(pigeon3ParticleType,"pigeon_3", iParticleTypeRegisterEvent);
        registerAnimalParticle(pigeon4ParticleType,"pigeon_4", iParticleTypeRegisterEvent);
        registerAnimalParticle(pigeonFlying1ParticleType,"pigeon_flying_1", iParticleTypeRegisterEvent);
        registerAnimalParticle(pigeonFlying2ParticleType,"pigeon_flying_2", iParticleTypeRegisterEvent);
        registerAnimalParticle(pigeonFlying3ParticleType,"pigeon_flying_3", iParticleTypeRegisterEvent);
        registerAnimalParticle(pigeonFlying4ParticleType,"pigeon_flying_4", iParticleTypeRegisterEvent);

        registerAnimalParticle(seagull1ParticleType,"seagull_1", iParticleTypeRegisterEvent);
        registerAnimalParticle(seagull2ParticleType,"seagull_2", iParticleTypeRegisterEvent);
        registerAnimalParticle(seagull3ParticleType,"seagull_3", iParticleTypeRegisterEvent);
        registerAnimalParticle(seagull4ParticleType,"seagull_4", iParticleTypeRegisterEvent);
        registerAnimalParticle(seagullFlying1ParticleType,"seagull_flying_1", iParticleTypeRegisterEvent);
        registerAnimalParticle(seagullFlying2ParticleType,"seagull_flying_2", iParticleTypeRegisterEvent);
        registerAnimalParticle(seagullFlying3ParticleType,"seagull_flying_3", iParticleTypeRegisterEvent);
        registerAnimalParticle(seagullFlying4ParticleType,"seagull_flying_4", iParticleTypeRegisterEvent);

        registerAnimalParticle(puffin1ParticleType,"puffin_1", iParticleTypeRegisterEvent);
        registerAnimalParticle(puffinFlying1ParticleType,"puffin_flying_1", iParticleTypeRegisterEvent);

        registerAnimalParticle(toad1ParticleType,"toad_1", iParticleTypeRegisterEvent);
        registerAnimalParticle(toad2ParticleType,"toad_2", iParticleTypeRegisterEvent);
        registerAnimalParticle(toad3ParticleType,"toad_3", iParticleTypeRegisterEvent);
        registerAnimalParticle(toad4ParticleType,"toad_4", iParticleTypeRegisterEvent);

        registerAnimalParticle(rat1ParticleType,"rat_1", iParticleTypeRegisterEvent);
        registerAnimalParticle(rat2ParticleType,"rat_2", iParticleTypeRegisterEvent);
        registerAnimalParticle(rat3ParticleType,"rat_3", iParticleTypeRegisterEvent);
        registerAnimalParticle(rat4ParticleType,"rat_4", iParticleTypeRegisterEvent);
    }

    private static void registerAnimalParticle (ParticleType<AnimalParticleData> animal, String regisryName, RegistryEvent.Register<ParticleType<?>> iParticleTypeRegisterEvent) {
        animal.setRegistryName("conquest:" + regisryName);
        iParticleTypeRegisterEvent.getRegistry().register(animal);
    }
}
