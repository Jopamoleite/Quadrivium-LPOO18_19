package com.quadrivium.g13.model;

import com.quadrivium.g13.exceptions.OutOfBoundsException;

public abstract class Element {
    private Position position;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) throws OutOfBoundsException {
        if(position.getX() < 0 || position.getY() < 0 || position.getX() >= GameDimensions.getWidth() || position.getY() >= GameDimensions.getHeight()){
            throw new OutOfBoundsException();
        }
        this.position = position;
    }

    public Position moveUp() {
        return new Position(getPosition().getX(), getPosition().getY() - 1);
    }
    public Position moveDown() {
        return new Position(getPosition().getX(), getPosition().getY() + 1);
    }
    public Position moveRight() {
        return new Position(getPosition().getX() + 1, getPosition().getY());
    }
    public Position moveLeft() {
        return new Position(getPosition().getX() - 1, getPosition().getY());
    }
}
