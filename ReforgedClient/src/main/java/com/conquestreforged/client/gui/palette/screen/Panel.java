package com.conquestreforged.client.gui.palette.screen;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.Widget;

import java.util.ArrayList;
import java.util.List;

public class Panel {

    private static final int LEFT = -1;
    private static final int RIGHT = 1;

    private int left = 0;
    private int top = 0;
    private int width = 0;
    private int height = 0;
    private int offsetX = 0;

    private final int side;
    private final boolean offScreen;
    private final List<Widget> children = new ArrayList<>();

    private Panel(int side, boolean offScreen) {
        this.side = side;
        this.offScreen = offScreen;
    }

    public void reset() {
        children.clear();
    }

    public void add(Widget widget) {
        children.add(widget);
    }

    public void tick() {
        if (offsetX != 0) {
            offsetX -= side;
        }

        int top = this.top;
        for (Widget widget : children) {
            widget.setWidth(width);
            widget.x = left + offsetX;
            widget.y = top;
            top += widget.getHeight() + 1;
        }
    }

    public void setSize(Screen parent, int width, int height) {
        this.width = width;
        this.height = height;
        this.left = side == LEFT ? 0 : parent.width - width;
        this.offsetX = offScreen ? width * side : 0;
    }

    public static Panel left(boolean offScreen) {
        return new Panel(LEFT, offScreen);
    }

    public static Panel right(boolean offScreen) {
        return new Panel(RIGHT, offScreen);
    }
}
