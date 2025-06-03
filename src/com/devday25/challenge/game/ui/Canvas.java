package com.devday25.challenge.game.ui;

import com.devday25.challenge.game.Food;

import javax.swing.*;
import java.awt.*;

class Canvas extends JPanel {

    private Food food;
    private int[][] snake;
    private static final int CELL_SIZE = 20;
    private static final int BORDER_WIDTH = 10;

    public Canvas() {
        setFocusable(true);
        setLayout(null);
        setBackground(java.awt.Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, BORDER_WIDTH));
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        drawCell(g, food.x(), food.y());


        for (int i = 0; i < snake.length; i++) {
            for(int j = 0; j < snake[i].length; j++) {
                if (snake[i][j] > 0) {
                    g.setColor(Color.LIGHT_GRAY);
                    drawCell(g, i, j);
                    drawCellBorder(g, i, j);
                }
            }
        }
    }

    public void updateCanvas(int[][] snake, Food food) {
        this.snake = snake;
        this.food = food;
        repaint();
    }

    private void drawCell(Graphics g, int x, int y) {
        g.fillRect((x * CELL_SIZE) + BORDER_WIDTH, (y * CELL_SIZE) + BORDER_WIDTH, CELL_SIZE, CELL_SIZE);

    }

    private void drawCellBorder(Graphics g, int x, int y) {
        var currentValue = snake[x][y];
        var westValue = (x > 0) ? snake[x - 1][y] : 0;
        var eastValue = (x < snake.length - 1) ? snake[x + 1][y] : 0;
        var northValue = (y > 0) ? snake[x][y - 1] : 0;
        var southValue = (y < snake[x].length - 1) ? snake[x][y + 1] : 0;
        if(currentValue>0){
            currentValue++;
        }
        if(northValue>0){
            northValue++;
        }
        if(southValue>0){
            southValue++;
        }
        if(westValue>0){
            westValue++;
        }
        var northDifference = Math.abs(currentValue - northValue);
        var southDifference = Math.abs(currentValue - southValue);
        var westDifference = Math.abs(currentValue - westValue);
        var eastDifference = Math.abs(currentValue - eastValue);

        g.setColor(Color.BLACK);
        if(northDifference > 1) {
            g.fillRect((x * CELL_SIZE) + BORDER_WIDTH, (y * CELL_SIZE) + BORDER_WIDTH, CELL_SIZE, 1);
        }
        if(southDifference > 1) {
            g.fillRect((x * CELL_SIZE) + BORDER_WIDTH + CELL_SIZE, (y * CELL_SIZE) + BORDER_WIDTH, CELL_SIZE, 1);
        }
        if(westDifference > 1) {
            g.fillRect((x * CELL_SIZE) + BORDER_WIDTH, (y * CELL_SIZE) + BORDER_WIDTH, 1, CELL_SIZE);
        }
        if(eastDifference > 1) {
            g.fillRect((x * CELL_SIZE) + BORDER_WIDTH, (y * CELL_SIZE) + BORDER_WIDTH + CELL_SIZE, 1, CELL_SIZE);
        }
    }
}
