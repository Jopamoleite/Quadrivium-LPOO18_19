package com.quadrivium.g13.controller;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.quadrivium.g13.exceptions.OutOfBoundsException;
import com.quadrivium.g13.model.*;
import com.quadrivium.g13.view.LanternaMCPConeView;
import com.quadrivium.g13.view.LanternaPlayerView;
import com.quadrivium.g13.view.MenuView;
import com.quadrivium.g13.view.PlayerView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class TestInputMCPCone {
    private MCPConeController mcp;

    @Before
    public void setUp() throws OutOfBoundsException {
        GameDimensions.setWidth(125);
        GameDimensions.setHeight(41);
        TerminalScreen screenMock = Mockito.mock(TerminalScreen.class);

        GameScreen.setScreen((screenMock));
        PlayerController player = new PlayerController(new Player(new Position(103, GameDimensions.getHeight()-2)), new LanternaPlayerView()); //Touching the border at the bottom
        mcp = new MCPConeController(new MCPCone(), new LanternaMCPConeView());
        mcp.setPlayer(player);
    }

    @Test
    public void moveUp() throws OutOfBoundsException {
        KeyPress key = KeyPress.UP;
        mcp.handleKey(key);
        assertEquals(new Position(103, GameDimensions.getHeight()-3), mcp.getPlayer().getPosition());
    }

    @Test
    public void moveRight() throws OutOfBoundsException {
        KeyPress key = KeyPress.RIGHT;
        mcp.handleKey(key);
        assertEquals(new Position(104, GameDimensions.getHeight()-2), mcp.getPlayer().getPosition());
    }

    @Test
    public void moveLeft() throws OutOfBoundsException {
        KeyPress key = KeyPress.LEFT;
        mcp.handleKey(key);
        assertEquals(new Position(102, GameDimensions.getHeight()-2), mcp.getPlayer().getPosition());
    }

    @Test
    public void moveDown() throws OutOfBoundsException {
        KeyPress key = KeyPress.DOWN;
        mcp.handleKey(key);
        assertEquals(new Position(103, GameDimensions.getHeight()-2), mcp.getPlayer().getPosition());  //Can't move further down (border)
    }
}
