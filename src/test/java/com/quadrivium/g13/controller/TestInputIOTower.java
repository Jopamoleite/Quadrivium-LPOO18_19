package com.quadrivium.g13.controller;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.quadrivium.g13.model.*;
import com.quadrivium.g13.view.IOTowerView;
import com.quadrivium.g13.view.PlayerView;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestInputIOTower {
    IOTowerController iot;

    @Before
    public void setUp() {
        CreateGame game = new CreateGame();
        game.initGame();
        PlayerController player = new PlayerController(new Player(new Position(GameDimensions.getWidth() - 2, GameDimensions.getHeight() - 2)), new PlayerView());
        iot = new IOTowerController(new IOTower(), new IOTowerView());
        iot.setPlayer(player);
    }

    @Test
    public void moveUp() {
        KeyStroke key = new KeyStroke(KeyType.ArrowUp);
        iot.processKey(key);
        assertEquals(new Position(GameDimensions.getWidth() - 2, GameDimensions.getHeight() - 3), iot.getPlayer().getPosition());
    }

    @Test
    public void moveRight() {
        KeyStroke key = new KeyStroke(KeyType.ArrowRight);
        iot.processKey(key);
        assertEquals(new Position(GameDimensions.getWidth() - 2, GameDimensions.getHeight() - 2), iot.getPlayer().getPosition());
    }

    @Test
    public void moveLeft() {
        KeyStroke key = new KeyStroke(KeyType.ArrowLeft);
        iot.processKey(key);
        assertEquals(new Position(GameDimensions.getWidth() - 3, GameDimensions.getHeight() - 2), iot.getPlayer().getPosition());
    }

    @Test
    public void moveDown() {
        KeyStroke key = new KeyStroke(KeyType.ArrowDown);
        iot.processKey(key);
        assertEquals(new Position(GameDimensions.getWidth() - 2, GameDimensions.getHeight() - 2), iot.getPlayer().getPosition());
    }
}
