package com.quadrivium.g13.model;

import com.quadrivium.g13.controller.PlayerController;

import java.util.ArrayList;
import java.util.List;

public class BattleTanks {
    private PlayerController player;
    private int playerLives;
    private List<Wall> mapWalls;
    private List<Bullet> activePlayerBullets;
    private List<Enemy> activeEnemies;
    private Enemy testEnemy;
    private boolean testEnemyActive;
    private List<Bullet> activeEnemyBullets;
    private boolean allEnemiesKilled;
    private int score;

    public BattleTanks() {
        mapWalls = new ArrayList<>();
        activePlayerBullets = new ArrayList<>();
        activeEnemies = new ArrayList<>();
        this.activeEnemyBullets = new ArrayList<>();
        playerLives = 3;
        allEnemiesKilled = false;
        score = 0;
        testEnemyActive = false;
    }

    public PlayerController getPlayer() {
        return player;
    }

    public void setPlayer(PlayerController player) {
        this.player = player;
    }

    public List<Wall> getMapWalls() {
        return mapWalls;
    }

    public void setMapWalls(List<Wall> mapWalls) {
        this.mapWalls = mapWalls;
    }

    public List<Bullet> getActivePlayerBullets() {
        return activePlayerBullets;
    }

    public void setActivePlayerBullets(List<Bullet> activeBullets) {
        this.activePlayerBullets = activeBullets;
    }

    public List<Enemy> getActiveEnemies() {
        return activeEnemies;
    }

    public void setActiveEnemies(List<Enemy> activeEnemies) {
        this.activeEnemies = activeEnemies;
    }

    public List<Bullet> getActiveEnemyBullets() {
        return activeEnemyBullets;
    }

    public void setActiveEnemyBullets(List<Bullet> activeEnemyBullets) {
        this.activeEnemyBullets = activeEnemyBullets;
    }

    public int getPlayerLives() {
        return playerLives;
    }

    public void setPlayerLives(int playerLives) {
        this.playerLives = playerLives;
    }

    public boolean isAllEnemiesKilled() {
        return allEnemiesKilled;
    }

    public void setAllEnemiesKilled(boolean allEnemiesKilled) {
        this.allEnemiesKilled = allEnemiesKilled;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Enemy getTestEnemy() {
        return testEnemy;
    }

    public void setTestEnemy(Enemy testEnemy) {
        this.testEnemy = testEnemy;
    }

    public boolean isTestEnemyActive() {
        return testEnemyActive;
    }

    public void setTestEnemyActive(boolean testEnemyActive) {
        this.testEnemyActive = testEnemyActive;
    }
}
