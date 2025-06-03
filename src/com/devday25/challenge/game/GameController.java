package com.devday25.challenge.game;

import java.nio.file.Path;

public interface GameController {

    class Holder {
        private Holder(){}
        private static GameController instance;
        public static GameController getInstance(SnakeBehavior snakeBehavior) {
            if (instance == null) {
                instance = new GameControllerImpl(snakeBehavior);
            }
            return instance;
        }
    }
    static GameController getInstance(SnakeBehavior snakeBehavior) {
        return Holder.getInstance(snakeBehavior);
    }

    void startGame(Path path);
}
