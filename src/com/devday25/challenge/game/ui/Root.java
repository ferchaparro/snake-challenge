package com.devday25.challenge.game.ui;

import com.devday25.challenge.game.UpdateState;

import javax.swing.*;
import java.awt.*;

class Root extends JFrame {

    private final com.devday25.challenge.game.ui.Canvas canvas;
    private final ScoreBar scoreBar;
    public Root(int maxWidth, int maxHeight, String player) {
        super("Snake Challaenge, Ferc Dev's day 2025");
        var  width = (Canvas.CELL_SIZE)*maxWidth+(Canvas.BORDER_WIDTH*2);
        scoreBar = new ScoreBar(width, player);
        canvas = new Canvas();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, (Canvas.CELL_SIZE)*maxHeight+ScoreBar.BAR_HEIGHT+(Canvas.BORDER_WIDTH*2) +30);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
        add(scoreBar, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
    }

    public void update(UpdateState state) {
        canvas.updateCanvas(state.snake(), state.food());
        scoreBar.updateScore(state.score(), state.movementsLeft());
    }
}
