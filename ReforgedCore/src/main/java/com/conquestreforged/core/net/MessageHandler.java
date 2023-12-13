package com.conquestreforged.core.net;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public interface MessageHandler<T> {

    T decode(PacketBuffer buffer);

    void encode(T message, PacketBuffer buffer);

    void handle(T message, Supplier<NetworkEvent.Context> context);
}
