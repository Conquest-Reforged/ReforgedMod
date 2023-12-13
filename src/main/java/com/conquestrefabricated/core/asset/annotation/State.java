package com.conquestrefabricated.core.asset.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface State {

    /**
     * @return the name format of the blockstate
     */
    String name();

    /**
     * @return the actual blockstate json location to use
     */
    String template();

    /**
     * @return flag to determine whether the name() format accepts the singular or plural form of the material name
     */
    boolean plural() default false;
}
