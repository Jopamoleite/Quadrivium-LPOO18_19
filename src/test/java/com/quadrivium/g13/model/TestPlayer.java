package com.quadrivium.g13.model;

import com.googlecode.lanterna.screen.TerminalScreen;
import com.quadrivium.g13.exceptions.OutOfBoundsException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestPlayer {

    private Player player;

    @Before
    public void setUp() throws OutOfBoundsException {
        GameDimensions.setWidth(125);
        GameDimensions.setHeight(41);
        TerminalScreen screenMock = Mockito.mock(TerminalScreen.class);

        GameScreen.setScreen((screenMock));
        player = new Player(new Position(1, 1));
    }

    @Test(expected = OutOfBoundsException.class)
    public void startingXTooLow() throws OutOfBoundsException {
        Position outOfBounds = new Position(-5, 5);
        player.setStartingPos(outOfBounds);
        assertNotEquals(outOfBounds, player.getStartingPos());
    }

    @Test(expected = OutOfBoundsException.class)
    public void startingXTooHigh() throws OutOfBoundsException {
        Position outOfBounds = new Position(GameDimensions.getWidth()+5, 5);
        player.setStartingPos(outOfBounds);
        assertNotEquals(outOfBounds, player.getStartingPos());
    }

    @Test(expected = OutOfBoundsException.class)
    public void startingYTooLow() throws OutOfBoundsException {
        Position outOfBounds = new Position(5, -5);
        player.setStartingPos(outOfBounds);
        assertNotEquals(outOfBounds, player.getStartingPos());
    }

    @Test(expected = OutOfBoundsException.class)
    public void startingYTooHigh() throws OutOfBoundsException {
        Position outOfBounds = new Position(5, GameDimensions.getHeight()+5);
        player.setStartingPos(outOfBounds);
        assertNotEquals(outOfBounds, player.getStartingPos());
    }

    @Test
    public void getLives(){
        assertEquals(3, player.getLives());
    }

    @Test
    public void getStartingPos() throws OutOfBoundsException {
        Position position = new Position(25, 25);
        player.setStartingPos(position);
        assertEquals(position, player.getStartingPos());
    }
}
