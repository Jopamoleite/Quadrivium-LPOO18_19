package com.quadrivium.g13.view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.quadrivium.g13.model.GameScreen;
import com.quadrivium.g13.model.Sector;

import java.util.List;

public class LanternaMenuView extends LanternaGameView implements MenuView {

    public void draw(List<List<Sector>> sectors){
        TextGraphics graphics = GameScreen.getScreen().newTextGraphics();
        for (List<Sector> sectorList : sectors)
            for(Sector sector : sectorList) {
                graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
                graphics.setBackgroundColor(TextColor.Factory.fromString(sector.getColor()));
                graphics.enableModifiers(SGR.BOLD);
                graphics.putString(new TerminalPosition(sector.getPosition().getX(), sector.getPosition().getY()), sector.getSectorStr());
            }
    }
}
