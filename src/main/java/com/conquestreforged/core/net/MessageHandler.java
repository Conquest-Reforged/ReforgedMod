package com.conquestreforged.core.net;

import net.minecraft.network.PacketByteBuf;

public interface MessageHandler<T> {

    T decode(PacketByteBuf buffer);

    void encode(T message, PacketByteBuf buffer);

  //  void handle(T message, Supplier<COntext> context);
}
