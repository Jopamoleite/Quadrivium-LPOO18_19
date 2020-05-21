package com.quadrivium.g13.view;

import com.quadrivium.g13.model.KeyPress;
import com.quadrivium.g13.model.Sector;

import java.io.IOException;
import java.util.List;

public interface ControlsView {
    void draw(List<Sector> sectors);

    KeyPress processKey() throws IOException;

    void refreshScreen() throws IOException;

    void clearScreen();
}
