package com.devday25.challenge.game.ui;

import com.devday25.challenge.game.UpdateState;

public interface UIController {
    void shutdownAlert(String message);

    void show();

    class Holder {
        private Holder() {}

        private static UIController instance;

        public static UIController getInstance(int maxWidth, int maxHeight) {
            if (instance == null) {
                instance = new UIControllerImpl(maxWidth, maxHeight);
            }
            return instance;
        }
    }

    void alert(String message);

    void update(UpdateState state);
}
