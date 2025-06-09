package com.devday25.challenge.game.enums;

public enum MovementDirection {
    UP(1),
    DOWN(2),
    LEFT(4),
    RIGHT(8);

    private final int value;

    MovementDirection(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
