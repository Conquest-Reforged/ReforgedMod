package com.conquestreforged.client.gui.render;

public enum Curve {
    LINEAR {
        @Override
        public float apply(float input) {
            return input;
        }
    },
    SQUARE {
        @Override
        public float apply(float input) {
            return input * input;
        }
    },
    CUBIC {
        @Override
        public float apply(float input) {
            return input * input * input;
        }
    };

    public abstract float apply(float input);
}
