package com.conquestrefabricated.client.gui.palette.component;

import net.minecraft.util.Identifier;

public class Style {

    private static final float CENTER_SCALE = 1.75F;
    private static final float RADIAL_SCALE = 1.15F;
    private static final int SCALE_THRESHOLD = 18; // number of filled slots before scaling down items

    public final float scale;
    public final boolean fixedScale;

    public int highlightColor;
    public int hoveredColor;
    public float highlightScale;
    public final Identifier background;

    private Style(float scale, boolean fixedScale, Identifier background) {
        this.scale = scale;
        this.background = background;
        this.hoveredColor = 0xFFFFFF;
        this.highlightColor = 0xFFFFFF;
        this.fixedScale = fixedScale;
        this.highlightScale = 1.075F;
    }

    public static Style center(Identifier background) {
        return new Style(CENTER_SCALE, true, background);
    }

    public static Style radial(int count, Identifier background) {
        if (count > SCALE_THRESHOLD) {
            float dif = (count - SCALE_THRESHOLD) / (float) SCALE_THRESHOLD;
            float scale = RADIAL_SCALE - Math.min(dif, 0.45F);
            return new Style(scale, false, background);
        } else {
            return new Style(RADIAL_SCALE, false, background);
        }
    }
}
