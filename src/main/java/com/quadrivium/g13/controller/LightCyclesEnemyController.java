package com.quadrivium.g13.controller;

import com.quadrivium.g13.model.LightCyclesEnemy;
import com.quadrivium.g13.model.Position;
import com.quadrivium.g13.view.LightCyclesEnemyView;

public class LightCyclesEnemyController {

    LightCyclesEnemy model;
    LightCyclesEnemyView view;

    public LightCyclesEnemyController(LightCyclesEnemy model, LightCyclesEnemyView view) {
        this.model = model;
        this.view = view;
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

    public boolean isAlive() {
        return model.isAlive();
    }

    public void setAlive(boolean status) {
        model.setAlive(status);
    }

    public void draw() {
        view.draw(model.getPosition());
    }

}
