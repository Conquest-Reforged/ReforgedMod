package com.conquestrefabricated.core.asset.annotation;



import com.conquestrefabricated.core.util.RenderLayer;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Render {

    RenderLayer value();
}
