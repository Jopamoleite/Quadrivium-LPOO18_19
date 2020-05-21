package com.quadrivium.g13.model;

import com.quadrivium.g13.controller.LightCyclesEnemyController;
import com.quadrivium.g13.controller.PlayerController;

import java.util.List;

public class LightCycles {
    private PlayerController player;
    private LightCyclesEnemyController enemy;
    private List<Wall> mapWalls;
    private List<Wall> trails;
    private List<Wall> enemyTrails;
    private Direction currentDirection;

    public LightCycles() {
        currentDirection = Direction.DOWN;
    }

    public List<Wall> getTrails() {
        return trails;
    }

    public void setTrails(List<Wall> trails) {
        this.trails = trails;
    }

    public List<Wall> getEnemyTrails() {
        return enemyTrails;
    }

    public void setEnemyTrails(List<Wall> enemyTrails) {
        this.enemyTrails = enemyTrails;
    }

    public LightCyclesEnemyController getEnemy() {
        return enemy;
    }

    public void setEnemy(LightCyclesEnemyController enemy) {
        this.enemy = enemy;
    }

    public PlayerController getPlayer() {
        return player;
    }

    public void setPlayer(PlayerController player) {
        this.player = player;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public List<Wall> getMapWalls() {
        return mapWalls;
    }

    public void setMapWalls(List<Wall> mapWalls) {
        this.mapWalls = mapWalls;
    }

    public enum Direction {
        UP,
        RIGHT,
        DOWN,
        LEFT
    }
}
