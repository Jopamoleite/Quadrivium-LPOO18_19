package com.quadrivium.g13.model;

import com.quadrivium.g13.exceptions.*;

public class GetEnemyFactory {
    public static Enemy generateEnemy(Position pos, String game) throws OutOfBoundsException, InvalidGameException {
        if(game.equals("LC"))
            return new LightCyclesEnemy(new Position(pos));
        else if (game.equals("BT"))
            return new BattleTanksEnemy(new Position(pos));

        throw new InvalidGameException();
    }
}
