package com.conquestreforged.blocks.tileentity.furnace;

import com.conquestreforged.blocks.tileentity.TileEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.FurnaceMenu;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModdedFurnaceTileEntity extends AbstractFurnaceBlockEntity {
    public ModdedFurnaceTileEntity(BlockPos pos, BlockState state) {
        super(TileEntityTypes.FURNACE, pos, state, RecipeType.SMELTING);
    }

    protected Component getDefaultName() {
        return new TranslatableComponent("container.furnace");
    }

    protected AbstractContainerMenu createMenu(int id, Inventory player) {
        return new FurnaceMenu(id, player, this, this.dataAccess);
    }
}
