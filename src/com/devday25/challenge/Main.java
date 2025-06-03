package com.devday25.challenge;

import com.devday25.challenge.game.GameController;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de la clase Juego
        var game = GameController.getInstance(null);

        // Iniciar el juego
        game.startGame(Path.of("C:/Users/fernando.gastelum/Documents/devs/snake-levels/level1.snake"));
    }
}
