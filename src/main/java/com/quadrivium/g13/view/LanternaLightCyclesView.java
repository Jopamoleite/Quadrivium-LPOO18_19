package com.quadrivium.g13.view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.quadrivium.g13.model.GameScreen;
import com.quadrivium.g13.model.Wall;

import java.util.List;

public class LanternaLightCyclesView extends LanternaGameView implements LightCyclesView {
    public void draw(List<Wall> walls, List<Wall> trails, List<Wall> enemyTrails, int score){
        TextGraphics graphics = GameScreen.getScreen().newTextGraphics();

        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.putString(new TerminalPosition(85, 2), "Score: ");
        graphics.putString(new TerminalPosition(92,2), String.valueOf(score));

        for(Wall wall : walls){
            graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
            graphics.setForegroundColor(TextColor.Factory.fromString(wall.getColor()));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(wall.getPosition().getX(), wall.getPosition().getY()), wall.getWallStr());
        }
        for(Wall trail : trails){
            graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
            graphics.setForegroundColor(TextColor.Factory.fromString(trail.getColor()));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(trail.getPosition().getX(), trail.getPosition().getY()), trail.getWallStr());
        }
        for(Wall trail : enemyTrails){
            graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
            graphics.setForegroundColor(TextColor.Factory.fromString(trail.getColor()));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(trail.getPosition().getX(), trail.getPosition().getY()), trail.getWallStr());
        }
    }
}
