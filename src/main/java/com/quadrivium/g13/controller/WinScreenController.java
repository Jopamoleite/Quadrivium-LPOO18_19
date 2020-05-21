package com.quadrivium.g13.controller;

import com.quadrivium.g13.exceptions.OutOfBoundsException;
import com.quadrivium.g13.model.*;
import com.quadrivium.g13.view.LanternaMenuView;
import com.quadrivium.g13.view.SwingMenuView;
import com.quadrivium.g13.view.WinScreenView;

import java.io.IOException;

public class WinScreenController implements GameController{
    private WinScreen model;
    private WinScreenView view;

    public WinScreenController(WinScreen model, WinScreenView view){
        this.model = model;
        this.view = view;
    }

    @Override
    public void setPlayer(PlayerController player) {

    }

    @Override
    public void draw(){
        view.draw();
    }

    @Override
    public boolean checkEnter(KeyPress key, CurrentLevel level) throws OutOfBoundsException {
        if(key == KeyPress.ENTER){
            if(GameDimensions.isSwing()){
                level.setActiveGame(new MenuController(new Menu(), new SwingMenuView()));
            }
            else{
                level.setActiveGame(new MenuController(new Menu(), new LanternaMenuView()));
            }
            return true;
        }

        return false;
    }

    @Override
    public GameResult play(CurrentLevel level) throws IOException, InterruptedException, OutOfBoundsException {
        while (true) {
            view.clearScreen();
            draw();
            view.refreshScreen();

            KeyPress key;
            if (GameDimensions.isSwing()) {
                key = level.getKey();
            } else {
                key = view.processKey();
            }

            if (checkEnter(key,level)) {
                break;
            }

            if (key == KeyPress.EXIT || key == KeyPress.EOF) {
                return GameResult.EXIT;
            }


            Thread.sleep(1000 / 30);
        }
        return GameResult.PROCEED;
    }
}
