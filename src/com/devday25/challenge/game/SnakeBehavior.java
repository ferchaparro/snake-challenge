package com.devday25.challenge.game;

import com.devday25.challenge.game.enums.MovementDirection;

public interface SnakeBehavior {
    MovementDirection move(int direction, int snakeSize);
}
