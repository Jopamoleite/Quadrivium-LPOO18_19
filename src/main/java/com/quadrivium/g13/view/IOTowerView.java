package com.quadrivium.g13.view;

import com.quadrivium.g13.model.KeyPress;

import java.io.IOException;

public interface IOTowerView {
    KeyPress processKey() throws IOException;

    void refreshScreen() throws IOException;

    void clearScreen();
}
