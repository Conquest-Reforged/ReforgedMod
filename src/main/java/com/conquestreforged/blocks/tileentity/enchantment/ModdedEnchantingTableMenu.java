package com.conquestreforged.blocks.tileentity.enchantment;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.EnchantmentMenu;
import net.minecraftforge.registries.ForgeRegistries;

public class ModdedEnchantingTableMenu extends EnchantmentMenu {
    private ContainerLevelAccess access;

    public ModdedEnchantingTableMenu(int p_39454_, Inventory p_39455_) {
        super(p_39454_, p_39455_);
    }

    public ModdedEnchantingTableMenu(int p_39457_, Inventory p_39458_, ContainerLevelAccess p_39459_) {
        super(p_39457_, p_39458_, p_39459_);
        this.access = p_39459_;
    }

    @Override
    public boolean stillValid(Player p_39463_) {
        return stillValid(this.access, p_39463_, ForgeRegistries.BLOCKS.getValue(new ResourceLocation("conquest:enchantment_table"))) ||
                stillValid(this.access, p_39463_, ForgeRegistries.BLOCKS.getValue(new ResourceLocation("conquest:floating_book")));
    }
}
