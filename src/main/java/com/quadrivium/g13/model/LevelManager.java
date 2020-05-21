package com.quadrivium.g13.model;

import com.quadrivium.g13.controller.CurrentLevel;
import com.quadrivium.g13.controller.PlayerController;

import java.util.ArrayList;
import java.util.List;

public class LevelManager {

    private int difficulty;
    private List<Boolean> passedLevels = new ArrayList<>();
    private PlayerController player;
    private CurrentLevel level;

    public LevelManager() {
        level = new CurrentLevel();
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public List<Boolean> getPassedLevels() {
        return passedLevels;
    }

    public void setPassedLevels(List<Boolean> passedLevels) {
        this.passedLevels = passedLevels;
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
