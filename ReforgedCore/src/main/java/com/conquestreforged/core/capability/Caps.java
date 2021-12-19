package com.conquestreforged.core.capability;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.NonNullFunction;
import net.minecraftforge.common.util.NonNullSupplier;

import javax.annotation.Nullable;
import java.util.function.Supplier;

/**
 * Helper functions for retrieving capabilities
 */
public class Caps {

    /**
     * Get the capability value from the World in the given context
     */
    public static <C, V> V forWorld(UseOnContext context, Capability<C> capability, NonNullFunction<C, V> getter, V def) {
        return get(context.getLevel(), capability, getter, def);
    }

    /**
     * Get the capability value from the Player in the given context
     */
    public static <C, V> V forPlayer(UseOnContext context, Capability<C> capability, NonNullFunction<C, V> getter, V def) {
        return get(context.getPlayer(), capability, getter, def);
    }

    /**
     * Get the capability value from the Item in the given context
     */
    public static <C, V> V forItem(UseOnContext context, Capability<C> capability, NonNullFunction<C, V> getter, V def) {
        return get(context.getItemInHand(), capability, getter, def);
    }

    /**
     * Get the capability value from the holder, returning the default value if non-existent
     */
    public static <C, V> V get(@Nullable ICapabilityProvider provider, Capability<C> capability, NonNullFunction<C, V> getter, V def) {
        if (provider == null) {
            return def;
        }
        return provider.getCapability(capability).map(getter).orElse(def);
    }

    /**
     * Get the capability value from the holder, returning the default value if non-existent
     */
    public static <C, V> V get(@Nullable ICapabilityProvider provider, Capability<C> capability, NonNullFunction<C, V> getter, NonNullSupplier<V> def) {
        if (provider == null) {
            return def.get();
        }
        //i dont even know what casting this does lol
        return provider.getCapability(capability).map(getter).orElseGet((Supplier<? extends V>) def);
    }
}
