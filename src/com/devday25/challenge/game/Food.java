package com.devday25.challenge.game;

public record Food (int x, int y) {
    public static Food of(String food) {
        if (food == null || food.isBlank()) {
            throw new IllegalArgumentException("Food cannot be null or empty");
        }
        var coordinates = food.split("\\|");
        if (coordinates.length != 2) {
            throw new IllegalArgumentException("Food must be in the format 'x|y'");
        }
        return new Food(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
    }
}
