package com.conquestreforged.client.gui.state;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.function.Predicate;

public class PropertyFilter implements Predicate<Property<?>> {

    public static final PropertyFilter INSTANCE = new PropertyFilter();

    @Override
    public boolean test(Property<?> property) {
        return property == BlockStateProperties.FACING
                || property == BlockStateProperties.HORIZONTAL_FACING
                || property == BlockStateProperties.WATERLOGGED
                || property.getName().equals("facing");
    }
}
