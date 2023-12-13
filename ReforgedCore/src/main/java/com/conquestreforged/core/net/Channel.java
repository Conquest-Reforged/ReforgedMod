package com.conquestreforged.core.net;

import com.conquestreforged.core.capability.CapabilityRegistrar;
import com.conquestreforged.core.capability.handler.CapabilityHandler;
import com.conquestreforged.core.capability.provider.SimpleValue;
import com.conquestreforged.core.capability.provider.ValueFactory;
import com.conquestreforged.core.init.Context;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IWorld;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.simple.SimpleChannel;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Channel {

    private final ResourceLocation name;
    private final SimpleChannel channel;
    private final AtomicInteger counter = new AtomicInteger(-1);

    private Channel(ResourceLocation name, String protocol) {
        this.name = name;
        this.channel = NetworkRegistry.newSimpleChannel(name, () -> protocol, protocol::equals, protocol::equals);
    }

    // register a network message to this channel
    public <T> Channel register(Class<T> message, Encoder<T> encoder, Decoder<T> decoder, Consumer<T> handler) {
        return register(message, encoder, decoder, wrap(handler));
    }

    // register a network message to this channel
    public <T> Channel register(Class<T> message, Encoder<T> encoder, Decoder<T> decoder, Handler<T> handler) {
        return register(message, encoder, decoder, wrap(handler));
    }

    // register a network message to this channel
    public <T> Channel register(Class<T> message, Encoder<T> encoder, Decoder<T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> handler) {
        channel.registerMessage(counter.addAndGet(1), message, encoder, decoder, handler);
        return this;
    }

    // register a capability through this channel
    public <T> Channel register(Class<? extends ICapabilityProvider> holder, Class<T> type, Supplier<Capability<T>> capability, CapabilityHandler<T> handler) {
        return register(name.getPath(), holder, type, capability, handler);
    }

    // register a capability through this channel
    public <T> Channel register(String name, Class<? extends ICapabilityProvider> holder, Class<T> type, Supplier<Capability<T>> capability, CapabilityHandler<T> handler) {
        return register(holder, type, SimpleValue.factory(name, capability), handler);
    }

    // register a capability through this channel
    public <T> Channel register(Class<? extends ICapabilityProvider> holder, Class<T> type, ValueFactory<T> factory, CapabilityHandler<T> handler) {
        return register(holder, type, factory, handler, handler);
    }

    public <T> Channel register(Class<? extends ICapabilityProvider> holder, Class<T> type, ValueFactory<T> factory, Capability.IStorage<T> storage, MessageHandler<T> handler) {
        // register the capability
        CapabilityManager.INSTANCE.register(type, storage, type::newInstance);
        // register the provider factories to the holder type
        CapabilityRegistrar.register(holder, factory);
        // create a channel message for networking
        return register(type, handler::encode, handler::decode, handler::handle);
    }

    // send a server -> client to the given player
    public <T> void send(PlayerEntity player, T message) {
        if (player instanceof ServerPlayerEntity) {
            send((ServerPlayerEntity) player, message);
        }
    }

    // send a server -> client to the given player
    public <T> void send(ServerPlayerEntity player, T message) {
        send(PacketDistributor.PLAYER.with(() -> player), message);
    }

    // send a server -> client message to all players
    public <T> void sendAll(T message) {
        send(PacketDistributor.ALL.with(() -> null), message);
    }

    // send a server -> client message to all players in the given world
    public <T> void send(IWorld world, T message) {
        send(world.getDimension(), message);
    }

    // send a server -> client message to all players in the given dimension
    public <T> void send(Dimension dimension, T message) {
        send(dimension.getType(), message);
    }

    // send a server -> client message to all players in the given dimension
    public <T> void send(DimensionType dimension, T message) {
        send(PacketDistributor.DIMENSION.with(() -> dimension), message);
    }

    // send a message to the given packet target - may be in either direction depending on the target type
    public <T> void send(PacketDistributor.PacketTarget target, T message) {
        channel.send(target, message);
    }

    // send a client -> server message
    public <T> void sendToServer(T message) {
        channel.sendToServer(message);
    }

    public static Channel create(String name, String protocol) {
        return create(Context.getInstance().newResourceLocation(name), protocol);
    }

    public static Channel create(String namespace, String name, String protocol) {
        return create(new ResourceLocation(namespace, name), protocol);
    }

    public static Channel create(ResourceLocation name, String protocol) {
        return new Channel(name, protocol);
    }

    private static <T> BiConsumer<T, Supplier<NetworkEvent.Context>> wrap(Consumer<T> handler) {
        return (t, context) -> {
            final NetworkEvent.Context ctx = context.get();
            ctx.enqueueWork(() -> handler.accept(t));
            ctx.setPacketHandled(true);
        };
    }

    private static <T> BiConsumer<T, Supplier<NetworkEvent.Context>> wrap(Handler<T> handler) {
        return (t, context) -> {
            final NetworkEvent.Context ctx = context.get();
            ctx.enqueueWork(() -> handler.accept(t, ctx));
            ctx.setPacketHandled(true);
        };
    }

    public interface Handler<T> extends BiConsumer<T, NetworkEvent.Context> {

    }

    public interface Encoder<T> extends BiConsumer<T, PacketBuffer> {

    }

    public interface Decoder<T> extends Function<PacketBuffer, T> {

    }
}
