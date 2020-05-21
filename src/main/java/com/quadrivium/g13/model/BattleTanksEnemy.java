package com.quadrivium.g13.model;

import com.quadrivium.g13.exceptions.OutOfBoundsException;

public class BattleTanksEnemy extends Enemy {

    private boolean isAlive;

    public BattleTanksEnemy(Position position) throws OutOfBoundsException {
        this.setPosition(position);
        isAlive = true;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public void setAlive(boolean alive) {
        this.isAlive = alive;
    }
}
