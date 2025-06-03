package com.devday25.challenge.game.ui;

import com.devday25.challenge.game.UpdateState;

import javax.swing.*;
import java.awt.*;

class Root extends JFrame {

    private final com.devday25.challenge.game.ui.Canvas canvas;
    private final ScoreBar scoreBar;
    public Root() {
        super("Snake Challaenge, Coppel DevDay 25");
        scoreBar = new ScoreBar();
        canvas = new Canvas();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(810, 650);
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
