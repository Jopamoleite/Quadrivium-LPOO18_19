package com.quadrivium.g13.model;

import com.googlecode.lanterna.screen.Screen;

public final class GameScreen {

    private static Screen screen;

    public static Screen getScreen() {
        return screen;
    }

    public static void setScreen(Screen screen) {
        GameScreen.screen = screen;
    }
}
