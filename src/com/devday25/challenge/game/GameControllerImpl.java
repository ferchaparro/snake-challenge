package com.devday25.challenge.game;

import com.devday25.challenge.game.enums.MovementDirection;
import com.devday25.challenge.game.ui.UIController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;

class GameControllerImpl implements GameController {

    private final SnakeBehavior snakeBehavior;
    private Iterator<Food> foodIterator;
    private final UIController ui;

    GameControllerImpl(SnakeBehavior snakeBehavior) {
        this.snakeBehavior = snakeBehavior;
        ui = UIController.Holder.getInstance();
    }

    public void moveSnake(MovementDirection direction) {
        snakeBehavior.move(direction);
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
            int[][] snake = new int[39][29];
            for (int[] ints : snake) {
                Arrays.fill(ints, 0);
            }
            snake[0][28] = 1;
            snake[1][28] = 2;
            snake[2][28] = 3;
            snake[3][28] = 4;
            snake[4][28] = 5;
            snake[5][28] = 6;
            snake[6][28] = 7;
            snake[7][28] = 8;
            snake[8][28] = 9;
            snake[9][28] = 10;
            snake[10][28] = 11;
            snake[11][28] = 12;
            snake[12][28] = 13;
            snake[13][28] = 14;
            snake[14][28] = 15;
            snake[15][28] = 16;
            snake[16][28] = 17;
            snake[17][28] = 18;
            snake[18][28] = 19;
            snake[19][28] = 20;
            snake[20][28] = 21;
            snake[21][28] = 22;
            snake[22][28] = 23;
            snake[23][28] = 24;
            snake[24][28] = 25;
            snake[25][28] = 26;
            snake[26][28] = 27;
            snake[27][28] = 28;
            snake[28][28] = 29;
            snake[29][28] = 30;
            snake[30][28] = 31;
            snake[31][28] = 32;
            snake[32][28] = 33;
            snake[33][28] = 34;
            snake[34][28] = 35;
            snake[35][28] = 36;
            snake[36][28] = 37;
            snake[37][28] = 38;
            snake[38][28] = 39;
            snake[38][27] = 40;
            snake[37][27] = 41;
            snake[36][27] = 42;
            snake[35][27] = 43;
            snake[35][26] = 44;
            snake[36][26] = 45;
            snake[37][26] = 46;
            snake[38][26] = 47;
            snake[38][25] = 48;
            snake[38][24] = 49;
            snake[38][23] = 50;
            snake[38][22] = 51;
            snake[37][22] = 52;
            snake[37][23] = 53;
            snake[37][24] = 54;
            snake[37][25] = 55;
            snake[36][25] = 56;
            snake[36][24] = 57;
            snake[36][23] = 58;
            snake[35][23] = 59;
            snake[34][23] = 60;
            snake[33][23] = 61;
            snake[33][24] = 62;
            snake[33][25] = 63;
            snake[34][25] = 64;
            snake[35][25] = 65;
            snake[35][24] = 66;
            snake[34][24] = 67;

            ui.update(new UpdateState(
                    snake,
                    foodIterator.next(),
                    12,
                    302
            ));

        }catch (IOException e) {
            e.printStackTrace();
            ui.shutdownAlert("No se pudo leer el archivo.");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            ui.shutdownAlert("El archivo no contiene el formato esperado.");
        }
    }

    // Aquí puedes agregar más métodos para controlar el juego, como iniciar, pausar, reiniciar, etc.
}
