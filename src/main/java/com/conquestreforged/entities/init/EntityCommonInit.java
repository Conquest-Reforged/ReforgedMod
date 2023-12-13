package com.conquestreforged.entities.init;

import com.conquestreforged.entities.EntityTypes;
import com.conquestreforged.entities.painting.ModPainting;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.stream.IntStream;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityCommonInit {

    @SubscribeEvent
    public static void entities(RegistryEvent.Register<EntityType<?>> event) {
        registerPaintings(event.getRegistry());

        event.getRegistry().register(EntityTypes.SEAT);
    }

    private static void registerPaintings(IForgeRegistry<EntityType<?>> registry) {
        IntStream.range(0, 10).forEach(i -> ModPainting.register("painting" + i));
        registry.register(EntityTypes.PAINTING);
    }
}
