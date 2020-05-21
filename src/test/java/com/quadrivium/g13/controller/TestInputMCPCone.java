package com.quadrivium.g13.controller;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.quadrivium.g13.model.*;
import com.quadrivium.g13.view.MenuView;
import com.quadrivium.g13.view.PlayerView;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestInputMCPCone {
    MenuController menu;

    @Before
    public void setUp() {
        CreateGame game = new CreateGame();
        game.initGame();
        PlayerController player = new PlayerController(new Player(new Position(103, GameDimensions.getHeight() - 2)), new PlayerView());
        menu = new MenuController(new Menu(), new MenuView());
        menu.setPlayer(player);
    }

    @Test
    public void moveUp() {
        KeyStroke key = new KeyStroke(KeyType.ArrowUp);
        menu.processKey(key);
        assertEquals(new Position(103, GameDimensions.getHeight() - 3), menu.getPlayer().getPosition());
    }

    @Test
    public void moveRight() {
        KeyStroke key = new KeyStroke(KeyType.ArrowRight);
        menu.processKey(key);
        assertEquals(new Position(104, GameDimensions.getHeight() - 2), menu.getPlayer().getPosition());
    }

    @Test
    public void moveLeft() {
        KeyStroke key = new KeyStroke(KeyType.ArrowLeft);
        menu.processKey(key);
        assertEquals(new Position(102, GameDimensions.getHeight() - 2), menu.getPlayer().getPosition());
    }

    @Test
    public void moveDown() {
        KeyStroke key = new KeyStroke(KeyType.ArrowDown);
        menu.processKey(key);
        assertEquals(new Position(103, GameDimensions.getHeight() - 2), menu.getPlayer().getPosition());
    }
}
