package com.conquestreforged.core.capability.provider;

import com.google.common.base.Preconditions;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.NonNullSupplier;

import javax.annotation.Nonnull;

public interface Value<T> extends ICapabilitySerializable<Tag> {

    @Nonnull
    T getValue();

    Capability<T> getCapability();

    ResourceLocation getRegistryName();

    @Override
    default Tag serializeNBT() {
        return getCapability().getStorage().writeNBT(getCapability(), getValue(), null);
    }

    @Override
    default void deserializeNBT(Tag nbt) {
        getCapability().getStorage().readNBT(getCapability(), getValue(), null, nbt);
    }

    static <T> NonNullSupplier<T> supply(Capability<T> capability) {
        return () -> {
            T t = capability.getDefaultInstance();
            Preconditions.checkNotNull(t);
            return t;
        };
    }
}
