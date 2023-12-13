package com.conquestreforged.core.capability.toggle;

import com.conquestreforged.core.capability.Capabilities;
import com.conquestreforged.core.capability.handler.LoggableCapHandler;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class ToggleHandler extends LoggableCapHandler<Toggle> {

    public ToggleHandler() {
        super(Toggle.PROTOCOL_NAME);
    }

    @Override
    public INBT writeNBT(Capability<Toggle> capability, Toggle instance, Direction side) {
        trace("Writing toggle data to nbt: index={}", instance.getIndex());
        CompoundNBT tag = new CompoundNBT();
        tag.putInt("index", instance.getIndex());
        return tag;
    }

    @Override
    public void readNBT(Capability<Toggle> capability, Toggle instance, Direction side, INBT nbt) {
        CompoundNBT tag = (CompoundNBT) nbt;
        instance.setIndex(tag.getInt("index"));
        trace("Reading toggle data from nbt: index={}", instance.getIndex());
    }

    @Override
    public Toggle decode(PacketBuffer buffer) {
        trace("Decoding toggle packet");
        return new Toggle(buffer.readInt());
    }

    @Override
    public void encode(Toggle message, PacketBuffer buffer) {
        trace("Encoding toggle packet: index={}", message.getIndex());
        buffer.writeInt(message.getIndex());
    }

    @Override
    public void handle(Toggle message, Supplier<NetworkEvent.Context> context) {
        trace("Handling toggle message: index={}", message.getIndex());
        context.get().enqueueWork(() -> {
            if (context.get() == null || context.get().getSender() == null) {
                return;
            }

            ServerPlayerEntity player = context.get().getSender();
            if (player == null) {
                return;
            }

            player.getCapability(Capabilities.TOGGLE).ifPresent(toggle -> {
                // update the server-side player entity with the client's toggle state ?
                // where does this get written to disk ?
                toggle.setIndex(message.getIndex());
            });

            context.get().setPacketHandled(true);
        });
    }
}
