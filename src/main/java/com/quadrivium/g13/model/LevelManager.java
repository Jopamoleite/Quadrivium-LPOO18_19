package com.quadrivium.g13.model;

import com.quadrivium.g13.controller.CurrentLevel;
import com.quadrivium.g13.controller.PlayerController;
import com.quadrivium.g13.exceptions.OutOfBoundsException;

import java.util.ArrayList;
import java.util.List;

public class LevelManager {

    private PlayerController player;
    private CurrentLevel level;

    public LevelManager() throws OutOfBoundsException {
        level = new CurrentLevel();
    }

    public PlayerController getPlayer() {
        return player;
    }

    public void setPlayer(PlayerController player) {
        this.player = player;
    }

    public CurrentLevel getLevel() {
        return level;
    }

    public void setLevel(CurrentLevel level) {
        this.level = level;
    }
}
