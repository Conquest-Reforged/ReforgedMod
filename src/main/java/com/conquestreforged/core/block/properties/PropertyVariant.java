package com.conquestreforged.core.block.properties;

import com.conquestreforged.core.block.StateUtils;
import com.conquestreforged.core.item.ItemUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.Property;
import net.minecraft.util.collection.DefaultedList;

public interface PropertyVariant {

    Property<?> getVariantProperty();

    static <B extends Block & PropertyVariant> void fillGroup(B block, DefaultedList<ItemStack> stacks) {
        Property<?> property = block.getVariantProperty();
        for (Object value : property.getValues()) {
            BlockState state = StateUtils.with(block.getDefaultState(), property, value.toString());
            ItemStack stack = ItemUtils.fromState(state, property);
            stacks.add(stack);
        }
    }
}
