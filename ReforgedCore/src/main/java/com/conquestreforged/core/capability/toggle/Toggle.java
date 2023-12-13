package com.conquestreforged.core.capability.toggle;

public class Toggle {

    public static final String PROTOCOL_NAME = "toggle";
    public static final String PROTOCOL_VERSION = "1";

    private int index;

    public Toggle() {
        this(0);
    }

    public Toggle(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public int setIndex(int toggle) {
        return this.index = toggle;
    }

    public void increment() {
        if (index < 7) {
            index++;
        } else {
            index = 0;
        }
    }
}
