package com.quadrivium.g13.model;

public class Player extends Element {
    private int lives;
    private Position startingPos;

    public Player(Position pos) {
        this.lives = 3;
        this.setPosition(pos);
        this.startingPos = pos;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public Position getStartingPos() {
        return startingPos;
    }

    public void setStartingPos(Position startingPos) {
        this.startingPos = startingPos;
    }
}
