package com.devday25.challenge.game.ui;

import javax.swing.*;
import java.awt.*;

class ScoreBar extends JPanel {

    private final JLabel scoreLabel;
    static final int BAR_HEIGHT = 18;
    private final String player;
    private final static int PLAYER_MAX_LENGTH = 17;

    public ScoreBar(int width, String player) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBackground(Color.GRAY);
        setSize(width, BAR_HEIGHT);
        setLayout(new GridBagLayout());
        this.player=player;
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setForeground(java.awt.Color.WHITE);
        add(scoreLabel);
    }

    public void updateScore(int score, int movementsLeft) {
        scoreLabel.setText("PLAYER: " + truncate(player).toUpperCase() + " | SCORE: " + score+ " | MOVEMENTS LEFT: " + movementsLeft);
    }

    private String truncate(String text) {
        if (text.length() > PLAYER_MAX_LENGTH) {
            return text.substring(0, PLAYER_MAX_LENGTH);
        }
        return text;
    }

}
