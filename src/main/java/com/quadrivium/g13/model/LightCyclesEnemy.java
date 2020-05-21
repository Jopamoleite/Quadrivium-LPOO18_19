package com.quadrivium.g13.model;

public class LightCyclesEnemy extends Element {

    private boolean alive;

    public LightCyclesEnemy(Position position) {
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
