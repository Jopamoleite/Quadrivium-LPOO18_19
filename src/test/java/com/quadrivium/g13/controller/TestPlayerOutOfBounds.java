package com.quadrivium.g13.controller;

import com.googlecode.lanterna.screen.TerminalScreen;
import com.quadrivium.g13.exceptions.OutOfBoundsException;
import com.quadrivium.g13.model.*;
import com.quadrivium.g13.view.LanternaMenuView;
import com.quadrivium.g13.view.LanternaPlayerView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

public class TestPlayerOutOfBounds {
    private PlayerController player;

    @Before
    public void setUp() throws OutOfBoundsException {
        GameDimensions.setWidth(125);
        GameDimensions.setHeight(41);
        TerminalScreen screenMock = Mockito.mock(TerminalScreen.class);

        GameScreen.setScreen((screenMock));
        player = new PlayerController(new Player(new Position(1, 1)), new LanternaPlayerView());
    }

    @Test(expected = OutOfBoundsException.class)
    public void negativeX() throws OutOfBoundsException {
        Position outOfBounds = new Position(-5, 5);
        player.setPosition(outOfBounds);
    }

    @Test(expected = OutOfBoundsException.class)
    public void negativeY() throws OutOfBoundsException {
        Position outOfBounds = new Position(5, -5);
        player.setPosition(outOfBounds);
    }

    @Test(expected = OutOfBoundsException.class)
    public void xTooBig() throws OutOfBoundsException {
        Position outOfBounds = new Position(GameDimensions.getWidth()+5, 10);
        player.setPosition(outOfBounds);
    }

    @Test(expected = OutOfBoundsException.class)
    public void yTooBig() throws OutOfBoundsException {
        Position outOfBounds = new Position(15, GameDimensions.getHeight());
        player.setPosition(outOfBounds);
    }
}
