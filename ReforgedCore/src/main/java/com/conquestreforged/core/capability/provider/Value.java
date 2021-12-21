package com.conquestreforged.core.capability.provider;

import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;

public interface Value<T> extends ICapabilitySerializable<Tag> {

    @Nonnull
    T getValue();

    Capability<T> getCapability();

    ResourceLocation getRegistryName();

}
