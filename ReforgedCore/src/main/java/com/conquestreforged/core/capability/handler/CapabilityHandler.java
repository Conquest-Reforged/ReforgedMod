package com.conquestreforged.core.capability.handler;

import com.conquestreforged.core.net.MessageHandler;
import net.minecraftforge.common.capabilities.Capability;

public interface CapabilityHandler<T> extends Capability.IStorage<T>, MessageHandler<T> {

}
