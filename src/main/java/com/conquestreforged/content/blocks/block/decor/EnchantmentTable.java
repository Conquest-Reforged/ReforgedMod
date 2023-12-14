package com.conquestreforged.content.blocks.block.decor;

import com.conquestreforged.content.blocks.tileentity.TileEntityTypes;
import com.conquestreforged.content.blocks.tileentity.enchantment.ModdedEnchantingTableMenu;
import com.conquestreforged.content.blocks.tileentity.enchantment.ModdedEnchantingTableTileEntity;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.block.EnchantingTableBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.Nameable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


@Render(RenderLayer.CUTOUT)
public class EnchantmentTable extends EnchantingTableBlock {

    public EnchantmentTable(Settings properties) {
        super(properties);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos blockPos, BlockState state) {
        return new ModdedEnchantingTableTileEntity(blockPos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World p_153182_, BlockState p_153183_, BlockEntityType<T> p_153184_) {
        return p_153182_.isClient ? checkType(p_153184_, TileEntityTypes.ENCHANTING_TABLE, ModdedEnchantingTableTileEntity::bookAnimationTick) : null;
    }

    @Override
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World worldIn, BlockPos pos) {
        BlockEntity tileentity = worldIn.getBlockEntity(pos);
        if (tileentity instanceof ModdedEnchantingTableTileEntity) {
            Text itextcomponent = ((Nameable) tileentity).getDisplayName();
            return new SimpleNamedScreenHandlerFactory((p_220147_2_, p_220147_3_, p_220147_4_) -> new ModdedEnchantingTableMenu(p_220147_2_, p_220147_3_, ScreenHandlerContext.create(worldIn, pos)), itextcomponent);
        } else {
            return null;
        }
    }

    @Override
    public void onPlaced(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        if (stack.hasCustomName()) {
            BlockEntity tileentity = worldIn.getBlockEntity(pos);
            if (tileentity instanceof ModdedEnchantingTableTileEntity) {
                ((ModdedEnchantingTableTileEntity) tileentity).setCustomName(stack.getName());
            }
        }
    }
}
