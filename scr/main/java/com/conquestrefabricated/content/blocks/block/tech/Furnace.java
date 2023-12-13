package com.conquestrefabricated.content.blocks.block.tech;

import com.conquestrefabricated.content.blocks.tileentity.TileEntityTypes;
import com.conquestrefabricated.content.blocks.tileentity.furnace.ModdedFurnaceTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.stat.Stats;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class Furnace extends FurnaceBlock {

    public Furnace(Settings properties) {
        super(properties);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ModdedFurnaceTileEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return checkType(level, blockEntityType, TileEntityTypes.FURNACE);
    }

    @Override
    protected void openScreen(World worldIn, BlockPos pos, PlayerEntity player) {
        BlockEntity tileentity = worldIn.getBlockEntity(pos);
        if (tileentity instanceof ModdedFurnaceTileEntity) {
            player.openHandledScreen((NamedScreenHandlerFactory)tileentity);
            player.incrementStat(Stats.INTERACT_WITH_FURNACE);
        }

    }
}
