package com.conquestrefabricated.client.gui.render;

import java.awt.*;

public class ColorUtils {

    public static String toHex(Color color) {
        return toHex(color.getRGB());
    }

    public static String toHex(int color) {
        return String.format("#%06X", (0xFFFFFF & color));
    }

    public static int fromHex(String color) {
        return Color.decode(color).getRGB();
    }
}
