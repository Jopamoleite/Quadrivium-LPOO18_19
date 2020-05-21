package com.quadrivium.g13.controller;

import com.googlecode.lanterna.screen.TerminalScreen;
import com.quadrivium.g13.exceptions.InvalidGameException;
import com.quadrivium.g13.exceptions.OutOfBoundsException;
import com.quadrivium.g13.model.*;
import com.quadrivium.g13.view.LanternaBattleTanksView;
import com.quadrivium.g13.view.LanternaPlayerView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class TestInputBattleTanks {
    private BattleTanksController bt;

    @Before
    public void setUp() throws OutOfBoundsException, InvalidGameException {
        GameDimensions.setWidth(125);
        GameDimensions.setHeight(41);
        TerminalScreen screenMock = Mockito.mock(TerminalScreen.class);

        GameScreen.setScreen((screenMock));
        PlayerController player = new PlayerController(new Player(new Position(30, 19)), new LanternaPlayerView());
        bt = new BattleTanksController(new BattleTanks(), new LanternaBattleTanksView());
        bt.setPlayer(player);
    }

    @Test
    public void moveUp() throws OutOfBoundsException {
        KeyPress key = KeyPress.UP;
        bt.handleKey(key);
        assertEquals(new Position(30, 18), bt.getPlayer().getPosition());
    }

    @Test
    public void moveRight() throws OutOfBoundsException {
        KeyPress key = KeyPress.RIGHT;
        bt.handleKey(key);
        assertEquals(new Position(31, 19), bt.getPlayer().getPosition());
    }

    @Test
    public void moveDown() throws OutOfBoundsException {
        KeyPress key = KeyPress.DOWN;
        bt.handleKey(key);
        assertEquals(new Position(30, 20), bt.getPlayer().getPosition());
    }

    @Test
    public void moveLeft() throws OutOfBoundsException {
        KeyPress key = KeyPress.LEFT;
        bt.handleKey(key);
        assertEquals(new Position(29, 19), bt.getPlayer().getPosition());
    }
}
