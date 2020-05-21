package com.quadrivium.g13.controller;

import com.quadrivium.g13.model.GameResult;
import com.quadrivium.g13.model.KeyPress;

import java.io.IOException;

public interface GameController {
    void setPlayer(PlayerController player);

    void draw();

    void update();

    boolean checkEnter(KeyPress key, CurrentLevel level);

    GameResult play(CurrentLevel level) throws IOException, InterruptedException;
}
