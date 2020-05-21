package com.quadrivium.g13.view;


import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.quadrivium.g13.model.GameDimensions;
import com.quadrivium.g13.model.GameScreen;

public class LanternaLoseScreenView extends LanternaGameView implements LoseScreenView{

    @Override
    public void draw() {
        TextGraphics graphics = GameScreen.getScreen().newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString("#009FFF"));
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.enableModifiers(SGR.BOLD);
        int x = GameDimensions.getWidth()/2-32;
        int y = GameDimensions.getHeight()/2-7;
        graphics.putString(x, y, " __   __  _______  __   __    ___      _______  _______  _______ ");
        y++;
        graphics.putString(x, y, "|  | |  ||       ||  | |  |  |   |    |       ||       ||       |");
        y++;
        graphics.putString(x, y, "|  |_|  ||   _   ||  | |  |  |   |    |   _   ||  _____||    ___|");
        y++;
        graphics.putString(x, y, "|       ||  | |  ||  |_|  |  |   |    |  | |  || |_____ |   |___ ");
        y++;
        graphics.putString(x, y, "|_     _||  |_|  ||       |  |   |___ |  |_|  ||_____  ||    ___|");
        y++;
        graphics.putString(x, y, "  |   |  |       ||       |  |       ||       | _____| ||   |___ ");
        y++;
        graphics.putString(x, y, "  |___|  |_______||_______|  |_______||_______||_______||_______|");
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.putString(GameDimensions.getWidth()/2 - 11, GameDimensions.getHeight()/2+7, "PRESS ENTER TO CONTINUE");
    }
}
