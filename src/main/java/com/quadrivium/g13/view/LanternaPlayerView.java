package com.quadrivium.g13.view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.quadrivium.g13.model.GameScreen;
import com.quadrivium.g13.model.Position;

public class LanternaPlayerView implements PlayerView {
    public void draw(Position playerPosition) {
        TextGraphics graphics = GameScreen.getScreen().newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#F0F000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(playerPosition.getX(), playerPosition.getY()), "P");
    }
}
