package com.conquestreforged.core.block.properties;

import com.conquestreforged.core.block.StateUtils;
import com.conquestreforged.core.item.ItemUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IProperty;
import net.minecraft.util.NonNullList;

public interface PropertyVariant {

    IProperty<?> getVariantProperty();

    static <B extends Block & PropertyVariant> void fillGroup(B block, NonNullList<ItemStack> stacks) {
        IProperty<?> property = block.getVariantProperty();
        for (Object value : property.getAllowedValues()) {
            BlockState state = StateUtils.with(block.getDefaultState(), property, value.toString());
            ItemStack stack = ItemUtils.fromState(state, property);
            stacks.add(stack);
        }
    }
}
