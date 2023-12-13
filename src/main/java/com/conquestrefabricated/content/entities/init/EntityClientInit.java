package com.conquestrefabricated.content.entities.init;

import com.conquestrefabricated.content.entities.EntityTypes;
import com.conquestrefabricated.content.entities.painting.render.PaintingRenderer;
import com.conquestrefabricated.content.entities.seat.SeatRenderer;
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
