package com.conquestrefabricated.content.entities.init;

import com.conquestrefabricated.content.entities.EntityTypes;
import com.conquestrefabricated.content.entities.painting.ModPainting;
import net.minecraft.util.registry.Registry;

import java.util.stream.IntStream;

public class EntityCommonInit {

    //@SubscribeEvent
    public static void entities() {
        registerPaintings();
    }

    private static void registerPaintings() {
        IntStream.range(0, 10).forEach(i -> ModPainting.register("painting" + i));
        EntityTypes.entityTypesInit();
        Registry.register(Registry.ENTITY_TYPE, "conquest:painting", EntityTypes.PAINTING);
        Registry.register(Registry.ENTITY_TYPE, "conquest:seat", EntityTypes.SEAT);
    }
}
