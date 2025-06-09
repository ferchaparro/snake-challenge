package com.devday25.challenge.game;

import com.devday25.challenge.game.enums.MovementDirection;
import com.devday25.challenge.game.enums.Speed;
import com.devday25.challenge.game.ui.UIController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;

class GameControllerImpl implements GameController, Runnable{

    private final SnakeBehavior snakeBehavior;
    private final Speed speed;
    private Iterator<Food> foodIterator;
    private final UIController ui;
    private static final int MAX_TURNS = 1000;
    private static final int MAX_WIDTH = 21;
    private static final int MAX_HEIGHT = 13;
    private int turn = 0;
    private int score = 0;
    private int[][] snake;
    private Food currentFood;
    private int currentCursorX;
    private int currentCursorY;

    GameControllerImpl(SnakeBehavior snakeBehavior, Speed speed) {
        this.snakeBehavior = snakeBehavior;
        this.speed = speed;
        currentCursorX = MAX_WIDTH / 2;
        currentCursorY = MAX_HEIGHT / 2;
        ui = UIController.Holder.getInstance(MAX_WIDTH, MAX_HEIGHT);
    }

    public void resolveMovement(MovementDirection direction) {
        switch (direction) {
            case UP -> currentCursorY--;
            case DOWN -> currentCursorY++;
            case LEFT -> currentCursorX--;
            case RIGHT -> currentCursorX++;
        }
        try {
            var next = snake[currentCursorX][currentCursorY];
            if(next > 1) {
                ui.shutdownAlert("Has perdido, tu puntaje es: " + score);
                return;
            }
            snake[currentCursorX][currentCursorY] = score + 2;
        } catch (ArrayIndexOutOfBoundsException e) {
            ui.shutdownAlert("Has perdido, tu puntaje es: " + score);
            return;
        }
        updateSnake();
    }

    @Override
    public void startGame(Path path) {
        try {
            foodIterator = Files.readAllLines(path).stream()
                    .map(Food::of).toList()
                    .iterator();
            ui.show();
            if (!foodIterator.hasNext()) {
                throw new IllegalArgumentException("El archivo no contiene informacion.");
            }

            snake = new int[MAX_WIDTH][MAX_HEIGHT];
            for (int[] ints : snake) {
                Arrays.fill(ints, 0);
            }

            ui.update(new UpdateState(
                    snake,
                    currentFood = foodIterator.next(),
                    score,
                    MAX_TURNS - turn
            ));

            var thread = new Thread(this);
            thread.start();

        }catch (IOException e) {
            e.printStackTrace();
            ui.shutdownAlert("No se pudo leer el archivo.");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            ui.shutdownAlert("El archivo no contiene el formato esperado.");
        }
    }

    private synchronized void doResolveGameTurn() throws InterruptedException {
        Thread.sleep(speed.getDelay());
        this.resolveMovement(snakeBehavior.move(getDirectionBinaryList(
                currentCursorX,
                currentCursorY,
                currentFood.x(),
                currentFood.y()
        )));
    }

    @Override
    public void run() {
        try {
            while(turn++ < MAX_TURNS) {
                doResolveGameTurn();
            }
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
            ui.shutdownAlert("El juego ha sido interrumpido.");
        } catch (Exception e) {
            e.printStackTrace();
            ui.shutdownAlert("Ha ocurrido un error inesperado: " + e.getMessage());
        } finally {
            ui.shutdownAlert("Juego terminado, tu puntaje es: " + score);
        }

    }

    private int getDirectionBinaryList(int x, int y, int foodX, int foodY) {
        int direction = 0;
        if (foodX < x) {
            direction |= MovementDirection.LEFT.getValue();
        } else if (foodX > x) {
            direction |= MovementDirection.RIGHT.getValue();
        }
        if (foodY < y) {
            direction |= MovementDirection.UP.getValue();
        } else if (foodY > y) {
            direction |= MovementDirection.DOWN.getValue();
        }
        return direction;
    }

    private void updateSnake() {
        var ateFood = false;
        if (currentFood.x() == currentCursorX && currentFood.y() == currentCursorY) {
            score++;
            ateFood = true;
            if (foodIterator.hasNext()) {
                currentFood = foodIterator.next();
            } else {
                currentFood = new Food((int)(Math.random() * MAX_WIDTH), (int)(Math.random() * MAX_HEIGHT));
            }
        }
        if(ateFood) {
            ui.update(new UpdateState(
                    snake,
                    currentFood,
                    score,
                    MAX_TURNS - turn
            ));
            return;
        }
        for(int i = 0; i < snake.length; i++) {
            for (int j = 0; j < snake[i].length; j++) {
                if (snake[i][j] > 0) {
                    snake[i][j]--;
                }
            }
        }

        ui.update(new UpdateState(
                snake,
                currentFood,
                score,
                MAX_TURNS - turn
        ));

    }
}
