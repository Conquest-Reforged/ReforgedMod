package com.conquestrefabricated.client.gui.palette.shape;

public class FloatMath {

    public static float radians(float angle) {
        return (float) Math.toRadians(angle);
    }

    public static float sqrt(int in) {
        return (float) Math.sqrt(in);
    }

    public static float sqrt(float in) {
        return (float) Math.sqrt(in);
    }

    public static int round(float f) {
        return (f >= 0) ? (int) (f + 0.5F) : (int) (f - 0.5F);
    }

    public static int round(double d) {
        return (d >= 0) ? (int) (d + 0.5) : (int) (d - 0.5);
    }

    public static float clampAngle(float value) {
        return value < 0F ? 360F + value : value > 360F ? value - 360F : value;
    }
}
