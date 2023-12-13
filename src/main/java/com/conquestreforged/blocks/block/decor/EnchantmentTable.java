package com.conquestreforged.blocks.block.decor;

import com.conquestreforged.blocks.tileentity.TileEntityTypes;
import com.conquestreforged.blocks.tileentity.enchantment.ModdedEnchantingTableMenu;
import com.conquestreforged.blocks.tileentity.enchantment.ModdedEnchantingTableTileEntity;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Nameable;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EnchantmentTableBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

@Render(RenderLayer.CUTOUT)
public class EnchantmentTable extends EnchantmentTableBlock {

    public EnchantmentTable(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState state) {
        return new ModdedEnchantingTableTileEntity(blockPos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_153182_, BlockState p_153183_, BlockEntityType<T> p_153184_) {
        return p_153182_.isClientSide ? createTickerHelper(p_153184_, TileEntityTypes.ENCHANTING_TABLE, ModdedEnchantingTableTileEntity::bookAnimationTick) : null;
    }

    @Override
    public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
        BlockEntity tileentity = worldIn.getBlockEntity(pos);
        if (tileentity instanceof ModdedEnchantingTableTileEntity) {
            Component itextcomponent = ((Nameable) tileentity).getDisplayName();
            return new SimpleMenuProvider((p_220147_2_, p_220147_3_, p_220147_4_) -> new ModdedEnchantingTableMenu(p_220147_2_, p_220147_3_, ContainerLevelAccess.create(worldIn, pos)), itextcomponent);
        } else {
            return null;
        }
    }

    @Override
    public void setPlacedBy(Level worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        if (stack.hasCustomHoverName()) {
            BlockEntity tileentity = worldIn.getBlockEntity(pos);
            if (tileentity instanceof ModdedEnchantingTableTileEntity) {
                ((ModdedEnchantingTableTileEntity) tileentity).setCustomName(stack.getHoverName());
            }
        }
    }
}
