package com.devday25.challenge.game.ui;

import com.devday25.challenge.game.UpdateState;

import javax.swing.*;

class UIControllerImpl implements UIController {

    private final Root root;

    UIControllerImpl() {
        root = new Root();
    }

    @Override
    public void alert(String message) {
        JOptionPane.showMessageDialog(root, message, "Alert", JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public void update(UpdateState state) {
        if (state == null) {
            alert("Update state is null");
            return;
        }
        root.update(state);

    }

    @Override
    public void shutdownAlert(String message) {
        alert(message);
        root.dispose();
        System.exit(0);

    }

    @Override
    public void show() {
        root.setVisible(true);
    }
}
