package com.conquestreforged.core.net;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fmllegacy.network.NetworkEvent;

import java.util.function.Supplier;

public interface MessageHandler<T> {

    T decode(FriendlyByteBuf buffer);

    void encode(T message, FriendlyByteBuf buffer);

    void handle(T message, Supplier<NetworkEvent.Context> context);
}
