package com.quadrivium.g13.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.quadrivium.g13.model.GameDimensions;
import com.quadrivium.g13.model.GameScreen;
import com.quadrivium.g13.model.KeyPress;

import java.io.IOException;

public abstract class LanternaGameView {

    public KeyPress processKey() throws IOException {
        KeyStroke key;
        key = GameScreen.getScreen().pollInput();
        if (key == null) {
            return KeyPress.NO_KEY;
        }
        switch (key.getKeyType()) {
            case ArrowUp:
                return KeyPress.UP;
            case ArrowRight:
                return KeyPress.RIGHT;
            case ArrowDown:
                return KeyPress.DOWN;
            case ArrowLeft:
                return KeyPress.LEFT;
            case Enter:
                return KeyPress.ENTER;
            case Escape:
                return KeyPress.EXIT;
            case Character:
                if (key.getCharacter() == 'W' || key.getCharacter() == 'w')
                    return KeyPress.W;
                if (key.getCharacter() == 'A' || key.getCharacter() == 'a')
                    return KeyPress.A;
                if (key.getCharacter() == 'S' || key.getCharacter() == 's')
                    return KeyPress.S;
                if (key.getCharacter() == 'D' || key.getCharacter() == 'd')
                    return KeyPress.D;
                break;
        }

        return KeyPress.NO_KEY;
    }

    public void refreshScreen() throws IOException {
        GameScreen.getScreen().refresh();
    }

    public void clearScreen() {
        GameScreen.getScreen().newTextGraphics().setBackgroundColor(TextColor.Factory.fromString("#000000"));
        GameScreen.getScreen().newTextGraphics().fillRectangle(new TerminalPosition(0, 0), new TerminalSize(GameDimensions.getWidth(), GameDimensions.getHeight()), ' ');
    }
}
