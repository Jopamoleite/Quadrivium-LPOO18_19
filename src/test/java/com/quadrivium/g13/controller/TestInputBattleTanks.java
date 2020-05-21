package com.quadrivium.g13.controller;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.quadrivium.g13.model.BattleTanks;
import com.quadrivium.g13.model.CreateGame;
import com.quadrivium.g13.model.Player;
import com.quadrivium.g13.model.Position;
import com.quadrivium.g13.view.BattleTanksView;
import com.quadrivium.g13.view.PlayerView;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestInputBattleTanks {
    BattleTanksController bt;

    @Before
    public void setUp() {
        CreateGame game = new CreateGame();
        game.initGame();
        PlayerController player = new PlayerController(new Player(new Position(75, 20)), new PlayerView());
        bt = new BattleTanksController(new BattleTanks(), new BattleTanksView());
        bt.setPlayer(player);
    }

    @Test
    public void moveUp() {
        KeyStroke key = new KeyStroke(KeyType.ArrowUp);
        bt.processKey(key);
        assertEquals(new Position(75, 19), bt.getPlayer().getPosition());
    }

    @Test
    public void moveRight() {
        KeyStroke key = new KeyStroke(KeyType.ArrowRight);
        bt.processKey(key);
        assertEquals(new Position(76, 20), bt.getPlayer().getPosition());
    }

    @Test
    public void moveLeft() {
        KeyStroke key = new KeyStroke(KeyType.ArrowLeft);
        bt.processKey(key);
        assertEquals(new Position(74, 20), bt.getPlayer().getPosition());
    }

    @Test
    public void moveDown() {
        KeyStroke key = new KeyStroke(KeyType.ArrowDown);
        bt.processKey(key);
        assertEquals(new Position(75, 21), bt.getPlayer().getPosition());
    }
}
