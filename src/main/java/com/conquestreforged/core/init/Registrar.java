package com.conquestreforged.core.init;

import com.conquestreforged.core.block.data.BlockData;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class Registrar {

    public static <V extends IForgeRegistryEntry<V>> void register(BlockData data, V v, IForgeRegistry<V> registry) {
        try {
            registry.register(v);
        } catch (Throwable t) {
            String type = registry.getRegistrySuperType().getSimpleName();
            String blockType = data.getBlock().getClass().getName();
            String blockName = data.getBlock().getRegistryName() + "";
            String itemType = data.getItem().getClass().getName();
            String itemName = data.getItem().getRegistryName() + "";
            String message = type + "(" + blockType + "[" + blockName + "] / " + itemType + "[" + itemName + "]) ";
            throw new RegistrationException(message, t);
        }
    }

    private static class RegistrationException extends RuntimeException {

        private RegistrationException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
