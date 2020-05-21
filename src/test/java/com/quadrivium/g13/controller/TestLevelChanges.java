package com.quadrivium.g13.controller;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.quadrivium.g13.exceptions.InvalidGameException;
import com.quadrivium.g13.exceptions.OutOfBoundsException;
import com.quadrivium.g13.model.*;
import com.quadrivium.g13.view.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class TestLevelChanges {
    private CurrentLevel level;

    @Before
    public void setUp() throws OutOfBoundsException {
        GameDimensions.setWidth(125);
        GameDimensions.setHeight(41);
        TerminalScreen screenMock = Mockito.mock(TerminalScreen.class);

        GameScreen.setScreen((screenMock));
        PlayerController player = new PlayerController(new Player(new Position(GameDimensions.getWidth()/2, GameDimensions.getHeight()/2)), new LanternaPlayerView());
        level = new CurrentLevel();
        level.setPlayer(player);
    }

    @Test
    public void loseToMenu() throws OutOfBoundsException, InvalidGameException {
        KeyPress key = KeyPress.ENTER;
        level.setActiveGame(new LoseScreenController(new LoseScreen(), new LanternaLoseScreenView()));
        boolean check = level.getActiveGame().checkEnter(key, level);
        assertEquals(true, check);
        assertEquals(MenuController.class, level.getActiveGame().getClass());
    }

    @Test
    public void winToMenu() throws OutOfBoundsException, InvalidGameException {
        KeyPress key = KeyPress.ENTER;
        level.setActiveGame(new WinScreenController(new WinScreen(), new LanternaWinScreenView()));
        boolean check = level.getActiveGame().checkEnter(key, level);
        assertEquals(true, check);
        assertEquals(MenuController.class, level.getActiveGame().getClass());
    }

    @Test
    public void controlsToMenu() throws OutOfBoundsException, InvalidGameException {
        KeyPress key = KeyPress.ENTER;
        boolean check = level.getActiveGame().checkEnter(key, level);
        assertEquals(true, check);
        assertEquals(MenuController.class, level.getActiveGame().getClass());
    }

    @Test
    public void iotToMenu() throws OutOfBoundsException, InvalidGameException {
        KeyPress key = KeyPress.ENTER;
        level.setActiveGame(new IOTowerController(new IOTower(), new LanternaIOTowerView()));
        boolean check = level.getActiveGame().checkEnter(key, level);
        assertEquals(true, check);
        assertEquals(MenuController.class, level.getActiveGame().getClass());
    }

    @Test
    public void mcpcToMenu() throws OutOfBoundsException, InvalidGameException {
        KeyPress key = KeyPress.ENTER;
        level.setActiveGame(new MCPConeController(new MCPCone(), new LanternaMCPConeView()));
        boolean check = level.getActiveGame().checkEnter(key, level);
        assertEquals(true, check);
        assertEquals(MenuController.class, level.getActiveGame().getClass());
    }

    @Test
    public void menuToBT() throws OutOfBoundsException, InvalidGameException {
        KeyPress key = KeyPress.ENTER;
        level.setActiveGame(new MenuController(new Menu(), new LanternaMenuView()));
        level.getPlayer().setPosition(new Position(GameDimensions.getWidth()/2, GameDimensions.getHeight()/2-5));
        level.getActiveGame().setPlayer(level.getPlayer());
        boolean check = level.getActiveGame().checkEnter(key, level);
        assertEquals(true, check);
        assertEquals(BattleTanksController.class, level.getActiveGame().getClass());
    }

    @Test
    public void menuToIOT() throws OutOfBoundsException, InvalidGameException {
        KeyPress key = KeyPress.ENTER;
        level.setActiveGame(new MenuController(new Menu(), new LanternaMenuView()));
        level.getPlayer().setPosition(new Position(GameDimensions.getWidth()/2+5, GameDimensions.getHeight()/2));
        level.getActiveGame().setPlayer(level.getPlayer());
        boolean check = level.getActiveGame().checkEnter(key, level);
        assertEquals(true, check);
        assertEquals(IOTowerController.class, level.getActiveGame().getClass());
    }

    @Test
    public void menuToLC() throws OutOfBoundsException, InvalidGameException {
        KeyPress key = KeyPress.ENTER;
        level.setActiveGame(new MenuController(new Menu(), new LanternaMenuView()));
        level.getPlayer().setPosition(new Position(GameDimensions.getWidth()/2-5, GameDimensions.getHeight()/2));
        level.getActiveGame().setPlayer(level.getPlayer());
        boolean check = level.getActiveGame().checkEnter(key, level);
        assertEquals(true, check);
        assertEquals(LightCyclesController.class, level.getActiveGame().getClass());
    }

    @Test
    public void menuToMCPC() throws OutOfBoundsException, InvalidGameException {
        KeyPress key = KeyPress.ENTER;
        level.setActiveGame(new MenuController(new Menu(), new LanternaMenuView()));
        level.getPlayer().setPosition(new Position(GameDimensions.getWidth()/2, GameDimensions.getHeight()/2+5));
        level.getActiveGame().setPlayer(level.getPlayer());
        boolean check = level.getActiveGame().checkEnter(key, level);
        assertEquals(true, check);
        assertEquals(MCPConeController.class, level.getActiveGame().getClass());
    }
}
