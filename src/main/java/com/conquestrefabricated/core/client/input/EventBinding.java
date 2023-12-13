package com.conquestrefabricated.core.client.input;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

import java.util.LinkedList;
import java.util.List;

public class EventBinding extends KeyBinding {

    private final List<BindListener> listeners = new LinkedList<>();

    private boolean down = false;

    // String description, net.minecraftforge.client.settings.IKeyConflictContext keyConflictContext, final InputMappings.Type inputType, final int keyCode, String category
    public EventBinding(String description, InputUtil.Key input, String category) {
        this(description, input, category, InputUtil.Type.SCANCODE);
    }

    public EventBinding(String description, InputUtil.Key input, String category, InputUtil.Type context) {
        super(description, context, input.getCode(), category);
        KeyBindingHelper.registerKeyBinding(this);
    }

    public EventBinding addListener(BindListener listener) {
        listeners.add(listener);
        return this;
    }

    public boolean checkPressed() {
        boolean pressed = super.wasPressed();
        if (pressed) {
            BindEvent event = new BindEvent(this);
            listeners.forEach(l -> l.onPress(event));
        }
        return pressed;
    }

    public boolean checkHeld() {
        boolean down = super.isPressed();
        if (down) {
            BindEvent event = new BindEvent(this);
            listeners.forEach(l -> l.onHold(event));
        } else if (this.down) {
            BindEvent event = new BindEvent(this);
            listeners.forEach(l -> l.onRelease(event));
        }
        return this.down = down;
    }
/*
    private static IKeyConflictContext context = new IKeyConflictContext() {
        @Override
        public boolean isActive() {
            return false;
        }

        @Override
        public boolean conflicts(IKeyConflictContext other) {
            return false;
        }
    };*/
}
