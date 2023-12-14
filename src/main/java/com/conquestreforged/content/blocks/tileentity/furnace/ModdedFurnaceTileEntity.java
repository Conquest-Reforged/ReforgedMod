package com.conquestreforged.content.blocks.tileentity.furnace;

import com.conquestreforged.content.blocks.tileentity.TileEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.FurnaceScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class ModdedFurnaceTileEntity extends AbstractFurnaceBlockEntity {
    public ModdedFurnaceTileEntity(BlockPos pos, BlockState state) {
        super(TileEntityTypes.FURNACE, pos, state, RecipeType.SMELTING);
    }

    protected Text getContainerName() {
        return Text.translatable("container.furnace");
    }

    protected ScreenHandler createScreenHandler(int id, PlayerInventory player) {
        return new FurnaceScreenHandler(id, player, this, this.propertyDelegate);
    }
}
