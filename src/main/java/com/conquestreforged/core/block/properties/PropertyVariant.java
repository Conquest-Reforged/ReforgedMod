package com.conquestreforged.core.block.properties;

import com.conquestreforged.core.block.StateUtils;
import com.conquestreforged.core.item.ItemUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.core.NonNullList;

public interface PropertyVariant {

    Property<?> getVariantProperty();

    static <B extends Block & PropertyVariant> void fillGroup(B block, NonNullList<ItemStack> stacks) {
        Property<?> property = block.getVariantProperty();
        for (Object value : property.getPossibleValues()) {
            BlockState state = StateUtils.with(block.defaultBlockState(), property, value.toString());
            ItemStack stack = ItemUtils.fromState(state, property);
            stacks.add(stack);
        }
    }
}
