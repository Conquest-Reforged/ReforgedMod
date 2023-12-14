package com.conquestreforged.core.client.render;

import com.conquestreforged.core.util.RenderLayer;
import com.conquestreforged.core.util.log.Log;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.registry.Registry;

// MUST ONLY BE USED ON THE CLIENT
@Environment(EnvType.CLIENT)
public class RenderLayerHelper {

    public static void register(Block block, RenderLayer layer) {
        if (layer != RenderLayer.SOLID && layer != RenderLayer.UNDEFINED) {
            net.minecraft.client.render.RenderLayer type = getType(layer);
            if (type == null) {
                return;
            }
            BlockRenderLayerMap.INSTANCE.putBlock(block, type);
            Log.debug("Registered render type for Block: {}={}", Registry.BLOCK.getId(block), type);
        }
    }

    public static void register(Fluid fluid, RenderLayer layer) {
        if (layer != RenderLayer.SOLID && layer != RenderLayer.UNDEFINED) {
            net.minecraft.client.render.RenderLayer type = getType(layer);
            if (type == null) {
                return;
            }
            BlockRenderLayerMap.INSTANCE.putFluid(fluid, type);
            Log.debug("Registered render type for Fluid: {}={}", Registry.FLUID.getId(fluid), type);
        }
    }

    private static net.minecraft.client.render.RenderLayer getType(RenderLayer layer) {
        switch (layer) {
            case SOLID:
                return net.minecraft.client.render.RenderLayer.getSolid();
            case CUTOUT:
                return net.minecraft.client.render.RenderLayer.getCutout();
            case TRANSLUCENT:
                return net.minecraft.client.render.RenderLayer.getTranslucent();
            case CUTOUT_MIPPED:
                return net.minecraft.client.render.RenderLayer.getCutoutMipped();
        }
        return null;
    }
}
