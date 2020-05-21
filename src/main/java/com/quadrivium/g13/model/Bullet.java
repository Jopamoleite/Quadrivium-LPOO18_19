package com.quadrivium.g13.model;

public class Bullet {
    private char direction;
    private Position position;

    public Bullet() {
    }

    public Bullet(char direction, Position position) {
        this.direction = direction;
        this.position = position;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
