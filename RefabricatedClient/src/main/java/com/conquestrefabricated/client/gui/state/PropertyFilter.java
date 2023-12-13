package com.conquestrefabricated.client.gui.state;

import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;

import java.util.function.Predicate;

public class PropertyFilter implements Predicate<Property<?>> {

    public static final PropertyFilter INSTANCE = new PropertyFilter();

    @Override
    public boolean test(Property<?> property) {
        return property == Properties.FACING
                || property == Properties.HORIZONTAL_FACING
                || property == Properties.WATERLOGGED
                || property.getName().equals("facing");
    }
}
