package com.quadrivium.g13.model;

import com.googlecode.lanterna.screen.TerminalScreen;
import com.quadrivium.g13.exceptions.InvalidGameException;
import com.quadrivium.g13.exceptions.OutOfBoundsException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestEnemyFactory {

    @Before
    public void setUp() {
        GameDimensions.setWidth(125);
        GameDimensions.setHeight(41);
        TerminalScreen screenMock = Mockito.mock(TerminalScreen.class);

        GameScreen.setScreen((screenMock));
    }

    @Test
    public void createBTEnemy() throws OutOfBoundsException, InvalidGameException {
        GetEnemyFactory factory = new GetEnemyFactory();
        Enemy enemy = factory.generateEnemy(new Position(1, 1),"BT");
        assertEquals(BattleTanksEnemy.class, enemy.getClass());

        assertEquals(true, enemy.isAlive());
        enemy.setAlive(false);
        assertNotEquals(true, enemy.isAlive());
    }

    @Test
    public void createLCEnemy() throws OutOfBoundsException, InvalidGameException {
        GetEnemyFactory factory = new GetEnemyFactory();
        Enemy enemy = factory.generateEnemy(new Position(1, 1),"LC");
        assertEquals(LightCyclesEnemy.class, enemy.getClass());
    }

    @Test(expected = InvalidGameException.class)
    public void createInvalidEnemy() throws OutOfBoundsException, InvalidGameException {
        GetEnemyFactory factory = new GetEnemyFactory();
        Enemy enemy = factory.generateEnemy(new Position(1, 1),"OLA");
        assertEquals(BattleTanksEnemy.class, enemy.getClass());
    }
}
