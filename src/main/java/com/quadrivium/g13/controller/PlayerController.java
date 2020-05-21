package com.quadrivium.g13.controller;

import com.quadrivium.g13.model.Player;
import com.quadrivium.g13.model.Position;
import com.quadrivium.g13.view.PlayerView;

public class PlayerController {
    Player model;
    PlayerView view;

    public PlayerController(Player model, PlayerView view) {
        this.model = model;
        this.view = view;
    }

    public int getLives() {
        return model.getLives();
    }

    public void setLives(int lives) {
        model.setLives(lives);
    }

    public void resetPosition() {
        this.setPosition(model.getStartingPos());
    }

    public Position getPosition() {
        return model.getPosition();
    }

    public void setPosition(Position position) {
        model.setPosition(position);
    }

    public Position moveUp() {
        return new Position(model.getPosition().getX(), model.getPosition().getY() - 1);
    }

    public Position moveDown() {
        return new Position(model.getPosition().getX(), model.getPosition().getY() + 1);
    }

    public Position moveRight() {
        return new Position(model.getPosition().getX() + 1, model.getPosition().getY());
    }

    public Position moveLeft() {
        return new Position(model.getPosition().getX() - 1, model.getPosition().getY());
    }

    public void decreaseLives() {
        model.setLives(model.getLives() - 1);
    }

    public void draw() {
        view.draw(model.getPosition());
    }

}
