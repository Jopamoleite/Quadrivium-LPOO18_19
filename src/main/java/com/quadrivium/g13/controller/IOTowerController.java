package com.quadrivium.g13.controller;

import com.quadrivium.g13.model.*;
import com.quadrivium.g13.view.IOTowerView;
import com.quadrivium.g13.view.LanternaMenuView;

import java.io.IOException;

public class IOTowerController implements GameController {
    IOTower model;
    IOTowerView view;

    public IOTowerController(IOTower model, IOTowerView view) {
        this.model = model;
        this.view = view;
    }

    public PlayerController getPlayer() {
        return model.getPlayer();
    }

    @Override
    public void setPlayer(PlayerController player) {
        model.setPlayer(player);
    }

    @Override
    public void draw() {
        model.getPlayer().draw();
    }

    @Override
    public void update() {

    }

    public boolean canPlayerMove(Position position) {
        return !(position.getX() >= (GameDimensions.getWidth() - 1) || position.getX() <= 0 || position.getY() >= (GameDimensions.getHeight() - 1) || position.getY() <= 0);
    }

    public void movePlayer(Position position) {
        if (canPlayerMove(position)) {
            model.getPlayer().setPosition(position);
        }
    }

    public void handleKey(KeyPress key) {
        switch (key) {
            case UP:
                movePlayer(model.getPlayer().moveUp());
                break;
            case RIGHT:
                movePlayer(model.getPlayer().moveRight());
                break;
            case DOWN:
                movePlayer(model.getPlayer().moveDown());
                break;
            case LEFT:
                movePlayer(model.getPlayer().moveLeft());
                break;
        }
    }

    @Override
    public boolean checkEnter(KeyPress key, CurrentLevel level) {
        if (key == KeyPress.ENTER) {
            level.setActiveGame(new MenuController(new Menu(), new LanternaMenuView()));
            return true;
        }

        return false;
    }

    @Override
    public GameResult play(CurrentLevel level) throws IOException, InterruptedException {
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

            if (key != null)
                handleKey(key);

            if (checkEnter(key, level))
                break;

            if (key == KeyPress.EXIT) {
                return GameResult.EXIT;
            }
            Thread.sleep(1000 / 30);
        }
        return GameResult.WIN;
    }
}
