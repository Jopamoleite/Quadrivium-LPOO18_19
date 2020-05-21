package com.quadrivium.g13.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCreateGame {

    @Test
    public void getWidth() {
        CreateGame game = new CreateGame();

        game.setDimensions();

        assertEquals(125, GameDimensions.getWidth());
    }

    @Test
    public void getHeight() {
        CreateGame game = new CreateGame();

        game.setDimensions();

        assertEquals(41, GameDimensions.getHeight());
    }
}
