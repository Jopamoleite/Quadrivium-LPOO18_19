package com.quadrivium.g13.model;

import com.googlecode.lanterna.screen.TerminalScreen;
import com.quadrivium.g13.exceptions.OutOfBoundsException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class TestWall {

    private Wall wall;

    @Before
    public void setUp() throws OutOfBoundsException {
        GameDimensions.setWidth(125);
        GameDimensions.setHeight(41);
        TerminalScreen screenMock = Mockito.mock(TerminalScreen.class);

        GameScreen.setScreen((screenMock));
        wall = new Wall(new Position(1, 1));
    }

    @Test
    public void getString() {
        wall.setWallStr("B");
        assertEquals("B", wall.getWallStr());
    }

    @Test
    public void getColor() {
        wall.setColor("#FF00FF");
        assertEquals("#FF00FF", wall.getColor());
    }
}
