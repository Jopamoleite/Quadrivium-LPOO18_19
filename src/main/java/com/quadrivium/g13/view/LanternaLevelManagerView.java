package com.quadrivium.g13.view;

import com.quadrivium.g13.model.GameScreen;

import java.io.IOException;

public class LanternaLevelManagerView implements LevelManagerView {

    public void closeScreen() throws IOException {
        GameScreen.getScreen().close();
    }

}
