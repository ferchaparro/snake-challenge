package com.devday25.challenge.game;

import com.devday25.challenge.game.enums.Speed;

import java.nio.file.Path;

public interface GameController {

    class Builder {
        private Speed _speed;
        private SnakeBehavior _snakeBehavior;
        private String _player;
        private Builder(){}
        public Builder withSpeed(Speed speed) {
            this._speed = speed;
            return this;
        }
        public Builder withSnakeBehavior(SnakeBehavior snakeBehavior) {
            this._snakeBehavior = snakeBehavior;
            return this;
        }
        public Builder withPlayer(String player) {
            this._player = player;
            return this;
        }
        public GameController build() {
            if (_snakeBehavior == null) {
                throw new IllegalArgumentException("SnakeBehavior must be provided");
            }
            if (_speed == null) {
                _speed = Speed.NORMAL;
            }
            if( _player == null || _player.isEmpty()) {
                _player = "NO NAME";
            }
            return getInstance(_snakeBehavior, _speed, _player);
        }
        private static GameController instance;
        private GameController getInstance(SnakeBehavior snakeBehavior, Speed speed, String player) {
            if (instance == null) {
                instance = new GameControllerImpl(snakeBehavior, speed, player);
            }
            return instance;
        }
    }
    static Builder builder() {
        return new Builder();
    }

    void startGame(Path path);
}
