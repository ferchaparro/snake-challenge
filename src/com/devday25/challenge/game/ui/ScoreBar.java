package com.devday25.challenge.game.ui;

import javax.swing.*;

class ScoreBar extends JPanel {

    private JLabel scoreLabel;

    public ScoreBar() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBackground(java.awt.Color.DARK_GRAY);
        setSize(800, 18);
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setForeground(java.awt.Color.WHITE);
        add(scoreLabel);
    }

    public void updateScore(int score, int movementsLeft) {
        scoreLabel.setText("Score: " + score+ " | Movements Left: " + movementsLeft);
    }

}
