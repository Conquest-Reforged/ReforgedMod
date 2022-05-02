package com.conquestreforged.core.client.input;

import net.minecraft.client.KeyMapping;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraftforge.client.settings.IKeyConflictContext;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.ClientRegistry;

import java.util.LinkedList;
import java.util.List;

public class EventBinding extends KeyMapping {

    private final List<BindListener> listeners = new LinkedList<>();

    private boolean down = false;

    // String description, net.minecraftforge.client.settings.IKeyConflictContext keyConflictContext, final InputMappings.Type inputType, final int keyCode, String category
    public EventBinding(String description, InputConstants.Key input, String category) {
        this(description, input, category, KeyConflictContext.UNIVERSAL);
    }

    public EventBinding(String description, InputConstants.Key input, String category, IKeyConflictContext context) {
        super(description, context, input, category);
        ClientRegistry.registerKeyBinding(this);
    }

    public EventBinding addListener(BindListener listener) {
        listeners.add(listener);
        return this;
    }

    public boolean checkPressed() {
        boolean pressed = super.consumeClick();
        if (pressed) {
            BindEvent event = new BindEvent(this);
            listeners.forEach(l -> l.onPress(event));
        }
        return pressed;
    }

    public boolean checkHeld() {
        boolean down = super.isDown();
        if (down) {
            BindEvent event = new BindEvent(this);
            listeners.forEach(l -> l.onHold(event));
        } else if (this.down) {
            BindEvent event = new BindEvent(this);
            listeners.forEach(l -> l.onRelease(event));
        }
        return this.down = down;
    }

    private static IKeyConflictContext context = new IKeyConflictContext() {
        @Override
        public boolean isActive() {
            return false;
        }

        @Override
        public boolean conflicts(IKeyConflictContext other) {
            return false;
        }
    };
}
