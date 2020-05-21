package com.quadrivium.g13.controller;

import com.quadrivium.g13.model.*;
import com.quadrivium.g13.view.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LevelManagerController {
    LevelManager model;
    LevelManagerView view;

    public LevelManagerController(LevelManager model, LevelManagerView view) {
        this.model = model;
        this.view = view;
        initPlayer();
    }

    private void initPlayer() {
        Position playerPos = new Position(GameDimensions.getWidth() / 2, GameDimensions.getHeight() / 2);
        Player playerModel = new Player(playerPos);
        PlayerView playerView;
        if (GameDimensions.isSwing()) {
            playerView = new SwingPlayerView();
        } else {
            playerView = new LanternaPlayerView();
        }
        PlayerController player = new PlayerController(playerModel, playerView);
        model.setPlayer(player);
        model.getLevel().setPlayer(player);
        model.getLevel().getActiveGame().setPlayer(player);
    }

    private void resetValues() {
        model.setDifficulty(0);
        List<Boolean> passedLevels = new ArrayList<>();
        passedLevels.clear();
        for (int i = 0; i < 4; i++) {
            passedLevels.add(Boolean.FALSE);
        }
        model.setPassedLevels(passedLevels);
        model.getPlayer().setLives(3);
        Position player_pos = new Position(GameDimensions.getWidth() / 2, GameDimensions.getHeight() / 2);
        model.getPlayer().setPosition(player_pos);
    }

    public void closeScreen() throws IOException {
        view.closeScreen();
    }

    public void run() throws IOException, InterruptedException {

        while (true) {
            switch (model.getLevel().getActiveGame().play(model.getLevel())) {
                case WIN:
                    if (GameDimensions.isSwing()) {
                        model.getLevel().setActiveGame(new MenuController(new Menu(), new SwingMenuView()));
                    } else {
                        model.getLevel().setActiveGame(new MenuController(new Menu(), new LanternaMenuView()));
                    }
                    break;
                case LOSE:
                    model.getPlayer().decreaseLives();
                    if (GameDimensions.isSwing()) {
                        model.getLevel().setActiveGame(new MenuController(new Menu(), new SwingMenuView()));
                    } else {
                        model.getLevel().setActiveGame(new MenuController(new Menu(), new LanternaMenuView()));
                    }
                    break;
                case PROCEED:
                    break;
                case EXIT:
                    return;
            }
        }
    }
}
