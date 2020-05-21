package com.quadrivium.g13.controller;

import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.quadrivium.g13.exceptions.OutOfBoundsException;
import com.quadrivium.g13.model.*;
import com.quadrivium.g13.view.LanternaMenuView;
import com.quadrivium.g13.view.LanternaPlayerView;
import com.quadrivium.g13.view.MenuView;
import com.quadrivium.g13.view.PlayerView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


import static org.junit.Assert.*;

public class TestInputMenu {

    private MenuController menu;

    @Before
    public void setUp() throws OutOfBoundsException {
        GameDimensions.setWidth(125);
        GameDimensions.setHeight(41);
        TerminalScreen screenMock = Mockito.mock(TerminalScreen.class);

        GameScreen.setScreen((screenMock));
        PlayerController player = new PlayerController(new Player(new Position(1, 1)), new LanternaPlayerView()); //Top left corner
        menu = new MenuController(new Menu(), new LanternaMenuView());
        menu.setPlayer(player);
    }

    @Test
    public void moveUp() throws OutOfBoundsException {
        KeyPress key = KeyPress.UP;
        menu.handleKey(key);
        assertEquals(new Position(1, 1), menu.getPlayer().getPosition()); //Can't move further up (border)
    }

    @Test
    public void moveRight() throws OutOfBoundsException {
        KeyPress key = KeyPress.RIGHT;
        menu.handleKey(key);
        assertEquals(new Position(2, 1), menu.getPlayer().getPosition());
    }

    @Test
    public void moveLeft() throws OutOfBoundsException {
        KeyPress key = KeyPress.LEFT;
        menu.handleKey(key);
        assertEquals(new Position(1, 1), menu.getPlayer().getPosition()); //Can't move further left (border)
    }

    @Test
    public void moveDown() throws OutOfBoundsException {
        KeyPress key = KeyPress.DOWN;
        menu.handleKey(key);
        assertEquals(new Position(1, 2), menu.getPlayer().getPosition());
    }
}
