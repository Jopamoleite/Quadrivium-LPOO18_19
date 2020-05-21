package com.quadrivium.g13.model;

import com.quadrivium.g13.controller.PlayerController;

import java.util.List;

public class Menu {
    private List<List<Sector>> sectors;
    private PlayerController player;

    public Menu() {
    }

    public List<List<Sector>> getSectors() {
        return sectors;
    }

    public void setSectors(List<List<Sector>> sectors) {
        this.sectors = sectors;
    }

    public PlayerController getPlayer() {
        return player;
    }

    public void setPlayer(PlayerController player) {
        this.player = player;
    }
}
