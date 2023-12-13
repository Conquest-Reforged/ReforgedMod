package com.conquestreforged.core.item.group.manager;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class DelegateGroup extends CreativeModeTab {

    private final CreativeModeTab group;

    DelegateGroup(CreativeModeTab group) {
        super(-1, group.getRecipeFolderName());
        this.group = group;
    }

    @Override
    public String getRecipeFolderName() {
        return group.getRecipeFolderName();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public Component getDisplayName() {
        return group.getDisplayName();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public ItemStack getIconItem() {
        return group.getIconItem();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public ItemStack makeIcon() {
        return group.makeIcon();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public String getBackgroundSuffix() {
        return group.getBackgroundSuffix();
    }

    @Override
    public CreativeModeTab setBackgroundSuffix(String texture) {
        return group.setBackgroundSuffix(texture);
    }

    @Override
    public CreativeModeTab setRecipeFolderName(String pathIn) {
        return group.setRecipeFolderName(pathIn);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean showTitle() {
        return group.showTitle();
    }

    @Override
    public CreativeModeTab hideTitle() {
        return group.hideTitle();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean canScroll() {
        return group.canScroll();
    }

    @Override
    public CreativeModeTab hideScroll() {
        return group.hideScroll();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public int getColumn() {
        return super.getColumn();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean isTopRow() {
        return super.isTopRow();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean isAlignedRight() {
        return super.isAlignedRight();
    }

    @Override
    public EnchantmentCategory[] getEnchantmentCategories() {
        return group.getEnchantmentCategories();
    }

    @Override
    public CreativeModeTab setEnchantmentCategories(EnchantmentCategory... types) {
        return group.setEnchantmentCategories(types);
    }

    @Override
    public boolean hasEnchantmentCategory(@Nullable EnchantmentCategory enchantmentType) {
        return group.hasEnchantmentCategory(enchantmentType);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void fillItemList(NonNullList<ItemStack> items) {
        if (group == CreativeModeTab.TAB_HOTBAR) {
            return;
        }
        group.fillItemList(items);
    }

    @Override
    public int getTabPage() {
        return super.getTabPage();
    }

    @Override
    public boolean hasSearchBar() {
        return group.hasSearchBar();
    }

    @Override
    public int getSearchbarWidth() {
        return group.getSearchbarWidth();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getBackgroundImage() {
        return group.getBackgroundImage();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getTabsImage() {
        return group.getTabsImage();
    }

    @Override
    public int getLabelColor() {
        return group.getLabelColor();
    }

    @Override
    public int getSlotColor() {
        return group.getSlotColor();
    }
}
