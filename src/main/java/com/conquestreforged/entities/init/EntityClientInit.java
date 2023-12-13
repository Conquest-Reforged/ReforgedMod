package com.conquestreforged.entities.init;

import com.conquestreforged.entities.EntityTypes;
import com.conquestreforged.entities.painting.render.PaintingRenderer;
import com.conquestreforged.entities.painting.render.VanillaPaintingRenderer;
import com.conquestreforged.entities.seat.SeatRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityClientInit {

    @SubscribeEvent
    public static void setup(EntityRenderersEvent.RegisterRenderers event) {
        // custom vanilla painting renderer to allow cut-out rendering
        event.registerEntityRenderer(EntityType.PAINTING, VanillaPaintingRenderer::new);
        // conquest renderers
        event.registerEntityRenderer(EntityTypes.PAINTING, PaintingRenderer::new);
        event.registerEntityRenderer(EntityTypes.SEAT, SeatRenderer::new);
    }
}
