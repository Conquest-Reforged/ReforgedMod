package com.conquestreforged.core.item.group.manager;

import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class DelegateGroup extends ItemGroup {

    private final ItemGroup group;

    DelegateGroup(ItemGroup group) {
        super(-1, group.getTabLabel());
        this.group = group;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public String getTabLabel() {
        return group.getTabLabel();
    }

    @Override
    public String getPath() {
        return group.getPath();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public String getTranslationKey() {
        return group.getTranslationKey();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public ItemStack getIcon() {
        return group.getIcon();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public ItemStack createIcon() {
        return group.createIcon();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public String getBackgroundImageName() {
        return group.getBackgroundImageName();
    }

    @Override
    public ItemGroup setBackgroundImageName(String texture) {
        return group.setBackgroundImageName(texture);
    }

    @Override
    public ItemGroup setTabPath(String pathIn) {
        return group.setTabPath(pathIn);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean drawInForegroundOfTab() {
        return group.drawInForegroundOfTab();
    }

    @Override
    public ItemGroup setNoTitle() {
        return group.setNoTitle();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean hasScrollbar() {
        return group.hasScrollbar();
    }

    @Override
    public ItemGroup setNoScrollbar() {
        return group.setNoScrollbar();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public int getColumn() {
        return super.getColumn();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean isOnTopRow() {
        return super.isOnTopRow();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean isAlignedRight() {
        return super.isAlignedRight();
    }

    @Override
    public EnchantmentType[] getRelevantEnchantmentTypes() {
        return group.getRelevantEnchantmentTypes();
    }

    @Override
    public ItemGroup setRelevantEnchantmentTypes(EnchantmentType... types) {
        return group.setRelevantEnchantmentTypes(types);
    }

    @Override
    public boolean hasRelevantEnchantmentType(@Nullable EnchantmentType enchantmentType) {
        return group.hasRelevantEnchantmentType(enchantmentType);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void fill(NonNullList<ItemStack> items) {
        if (group == ItemGroup.HOTBAR) {
            return;
        }
        group.fill(items);
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
