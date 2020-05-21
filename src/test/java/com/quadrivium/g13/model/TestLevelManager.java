package com.quadrivium.g13.model;

import com.googlecode.lanterna.screen.TerminalScreen;
import com.quadrivium.g13.controller.CurrentLevel;
import com.quadrivium.g13.controller.MenuController;
import com.quadrivium.g13.controller.PlayerController;
import com.quadrivium.g13.exceptions.OutOfBoundsException;
import com.quadrivium.g13.view.LanternaMenuView;
import com.quadrivium.g13.view.LanternaPlayerView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class TestLevelManager {

    private LevelManager manager;

    @Before
    public void setUp() throws OutOfBoundsException {
        GameDimensions.setWidth(125);
        GameDimensions.setHeight(41);
        TerminalScreen screenMock = Mockito.mock(TerminalScreen.class);

        GameScreen.setScreen((screenMock));
        manager = new LevelManager();
    }

    @Test
    public void getLevel() throws OutOfBoundsException {
        CurrentLevel level = new CurrentLevel();
        level.setPlayer(new PlayerController(new Player(new Position(1, 1)), new LanternaPlayerView()));
        level.setActiveGame(new MenuController(new Menu(), new LanternaMenuView()));
        manager.setLevel(level);
        assertEquals(MenuController.class, manager.getLevel().getActiveGame().getClass());
    }

    @Test
    public void getPlayer() throws OutOfBoundsException {
        manager.setPlayer(new PlayerController(new Player(new Position(1, 1)), new LanternaPlayerView()));
        assertEquals(new Position(1, 1), manager.getPlayer().getPosition());
    }
}
