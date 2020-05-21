package com.quadrivium.g13.controller;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.quadrivium.g13.model.*;
import com.quadrivium.g13.view.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLevelChanges {
    CurrentLevel level;

    @Before
    public void setUp() {
        CreateGame game = new CreateGame();
        game.initGame();
        PlayerController player = new PlayerController(new Player(new Position(GameDimensions.getWidth() / 2, GameDimensions.getHeight() / 2)), new PlayerView());
        level = new CurrentLevel();
        level.setPlayer(player);
    }

    @Test
    public void btToMenu() {
        KeyStroke key = new KeyStroke(KeyType.Enter);
        level.setActiveGame(new BattleTanksController(new BattleTanks(), new BattleTanksView()));
        level.getActiveGame().checkEnter(key, level);
        assertEquals(MenuController.class, level.getActiveGame().getClass());
    }

    @Test
    public void iotToMenu() {
        KeyStroke key = new KeyStroke(KeyType.Enter);
        level.setActiveGame(new IOTowerController(new IOTower(), new IOTowerView()));
        level.getActiveGame().checkEnter(key, level);
        assertEquals(MenuController.class, level.getActiveGame().getClass());
    }

    @Test
    public void lcToMenu() {
        KeyStroke key = new KeyStroke(KeyType.Enter);
        level.setActiveGame(new LightCyclesController(new LightCycles(), new LightCyclesView()));
        level.getActiveGame().checkEnter(key, level);
        assertEquals(MenuController.class, level.getActiveGame().getClass());
    }

    @Test
    public void mcpcToMenu() {
        KeyStroke key = new KeyStroke(KeyType.Enter);
        level.setActiveGame(new MCPConeController(new MCPCone(), new MCPConeView()));
        level.getActiveGame().checkEnter(key, level);
        assertEquals(MenuController.class, level.getActiveGame().getClass());
    }

    @Test
    public void menuToBT() {
        KeyStroke key = new KeyStroke(KeyType.Enter);
        level.getPlayer().setPosition(new Position(GameDimensions.getWidth() / 2, GameDimensions.getHeight() / 2 - 5));
        level.getActiveGame().setPlayer(level.getPlayer());
        level.getActiveGame().checkEnter(key, level);
        assertEquals(BattleTanksController.class, level.getActiveGame().getClass());
    }

    @Test
    public void menuToIOT() {
        KeyStroke key = new KeyStroke(KeyType.Enter);
        level.getPlayer().setPosition(new Position(GameDimensions.getWidth() / 2 + 5, GameDimensions.getHeight() / 2));
        level.getActiveGame().setPlayer(level.getPlayer());
        level.getActiveGame().checkEnter(key, level);
        assertEquals(IOTowerController.class, level.getActiveGame().getClass());
    }

    @Test
    public void menuToLC() {
        KeyStroke key = new KeyStroke(KeyType.Enter);
        level.getPlayer().setPosition(new Position(GameDimensions.getWidth() / 2 - 5, GameDimensions.getHeight() / 2));
        level.getActiveGame().setPlayer(level.getPlayer());
        level.getActiveGame().checkEnter(key, level);
        assertEquals(LightCyclesController.class, level.getActiveGame().getClass());
    }

    @Test
    public void menuToMCPC() {
        KeyStroke key = new KeyStroke(KeyType.Enter);
        level.getPlayer().setPosition(new Position(GameDimensions.getWidth() / 2, GameDimensions.getHeight() / 2 + 5));
        level.getActiveGame().setPlayer(level.getPlayer());
        level.getActiveGame().checkEnter(key, level);
        assertEquals(MCPConeController.class, level.getActiveGame().getClass());
    }

}
