package com.conquestreforged.content.entities.init;

import com.conquestreforged.content.entities.EntityTypes;
import com.conquestreforged.content.entities.painting.render.PaintingRenderer;
import com.conquestreforged.content.entities.seat.SeatRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;


@Environment(EnvType.CLIENT)
public class EntityClientInit {

    //@SubscribeEvent
    public static void setup() {

        //EntityRendererRegistry.register(EntityType.PAINTING, VanillaPaintingRenderer::new);
        //custom vanilla painting renderer to allow cut-out rendering
        // conquest renderers
        EntityRendererRegistry.register(EntityTypes.PAINTING, PaintingRenderer::new);
        EntityRendererRegistry.register(EntityTypes.SEAT, SeatRenderer::new);
    }
}
