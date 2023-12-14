package com.conquestreforged.core.asset.annotation;



import com.conquestreforged.core.util.RenderLayer;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Render {

    RenderLayer value();
}
