package com.quadrivium.g13.model;

import com.quadrivium.g13.exceptions.OutOfBoundsException;

public class Player extends Element{
    private int lives;
    private Position startingPos;

    public Player(Position pos) throws OutOfBoundsException {
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

    public void setStartingPos(Position startingPos) throws OutOfBoundsException {
        if(startingPos.getX() < 0 || startingPos.getY() < 0 || startingPos.getX() > GameDimensions.getWidth() || startingPos.getY() > GameDimensions.getHeight()){
            throw new OutOfBoundsException();
        }else{
            this.startingPos = startingPos;
        }
    }
}
