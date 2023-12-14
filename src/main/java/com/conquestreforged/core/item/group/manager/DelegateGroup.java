package com.conquestreforged.core.item.group.manager;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import org.jetbrains.annotations.Nullable;

public class DelegateGroup extends ItemGroup {

    private final ItemGroup group;

    DelegateGroup(int index, ItemGroup group) {
        super(index, group.getName());
        this.group = group;
    }

    @Override
    public String getName() {
        return group.getName();
    }

    @Override
    @Environment(EnvType.CLIENT)
    public Text getDisplayName() {
        return group.getDisplayName();
    }

    @Override
    @Environment(EnvType.CLIENT)
    public ItemStack getIcon() {
        return group.getIcon();
    }

    @Override
    @Environment(EnvType.CLIENT)

    public ItemStack createIcon() {
        return group.createIcon();
    }

    @Override
    @Environment(EnvType.CLIENT)
    public String getTexture() {
        return group.getTexture();
    }

    @Override
    public ItemGroup setTexture(String texture) {
        return group.setTexture(texture);
    }

    @Override
    public ItemGroup setName(String pathIn) {
        return group.setName(pathIn);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public boolean shouldRenderName() {
        return group.shouldRenderName();
    }

    @Override
    public ItemGroup hideName() {
        return group.hideName();
    }

    @Override
    @Environment(EnvType.CLIENT)
    public boolean hasScrollbar() {
        return group.hasScrollbar();
    }

    @Override
    public ItemGroup setNoScrollbar() {
        return group.setNoScrollbar();
    }

    @Override
    @Environment(EnvType.CLIENT)
    public int getColumn() {
        return super.getColumn();
    }

    @Override
    @Environment(EnvType.CLIENT)
    public boolean isTopRow() {
        return super.isTopRow();
    }

    @Override
    @Environment(EnvType.CLIENT)
    public boolean isSpecial() {
        return super.isSpecial();
    }

    @Override
    public EnchantmentTarget[] getEnchantments() {
        return group.getEnchantments();
    }

    @Override
    public ItemGroup setEnchantments(EnchantmentTarget... types) {
        return group.setEnchantments(types);
    }

    @Override
    public boolean containsEnchantments(@Nullable EnchantmentTarget enchantmentType) {
        return group.containsEnchantments(enchantmentType);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void appendStacks(DefaultedList<ItemStack> items) {
        if (group == ItemGroup.HOTBAR) {
            return;
        }
        group.appendStacks(items);
    }


/*
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
    @Environment(EnvType.CLIENT)
    public ResourceLocation getBackgroundImage() {
        return group.getBackgroundImage();
    }

    @Override
    @Environment(EnvType.CLIENT)
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
    }*/
}
