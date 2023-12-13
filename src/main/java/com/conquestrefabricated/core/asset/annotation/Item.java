package com.conquestrefabricated.core.asset.annotation;

import net.minecraft.item.BlockItem;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Item {

    Class<? extends net.minecraft.item.Item> value() default BlockItem.class;
}
