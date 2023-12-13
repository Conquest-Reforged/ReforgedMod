package com.conquestrefabricated.content.entities.mixin;


import com.conquestrefabricated.content.entities.painting.render.VanillaPaintingRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.EntityRenderers;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(value = EntityRenderers.class)
public abstract class EntityRenderersMixin {

    @Shadow @Final private static Map<EntityType<?>, EntityRendererFactory<?>> RENDERER_FACTORIES;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void injected(CallbackInfo ci) {
        register(VanillaPaintingRenderer::new);
    }

    private static <T extends Entity> void register(EntityRendererFactory<T> aNew) {
        RENDERER_FACTORIES.put(EntityType.PAINTING, aNew);
    }
}
