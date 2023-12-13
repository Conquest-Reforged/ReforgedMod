package com.conquestreforged.core.client.render;

import com.conquestreforged.core.util.RenderLayer;
import com.conquestreforged.core.util.log.Log;
import net.minecraft.world.level.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.world.level.material.Fluid;

// MUST ONLY BE USED ON THE CLIENT
public class RenderLayerHelper {

    public static void register(Block block, RenderLayer layer) {
        if (layer != RenderLayer.SOLID && layer != RenderLayer.UNDEFINED) {
            RenderType type = getType(layer);
            if (type == null) {
                return;
            }
            ItemBlockRenderTypes.setRenderLayer(block, type);
            Log.debug("Registered render type for Block: {}={}", block.getRegistryName(), type);
        }
    }

    public static void register(Fluid fluid, RenderLayer layer) {
        if (layer != RenderLayer.SOLID && layer != RenderLayer.UNDEFINED) {
            RenderType type = getType(layer);
            if (type == null) {
                return;
            }
            ItemBlockRenderTypes.setRenderLayer(fluid, type);
            Log.debug("Registered render type for Fluid: {}={}", fluid.getRegistryName(), type);
        }
    }

    private static RenderType getType(RenderLayer layer) {
        switch (layer) {
            case SOLID:
                return RenderType.solid();
            case CUTOUT:
                return RenderType.cutout();
            case TRANSLUCENT:
                return RenderType.translucent();
            case CUTOUT_MIPPED:
                return RenderType.cutoutMipped();
        }
        return null;
    }
}
