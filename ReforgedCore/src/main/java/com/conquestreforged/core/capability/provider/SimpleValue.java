package com.conquestreforged.core.capability.provider;

import com.conquestreforged.core.init.Context;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.function.Supplier;

public class SimpleValue<V> implements Value<V> {

    private final V value;
    private final ResourceLocation name;
    private final Capability<V> capability;
    private final LazyOptional<V> optional;

    public SimpleValue(ResourceLocation name, Capability<V> capability) {
        this.name = name;
        this.capability = capability;
        this.value = capability.getDefaultInstance();
        this.optional = LazyOptional.of(this::getValue);
    }

    @Nonnull
    @Override
    public V getValue() {
        return value;
    }

    @Override
    public Capability<V> getCapability() {
        return capability;
    }

    @Override
    public ResourceLocation getRegistryName() {
        return name;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return capability.orEmpty(cap, optional);
    }

    public static <T> ValueFactory<T> factory(String name, Supplier<Capability<T>> capability) {
        ResourceLocation registryName = Context.getInstance().newResourceLocation(name);
        return () -> new SimpleValue<>(registryName, capability.get());
    }
}
