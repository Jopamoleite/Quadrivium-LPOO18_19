package com.quadrivium.g13.controller;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.quadrivium.g13.exceptions.OutOfBoundsException;
import com.quadrivium.g13.model.*;
import com.quadrivium.g13.view.IOTowerView;
import com.quadrivium.g13.view.LanternaIOTowerView;
import com.quadrivium.g13.view.LanternaPlayerView;
import com.quadrivium.g13.view.PlayerView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class TestInputIOTower {
    private IOTowerController iot;


    @Before
    public void setUp() throws OutOfBoundsException {
        GameDimensions.setWidth(125);
        GameDimensions.setHeight(41);
        TerminalScreen screenMock = Mockito.mock(TerminalScreen.class);

        GameScreen.setScreen((screenMock));
        PlayerController player = new PlayerController(new Player(new Position(GameDimensions.getWidth()-2, GameDimensions.getHeight()-2)), new LanternaPlayerView()); //Bottom right corner
        iot = new IOTowerController(new IOTower(), new LanternaIOTowerView());
        iot.setPlayer(player);
    }

    @Test
    public void moveUp() throws OutOfBoundsException {
        KeyPress key = KeyPress.UP;
        iot.handleKey(key);
        assertEquals(new Position(GameDimensions.getWidth()-2, GameDimensions.getHeight()-3), iot.getPlayer().getPosition());
    }

    @Test
    public void moveRight() throws OutOfBoundsException {
        KeyPress key = KeyPress.RIGHT;
        iot.handleKey(key);
        assertEquals(new Position(GameDimensions.getWidth()-2, GameDimensions.getHeight()-2), iot.getPlayer().getPosition()); //Can't move further right (border)
    }

    @Test
    public void moveLeft() throws OutOfBoundsException {
        KeyPress key = KeyPress.LEFT;
        iot.handleKey(key);
        assertEquals(new Position(GameDimensions.getWidth()-3, GameDimensions.getHeight()-2), iot.getPlayer().getPosition());
    }

    @Test
    public void moveDown() throws OutOfBoundsException {
        KeyPress key = KeyPress.DOWN;
        iot.handleKey(key);
        assertEquals(new Position(GameDimensions.getWidth()-2, GameDimensions.getHeight()-2), iot.getPlayer().getPosition()); //Can't move further down (border)
    }
}
