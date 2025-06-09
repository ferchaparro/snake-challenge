package com.devday25.challenge.game;

import com.devday25.challenge.game.enums.Speed;

import java.nio.file.Path;

public interface GameController {

    class Builder {
        private Speed _speed;
        private SnakeBehavior _snakeBehavior;
        private Builder(){}
        public Builder withSpeed(Speed speed) {
            this._speed = speed;
            return this;
        }
        public Builder withSnakeBehavior(SnakeBehavior snakeBehavior) {
            this._snakeBehavior = snakeBehavior;
            return this;
        }
        public GameController build() {
            if (_snakeBehavior == null) {
                throw new IllegalArgumentException("SnakeBehavior must be provided");
            }
            if (_speed == null) {
                _speed = Speed.NORMAL;
            }
            return getInstance(_snakeBehavior, _speed);
        }
        private static GameController instance;
        private GameController getInstance(SnakeBehavior snakeBehavior, Speed speed) {
            if (instance == null) {
                instance = new GameControllerImpl(snakeBehavior, speed);
            }
            return instance;
        }
    }
    static Builder builder() {
        return new Builder();
    }

    void startGame(Path path);
}
