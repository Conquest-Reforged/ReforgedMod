package com.conquestrefabricated.core.init;

import com.conquestrefabricated.core.block.data.BlockData;
import net.minecraft.util.registry.DefaultedRegistry;
import net.minecraft.util.registry.Registry;

public class Registrar {

    public static <V extends DefaultedRegistry<V>> void register(BlockData data, V v, DefaultedRegistry<V> registry) {
        try {
            Registry.register(registry, data.getRegistryName(), v);
        } catch (Throwable t) {
            /*
            String type = registry.getRegistrySuperType().getSimpleName();
            String blockType = data.getBlock().getClass().getName();
            String blockName = data.getBlock().getRegistryName() + "";
            String itemType = data.getItem().getClass().getName();
            String itemName = data.getItem().getRegistryName() + "";
            String message = type + "(" + blockType + "[" + blockName + "] / " + itemType + "[" + itemName + "]) ";
            throw new RegistrationException(message, t);*/
        }
    }

    private static class RegistrationException extends RuntimeException {

        private RegistrationException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
