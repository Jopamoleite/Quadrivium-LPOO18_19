package com.quadrivium.g13.controller;

import com.quadrivium.g13.model.*;
import com.quadrivium.g13.view.LanternaLightCyclesEnemyView;
import com.quadrivium.g13.view.LightCyclesEnemyView;
import com.quadrivium.g13.view.LightCyclesView;
import com.quadrivium.g13.view.SwingLightCyclesEnemyView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LightCyclesController implements GameController {
    private LightCycles model;
    private LightCyclesView view;

    public LightCyclesController(LightCycles model, LightCyclesView view) {
        this.model = model;
        this.view = view;
        initEnemy();
        generateMap();
        initTrails();
    }

    public void initEnemy() {
        LightCyclesEnemy model = new LightCyclesEnemy(new Position(GameDimensions.getWidth() / 2, GameDimensions.getHeight() * 3 / 4));
        LightCyclesEnemyView view;
        if (GameDimensions.isSwing())
            view = new SwingLightCyclesEnemyView();
        else
            view = new LanternaLightCyclesEnemyView();
        this.model.setEnemy(new LightCyclesEnemyController(model, view));
        this.model.getEnemy().setAlive(true);
    }

    public void initTrails() {
        List<Wall> newTrails = new ArrayList<>();
        model.setTrails(newTrails);
        List<Wall> newEnemyTrails = new ArrayList<>();
        model.setEnemyTrails(newEnemyTrails);
    }

    public void generateMap() {
        List<Wall> newWalls = new ArrayList<>();
        for (int i = 28; i < GameDimensions.getWidth() - 27; i++) {
            newWalls.add(new Wall(new Position(i, 3)));
            newWalls.add(new Wall(new Position(i, GameDimensions.getHeight() - 4)));
        }
        for (int i = 3; i < GameDimensions.getHeight() - 4; i++) {
            newWalls.add(new Wall(new Position(28, i)));
            newWalls.add(new Wall(new Position(GameDimensions.getWidth() - 28, i)));
        }
        for (Wall wall : newWalls) {
            wall.setColor("#00FFFF");
            wall.setWallStr("X");
        }
        model.setMapWalls(newWalls);
    }

    public PlayerController getPlayer() {
        return model.getPlayer();
    }

    @Override
    public void setPlayer(PlayerController player) {
        model.setPlayer(player);
    }

    @Override
    public void draw() {
        if (GameDimensions.isSwing()) {
            model.getPlayer().draw();
            model.getEnemy().draw();
        }
        view.draw(model.getMapWalls(), model.getTrails(), model.getEnemyTrails());
        if (!GameDimensions.isSwing()) {
            model.getPlayer().draw();
            model.getEnemy().draw();
        }
    }

    @Override
    public void update() {

    }

    public boolean canPlayerMove(Position position) {
        for (Wall wall : model.getMapWalls()) {
            if (position.equals(wall.getPosition()))
                return false;
        }
        for (Wall trail : model.getTrails()) {
            if (position.equals(trail.getPosition()))
                return false;
        }
        for (Wall trail : model.getEnemyTrails()) {
            if (position.equals(trail.getPosition()))
                return false;
        }

        return (position != model.getPlayer().getPosition() && position != model.getEnemy().getPosition());
    }

    public boolean movePlayer() {
        Position position;
        Position oldPosition = model.getPlayer().getPosition();
        switch (model.getCurrentDirection()) {
            case UP:
                position = model.getPlayer().moveUp();
                break;
            case RIGHT:
                position = model.getPlayer().moveRight();
                break;
            case DOWN:
                position = model.getPlayer().moveDown();
                break;
            case LEFT:
                position = model.getPlayer().moveLeft();
                break;
            default:
                position = model.getPlayer().getPosition();
        }
        if (canPlayerMove(position)) {
            List<Wall> newTrail = model.getTrails();
            Wall trail = new Wall(oldPosition);
            trail.setWallStr("X");
            trail.setColor("#F0F000");
            newTrail.add(trail);
            model.setTrails(newTrail);
            model.getPlayer().setPosition(position);
        } else {
            return false;
        }
        return true;
    }

    public void moveEnemy() {
        Position position = model.getEnemy().getPosition();
        List<Character> moveTo = new ArrayList<>();
        moveTo.add('U');
        moveTo.add('R');
        moveTo.add('D');
        moveTo.add('L');
        moveTo.add('U');
        moveTo.add('R');
        Random rand = new Random();
        Character direction = moveTo.get(rand.nextInt(moveTo.size()));

        Position oldPosition = position;

        switch (direction) {
            case 'U':
                position = model.getEnemy().moveUp();
                if (!canPlayerMove(position)) {
                    position = model.getEnemy().moveDown();
                }
                if (!canPlayerMove(position)) {
                    position = model.getEnemy().moveRight();
                }
                if (!canPlayerMove(position)) {
                    position = model.getEnemy().moveLeft();
                }
                break;
            case 'R':
                position = model.getEnemy().moveRight();
                if (!canPlayerMove(position)) {
                    position = model.getEnemy().moveLeft();
                }
                if (!canPlayerMove(position)) {
                    position = model.getEnemy().moveDown();
                }
                if (!canPlayerMove(position)) {
                    position = model.getEnemy().moveUp();
                }
                break;
            case 'D':
                position = model.getEnemy().moveDown();
                if (!canPlayerMove(position)) {
                    position = model.getEnemy().moveUp();
                }
                if (!canPlayerMove(position)) {
                    position = model.getEnemy().moveLeft();
                }
                if (!canPlayerMove(position)) {
                    position = model.getEnemy().moveRight();
                }
                break;
            case 'L':
                position = model.getEnemy().moveLeft();
                if (!canPlayerMove(position)) {
                    position = model.getEnemy().moveRight();
                }
                if (!canPlayerMove(position)) {
                    position = model.getEnemy().moveUp();
                }
                if (!canPlayerMove(position)) {
                    position = model.getEnemy().moveDown();
                }
                break;
        }

        if (canPlayerMove(position)) {
            List<Wall> newTrail = model.getEnemyTrails();
            Wall trail = new Wall(oldPosition);
            trail.setWallStr("X");
            trail.setColor("#000FFF");
            newTrail.add(trail);
            model.setEnemyTrails(newTrail);
            model.getEnemy().setPosition(position);
        } else {
            model.getEnemy().setAlive(false);
        }
    }

    public void handleKey(KeyPress key) {
        switch (key) {
            case UP:
                if (model.getCurrentDirection() != LightCycles.Direction.DOWN)
                    model.setCurrentDirection(LightCycles.Direction.UP);
                break;
            case RIGHT:
                if (model.getCurrentDirection() != LightCycles.Direction.LEFT)
                    model.setCurrentDirection(LightCycles.Direction.RIGHT);
                break;
            case DOWN:
                if (model.getCurrentDirection() != LightCycles.Direction.UP)
                    model.setCurrentDirection(LightCycles.Direction.DOWN);
                break;
            case LEFT:
                if (model.getCurrentDirection() != LightCycles.Direction.RIGHT)
                    model.setCurrentDirection(LightCycles.Direction.LEFT);
                break;
        }
    }

    @Override
    public boolean checkEnter(KeyPress key, CurrentLevel level) {
        return false;
    }


    @Override
    public GameResult play(CurrentLevel level) throws IOException, InterruptedException {
        while (true) {
            view.clearScreen();
            draw();
            view.refreshScreen();

            KeyPress key;
            if (GameDimensions.isSwing()) {
                key = level.getKey();
            } else {
                key = view.processKey();
            }

            if (key != null)
                handleKey(key);

            if (checkEnter(key, level))
                break;

            if (!model.getEnemy().isAlive()) {
                break;
            }

            moveEnemy();

            if (!movePlayer()) {
                Thread.sleep(500);
                return GameResult.LOSE;
            }

            if (key == KeyPress.EXIT) {
                return GameResult.EXIT;
            }

            Thread.sleep(150);
        }
        Thread.sleep(1000 / 30);
        return GameResult.WIN;
    }
}
