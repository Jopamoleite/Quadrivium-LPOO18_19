package com.quadrivium.g13.model;

public class BattleTanksEnemy extends Element {
    private boolean alive;

    public BattleTanksEnemy(Position position) {
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
