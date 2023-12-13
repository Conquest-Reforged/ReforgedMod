package com.conquestreforged.blocks.block.tech;

import com.conquestreforged.blocks.tileentity.TileEntityTypes;
import com.conquestreforged.blocks.tileentity.furnace.ModdedFurnaceTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class Furnace extends FurnaceBlock {

    public Furnace(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ModdedFurnaceTileEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return createFurnaceTicker(level, blockEntityType, TileEntityTypes.FURNACE);
    }

    @Override
    protected void openContainer(Level worldIn, BlockPos pos, Player player) {
        BlockEntity tileentity = worldIn.getBlockEntity(pos);
        if (tileentity instanceof ModdedFurnaceTileEntity) {
            player.openMenu((MenuProvider)tileentity);
            player.awardStat(Stats.INTERACT_WITH_FURNACE);
        }

    }
}
