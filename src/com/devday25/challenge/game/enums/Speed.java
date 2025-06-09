package com.devday25.challenge.game.enums;

public enum Speed {
    VERY_SLOW(1000),
    SLOW(500),
    NORMAL(300),
    FAST(50),
    VERY_FAST(10),
    MAX(5);

    private final int delay;

    Speed(int delay) {
        this.delay = delay;
    }

    public int getDelay() {
        return delay;
    }
}
