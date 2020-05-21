package com.quadrivium.g13.model;

import com.googlecode.lanterna.screen.TerminalScreen;
import com.quadrivium.g13.exceptions.OutOfBoundsException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class TestBattleTanks {

    private BattleTanks bt;

    @Before
    public void setUp() {
        GameDimensions.setWidth(125);
        GameDimensions.setHeight(41);
        TerminalScreen screenMock = Mockito.mock(TerminalScreen.class);

        GameScreen.setScreen((screenMock));
        bt = new BattleTanks();
    }

    @Test
    public void getPlayerLives(){
        bt.setPlayerLives(3);
        assertEquals(3, bt.getPlayerLives());
    }

    @Test
    public void getScore() {
        bt.setScore(0);
        assertEquals(0, bt.getScore());
    }

    @Test
    public void getLives(){
        bt.setAllEnemiesKilled(true);
        assertEquals(true, bt.isAllEnemiesKilled());
    }
}
