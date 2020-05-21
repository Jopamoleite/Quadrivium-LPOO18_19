package com.quadrivium.g13.model;

import com.googlecode.lanterna.screen.TerminalScreen;
import com.quadrivium.g13.exceptions.OutOfBoundsException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;

public class TestElement {

    private Player player;

    @Before
    public void setUp() throws OutOfBoundsException {
        GameDimensions.setWidth(125);
        GameDimensions.setHeight(41);
        TerminalScreen screenMock = Mockito.mock(TerminalScreen.class);

        GameScreen.setScreen((screenMock));
        player = new Player(new Position(5, 5));
    }

    @Test
    public void testMoveUp()  {
        player.moveUp();
        assertNotEquals(new Position(5, 4), player.getPosition());
    }

    @Test
    public void testMoveRight()  {
        player.moveRight();
        assertNotEquals(new Position(6, 5), player.getPosition());
    }

    @Test
    public void testMoveDown()  {
        player.moveDown();
        assertNotEquals(new Position(5, 6), player.getPosition());
    }

    @Test
    public void testMoveLeft()  {
        player.moveLeft();
        assertNotEquals(new Position(4, 5), player.getPosition());
    }
}
