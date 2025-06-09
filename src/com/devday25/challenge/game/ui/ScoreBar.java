package com.devday25.challenge.game.ui;

import javax.swing.*;
import java.awt.*;

class ScoreBar extends JPanel {

    private final JLabel scoreLabel;
    static final int BAR_HEIGHT = 18;
    public ScoreBar(int width) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBackground(Color.GRAY);
        setSize(width, BAR_HEIGHT);
        setLayout(new GridBagLayout());
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setForeground(java.awt.Color.WHITE);
        add(scoreLabel);
    }

    public void updateScore(int score, int movementsLeft) {
        scoreLabel.setText("SCORE: " + score+ " | MOVEMENTS LEFT: " + movementsLeft);
    }

}
