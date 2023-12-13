package com.conquestrefabricated.content.blocks.tileentity.enchantment;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.EnchantmentScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModdedEnchantingTableMenu extends EnchantmentScreenHandler {
    private ScreenHandlerContext access;

    public ModdedEnchantingTableMenu(int p_39454_, PlayerInventory p_39455_) {
        super(p_39454_, p_39455_);
    }

    public ModdedEnchantingTableMenu(int p_39457_, PlayerInventory p_39458_, ScreenHandlerContext p_39459_) {
        super(p_39457_, p_39458_, p_39459_);
        this.access = p_39459_;
    }

    @Override
    public boolean canUse(PlayerEntity p_39463_) {
        return canUse(this.access, p_39463_, Registry.BLOCK
                .get(new Identifier("conquest:enchantment_table"))) ||
                canUse(this.access, p_39463_, Registry.BLOCK.get(new Identifier("conquest:floating_book")));
    }
}
