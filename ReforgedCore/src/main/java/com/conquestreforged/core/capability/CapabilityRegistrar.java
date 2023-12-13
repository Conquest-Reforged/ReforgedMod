package com.conquestreforged.core.capability;

import com.conquestreforged.core.capability.provider.Value;
import com.conquestreforged.core.capability.provider.ValueFactory;
import com.conquestreforged.core.util.log.Log;
import net.minecraft.entity.Entity;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CapabilityRegistrar {

    private static final Map<Class<?>, List<ValueFactory<?>>> cache = new HashMap<>();
    private static final Map<Class<?>, List<ValueFactory<?>>> factories = new HashMap<>();

    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        for (ValueFactory<?> factory : getCapabilities(event.getObject().getClass())) {
            Value<?> value = factory.create();
            event.addCapability(value.getRegistryName(), value);
            Log.debug("Adding capability: '{}' to: {}", value.getRegistryName(), event.getObject().getType());
        }
    }

    public static void register(Class<? extends ICapabilityProvider> holderType, ValueFactory<?> factory) {
        factories.computeIfAbsent(holderType, c -> new LinkedList<>()).add(factory);
    }

    private static synchronized <T extends ICapabilityProvider> List<ValueFactory<?>> getCapabilities(Class<T> holder) {
        return cache.computeIfAbsent(holder, CapabilityRegistrar::compute);
    }

    private static synchronized List<ValueFactory<?>> compute(Class<?> type) {
        List<ValueFactory<?>> list = new LinkedList<>();
        for (Map.Entry<Class<?>, List<ValueFactory<?>>> entry : factories.entrySet()) {
            if (entry.getKey().isAssignableFrom(type)) {
                list.addAll(entry.getValue());
            }
        }
        return list;
    }
}
