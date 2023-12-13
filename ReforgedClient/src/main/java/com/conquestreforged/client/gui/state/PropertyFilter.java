package com.conquestreforged.client.gui.state;

import net.minecraft.state.IProperty;
import net.minecraft.state.properties.BlockStateProperties;

import java.util.function.Predicate;

public class PropertyFilter implements Predicate<IProperty<?>> {

    public static final PropertyFilter INSTANCE = new PropertyFilter();

    @Override
    public boolean test(IProperty<?> property) {
        return property == BlockStateProperties.FACING
                || property == BlockStateProperties.HORIZONTAL_FACING
                || property == BlockStateProperties.WATERLOGGED
                || property.getName().equals("facing");
    }
}
