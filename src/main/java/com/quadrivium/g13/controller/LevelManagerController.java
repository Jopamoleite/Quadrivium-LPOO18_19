package com.quadrivium.g13.controller;

import com.quadrivium.g13.exceptions.InvalidGameException;
import com.quadrivium.g13.exceptions.OutOfBoundsException;
import com.quadrivium.g13.model.*;
import com.quadrivium.g13.view.*;

import java.io.IOException;

public class LevelManagerController {
    private LevelManager model;
    private LevelManagerView view;

    public LevelManagerController(LevelManager model, LevelManagerView view) throws OutOfBoundsException {
        this.model = model;
        this.view = view;
        initPlayer();
    }

    private void initPlayer() throws OutOfBoundsException {
        Position playerPos = new Position(GameDimensions.getWidth()/2, GameDimensions.getHeight()/2);
        Player playerModel = new Player(playerPos);
        PlayerView playerView;
        if(GameDimensions.isSwing()){
            playerView = new SwingPlayerView();
        }else {
            playerView = new LanternaPlayerView();
        }
        PlayerController player = new PlayerController(playerModel, playerView);
        model.setPlayer(player);
        model.getLevel().setPlayer(player);
        model.getLevel().getActiveGame().setPlayer(player);
    }

    public void closeScreen() throws IOException {
        view.closeScreen();
    }

    public void run() throws IOException, InterruptedException, OutOfBoundsException, InvalidGameException {

        while(true) {
            switch(model.getLevel().getActiveGame().play(model.getLevel())){
                case WIN:
                    if(GameDimensions.isSwing()){
                        model.getLevel().setActiveGame(new WinScreenController(new WinScreen(), new SwingWinScreenView()));
                    }
                    else{
                        model.getLevel().setActiveGame(new WinScreenController(new WinScreen(), new LanternaWinScreenView()));
                    }
                    break;
                case LOSE:
                    model.getPlayer().decreaseLives();
                    if(GameDimensions.isSwing()){
                        model.getLevel().setActiveGame(new LoseScreenController(new LoseScreen(), new SwingLoseScreenView()));
                    }
                    else{
                        model.getLevel().setActiveGame(new LoseScreenController(new LoseScreen(), new LanternaLoseScreenView()));
                    }
                    break;
                case PROCEED:
                    if(GameDimensions.isSwing()){
                        model.getLevel().setActiveGame(new MenuController(new Menu(), new SwingMenuView()));
                    }
                    else{
                        model.getLevel().setActiveGame(new MenuController(new Menu(), new LanternaMenuView()));
                    }
                    break;
                case START:
                    break;
                case EXIT:
                    return;
            }
        }
    }
}
