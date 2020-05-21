package com.quadrivium.g13.model;

import com.quadrivium.g13.controller.PlayerController;

public class IOTower {
    private PlayerController player;

    public IOTower() {
    }

    public PlayerController getPlayer() {
        return player;
    }

    public void setPlayer(PlayerController player) {
        this.player = player;
    }
}
