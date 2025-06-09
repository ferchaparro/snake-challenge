package com.devday25.challenge;

import com.devday25.challenge.game.GameController;
import com.devday25.challenge.game.enums.MovementDirection;
import com.devday25.challenge.game.enums.Speed;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        var game = GameController.builder()
                .withSnakeBehavior((dir)-> MovementDirection.RIGHT)
                .withSpeed(Speed.FAST)
                .build();

        game.startGame(Path.of("/Users/uruser/Documents/level1.snake"));
    }
}
