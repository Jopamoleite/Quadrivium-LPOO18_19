package com.quadrivium.g13.model;

import com.googlecode.lanterna.screen.TerminalScreen;
import com.quadrivium.g13.controller.PlayerController;
import com.quadrivium.g13.exceptions.OutOfBoundsException;
import com.quadrivium.g13.view.LanternaPlayerView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestBullet {

    private Bullet bullet;

    @Before
    public void setUp() throws OutOfBoundsException {
        GameDimensions.setWidth(125);
        GameDimensions.setHeight(41);
        TerminalScreen screenMock = Mockito.mock(TerminalScreen.class);

        GameScreen.setScreen((screenMock));

        bullet = Bullet.bulletFromPlayer(new PlayerController(new Player(new Position(1, 1)), new LanternaPlayerView()), 'U');
    }

    @Test
    public void testBulletDirection() {
        bullet.setDirection('D');
        assertEquals('D', bullet.getDirection());
    }
}
