package com.quadrivium.g13.view;


import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.quadrivium.g13.model.GameDimensions;
import com.quadrivium.g13.model.GameScreen;

public class LanternaWinScreenView extends LanternaGameView implements WinScreenView{

    @Override
    public void draw() {
        TextGraphics graphics = GameScreen.getScreen().newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFF000"));
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.enableModifiers(SGR.BOLD);
        int x = GameDimensions.getWidth()/2-26;
        int y = GameDimensions.getHeight()/2-7;
        graphics.putString(x, y, " __   __  _______  __   __    _     _  ___   __    _ ");
        y++;
        graphics.putString(x, y, "|  | |  ||       ||  | |  |  | | _ | ||   | |  |  | |");
        y++;
        graphics.putString(x, y, "|  |_|  ||   _   ||  | |  |  | || || ||   | |   |_| |");
        y++;
        graphics.putString(x, y, "|       ||  | |  ||  |_|  |  |       ||   | |       |");
        y++;
        graphics.putString(x, y, "|_     _||  |_|  ||       |  |       ||   | |  _    |");
        y++;
        graphics.putString(x, y, "  |   |  |       ||       |  |   _   ||   | | | |   |");
        y++;
        graphics.putString(x, y, "  |___|  |_______||_______|  |__| |__||___| |_|  |__|");
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.putString(GameDimensions.getWidth()/2 - 11, GameDimensions.getHeight()/2+7, "PRESS ENTER TO CONTINUE");
    }
}
