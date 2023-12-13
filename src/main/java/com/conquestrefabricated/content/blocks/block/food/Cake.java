package com.conquestrefabricated.content.blocks.block.food;

import com.conquestrefabricated.core.block.properties.PropertyVariant;
import net.minecraft.block.CakeBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.Property;
import net.minecraft.util.collection.DefaultedList;

public class Cake extends CakeBlock implements PropertyVariant {

    public Cake(Settings properties) {
        super(properties);
    }

    @Override
    public Property<?> getVariantProperty() {
        return CakeBlock.BITES;
    }

    @Override
    public void appendStacks(ItemGroup group, DefaultedList<ItemStack> items) {
        PropertyVariant.fillGroup(this, items);
    }
}
