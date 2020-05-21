package com.quadrivium.g13.model;

import com.googlecode.lanterna.screen.TerminalScreen;
import com.quadrivium.g13.exceptions.OutOfBoundsException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class TestSector {

    private Sector sect;

    @Before
    public void setUp() throws OutOfBoundsException {
        GameDimensions.setWidth(125);
        GameDimensions.setHeight(41);
        TerminalScreen screenMock = Mockito.mock(TerminalScreen.class);

        GameScreen.setScreen((screenMock));
        sect = new Sector(new Position(1, 1),"#FFFFFF", "A");
    }

    @Test
    public void getString() {
        sect.setSectorStr("B");
        assertEquals("B", sect.getSectorStr());
    }

    @Test
    public void getColor() {
        sect.setColor("#FF00FF");
        assertEquals("#FF00FF", sect.getColor());
    }
}
