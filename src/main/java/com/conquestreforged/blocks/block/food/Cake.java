package com.conquestreforged.blocks.block.food;

import com.conquestreforged.core.block.properties.PropertyVariant;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.properties.Property;

public class Cake extends CakeBlock implements PropertyVariant {

    public Cake(Properties properties) {
        super(properties);
    }

    @Override
    public Property<?> getVariantProperty() {
        return CakeBlock.BITES;
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        PropertyVariant.fillGroup(this, items);
    }
}
