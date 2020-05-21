package com.quadrivium.g13.view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.quadrivium.g13.model.GameDimensions;
import com.quadrivium.g13.model.GameScreen;
import com.quadrivium.g13.model.Sector;

import java.util.List;

public class LanternaControlsView extends LanternaGameView implements ControlsView {

    public void draw(List<Sector> sectors) {
        TextGraphics graphics = GameScreen.getScreen().newTextGraphics();
        for (Sector sector : sectors) {
            graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
            graphics.setBackgroundColor(TextColor.Factory.fromString(sector.getColor()));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(sector.getPosition().getX(), sector.getPosition().getY()), sector.getSectorStr());
        }
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(GameDimensions.getWidth() / 4, GameDimensions.getHeight() / 2), "Controlar a Personagem: Setas");
        graphics.putString(new TerminalPosition(GameDimensions.getWidth() / 4, GameDimensions.getHeight() / 2 + 1), "Interagir: Enter");
        graphics.putString(new TerminalPosition(GameDimensions.getWidth() / 4, GameDimensions.getHeight() / 2 + 2), "Disparar: W,A,S,D");
        graphics.putString(new TerminalPosition(GameDimensions.getWidth() / 4, GameDimensions.getHeight() / 2 + 3), "Quit: Q, Escape");
        graphics.putString(new TerminalPosition(GameDimensions.getWidth() / 2 - 11, GameDimensions.getHeight() - GameDimensions.getHeight() / 5), "PRESS ENTER TO CONTINUE");
    }
}

