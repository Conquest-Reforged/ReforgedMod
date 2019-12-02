package com.conquestreforged.core.capability.toggle;

import com.conquestreforged.core.util.Log;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class ToggleStorage implements IStorage<Toggle> {
    @Override
    public INBT writeNBT(Capability<Toggle> capability, Toggle instance, Direction side) {
        Log.debug("Writing toggle data to nbt: index={}", instance.getIndex());
        CompoundNBT tag = new CompoundNBT();
        tag.putInt("toggle", instance.getIndex());
        return tag;
    }

    @Override
    public void readNBT(Capability<Toggle> capability, Toggle instance, Direction side, INBT nbt) {
        CompoundNBT tag = (CompoundNBT) nbt;
        instance.setIndex(tag.getInt("toggle"));
        Log.debug("Reading toggle data from nbt: index={}", instance.getIndex());
    }
}
