package com.conquestreforged.core.capability.handler;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.common.capabilities.Capability;

/**
 * Like Handler but encodes/decodes the network packets to/from nbt
 * using the Handler's write/read methods
 */
public interface NBTHandler<T> extends CapabilityHandler<T> {

    T create();

    Capability<T> getCapability();

    @Override
    default T decode(FriendlyByteBuf buffer) {
        T value = create();
        CompoundTag root = buffer.readNbt();
        readNBT(getCapability(), value, null, root);
        return value;
    }

    @Override
    default void encode(T message, FriendlyByteBuf buffer) {
        CompoundTag root = new CompoundTag();
        writeNBT(getCapability(), message, null);
        buffer.writeNbt(root);
    }
}
