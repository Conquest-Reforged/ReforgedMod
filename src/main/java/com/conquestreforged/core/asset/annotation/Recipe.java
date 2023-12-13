package com.conquestreforged.core.asset.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Recipe {

    /**
     * @return the name format of the recipe
     */
    String name();

    /**
     * @return the actual model json location to use
     */
    String template();

    /**
     * @return the output item name
     */
    String output() default "";

    /**
     * @return list of ingredient overrides
     */
    Ingredient[] ingredients() default {};
}
