package com.quadrivium.g13.controller;

import com.quadrivium.g13.exceptions.InvalidGameException;
import com.quadrivium.g13.exceptions.OutOfBoundsException;
import com.quadrivium.g13.model.GameResult;
import com.quadrivium.g13.model.KeyPress;

import java.io.IOException;

public interface GameController {
    void setPlayer(PlayerController player);
    void draw();
    boolean checkEnter(KeyPress key, CurrentLevel level) throws OutOfBoundsException, InvalidGameException;
    GameResult play(CurrentLevel level) throws IOException, InterruptedException, OutOfBoundsException, InvalidGameException;
}
