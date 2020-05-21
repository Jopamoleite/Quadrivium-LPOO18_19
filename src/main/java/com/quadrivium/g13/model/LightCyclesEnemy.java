package com.quadrivium.g13.model;

import com.quadrivium.g13.exceptions.OutOfBoundsException;

public class LightCyclesEnemy extends Enemy{

    private boolean alive;

    public LightCyclesEnemy(Position position) throws OutOfBoundsException {
        this.setPosition(position);
        this.alive = true;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
