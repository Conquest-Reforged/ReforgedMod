package com.conquestrefabricated.core.init.dev;

import com.conquestrefabricated.core.util.log.Log;

public class Environment {

    private static final boolean production = System.getProperty("dev") == null;

    public static boolean isProduction() {
        return production;
    }

    static {
        if (!production) {
            Log.info("Running in developer mode!");
        }
    }
}
