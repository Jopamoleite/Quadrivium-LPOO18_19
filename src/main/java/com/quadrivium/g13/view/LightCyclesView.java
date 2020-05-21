package com.quadrivium.g13.view;

import com.quadrivium.g13.model.KeyPress;
import com.quadrivium.g13.model.Wall;

import java.io.IOException;
import java.util.List;

public interface LightCyclesView {
    void draw(List<Wall> walls, List<Wall> trails, List<Wall> enemyTrails);

    KeyPress processKey() throws IOException;

    void refreshScreen() throws IOException;

    void clearScreen();
}
