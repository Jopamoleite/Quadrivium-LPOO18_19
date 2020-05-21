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
import static org.junit.Assert.assertNotEquals;

public class TestInputLightCycles {
    private LightCyclesController lc;

    @Before
    public void setUp() throws OutOfBoundsException, InvalidGameException {
        GameDimensions.setWidth(125);
        GameDimensions.setHeight(41);
        TerminalScreen screenMock = Mockito.mock(TerminalScreen.class);

        GameScreen.setScreen((screenMock));
        PlayerController player = new PlayerController(new Player(new Position(GameDimensions.getWidth()-2, 13)), new LanternaPlayerView());
        player.resetPosition();
        lc = new LightCyclesController(new LightCycles(), new LanternaLightCyclesView());
        lc.setPlayer(player);
    }

    @Test
    public void moveUp(){
        lc.getCurrentDirection();
        assertNotEquals(LightCycles.Direction.UP, lc.getCurrentDirection());

        KeyPress key = KeyPress.UP;
        lc.handleKey(key);
        lc.getCurrentDirection();
        assertNotEquals(LightCycles.Direction.UP, lc.getCurrentDirection()); //Can't change direction from DOWN (base) to UP
    }

    @Test
    public void moveRight(){
        lc.getCurrentDirection();
        assertNotEquals(LightCycles.Direction.RIGHT, lc.getCurrentDirection());

        KeyPress key = KeyPress.RIGHT;
        lc.handleKey(key);
        lc.getCurrentDirection();
        assertEquals(LightCycles.Direction.RIGHT, lc.getCurrentDirection());
    }

    @Test
    public void moveLeft(){
        lc.getCurrentDirection();
        assertNotEquals(LightCycles.Direction.LEFT, lc.getCurrentDirection());

        KeyPress key = KeyPress.LEFT;
        lc.handleKey(key);
        lc.getCurrentDirection();
        assertEquals(LightCycles.Direction.LEFT, lc.getCurrentDirection());
    }

    @Test
    public void moveDown(){
        lc.getCurrentDirection();
        assertEquals(LightCycles.Direction.DOWN, lc.getCurrentDirection());

        KeyPress key = KeyPress.DOWN;
        lc.handleKey(key);
        lc.getCurrentDirection();
        assertEquals(LightCycles.Direction.DOWN, lc.getCurrentDirection());
    }
}
