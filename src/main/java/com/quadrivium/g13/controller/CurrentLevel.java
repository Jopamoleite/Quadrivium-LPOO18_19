package com.quadrivium.g13.controller;

import com.quadrivium.g13.exceptions.OutOfBoundsException;
import com.quadrivium.g13.model.Controls;
import com.quadrivium.g13.model.GameDimensions;
import com.quadrivium.g13.model.GameJFrame;
import com.quadrivium.g13.model.KeyPress;
import com.quadrivium.g13.view.ControlsView;
import com.quadrivium.g13.view.LanternaControlsView;
import com.quadrivium.g13.view.SwingControlsView;
import com.quadrivium.g13.view.SwingLevelView;

public class CurrentLevel {

    private GameController activeGame;
    private PlayerController player;
    private SwingLevelView view;

    public CurrentLevel() throws OutOfBoundsException {
        ControlsView menuView;
        if(GameDimensions.isSwing()) {
            view = new SwingLevelView();
            GameJFrame.getJframe().addKeyListener(view);
            menuView = new SwingControlsView();
        }
        else
            menuView = new LanternaControlsView();
        Controls menuModel = new Controls();
        this.activeGame = new ControlsController(menuModel, menuView);
    }

    public GameController getActiveGame() {
        return activeGame;
    }

    public void setActiveGame(GameController activeGame) throws OutOfBoundsException {
        this.activeGame = activeGame;
        this.player.resetPosition();
        this.activeGame.setPlayer(player);
    }

    public PlayerController getPlayer() {
        return player;
    }

    public void setPlayer(PlayerController player) {
        this.player = player;
    }

    public KeyPress getKey(){
        return view.getAndResetKey();
    }

}
