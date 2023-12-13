package com.conquestrefabricated.core.asset.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Model {

    /**
     * @return the name format of the model
     */
    String name();

    /**
     * @return the model's parent (used to point an item model to a block model)
     */
    String parent() default "";

    /**
     * @return the actual model json location to use
     */
    String template();

    /**
     * @return flag to determine whether the name() format accepts the singular or plural form of the material name
     */
    boolean plural() default false;
}
