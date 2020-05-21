package com.quadrivium.g13.controller;

import com.quadrivium.g13.model.*;
import com.quadrivium.g13.view.BattleTanksView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BattleTanksController implements GameController {
    private BattleTanks model;
    private BattleTanksView view;

    public BattleTanksController(BattleTanks model, BattleTanksView view) {
        this.model = model;
        this.view = view;
        List<BattleTanksEnemy> new_enemies = new ArrayList<>();
        new_enemies.add(new BattleTanksEnemy(new Position(29, 4)));
        new_enemies.add(new BattleTanksEnemy(new Position(GameDimensions.getWidth() - 29, 4)));
        new_enemies.add(new BattleTanksEnemy(new Position(29, GameDimensions.getHeight() - 5)));
        new_enemies.add(new BattleTanksEnemy(new Position(GameDimensions.getWidth() - 29, GameDimensions.getHeight() - 5)));
        //new_enemies.add(new BattleTanksEnemy(new Position()))
        model.setActiveEnemies(new_enemies);
    }

    public PlayerController getPlayer() {
        return model.getPlayer();
    }

    @Override
    public void setPlayer(PlayerController player) {
        model.setPlayer(player);
    }

    @Override
    public synchronized void draw() {
        if (GameDimensions.isSwing())
            model.getPlayer().draw();
        view.draw(model.getMapWalls(), model.getActivePlayerBullets(), model.getActiveEnemies(), model.getActiveEnemyBullets(), model.isAllEnemiesKilled(), model.getPlayerLives());
        if (!GameDimensions.isSwing())
            model.getPlayer().draw();
    }

    @Override
    public void update() {

    }

    public boolean canElementMove(Position position) {
        for (Wall wall : model.getMapWalls()) {
            if (position.equals(wall.getPosition()))
                return false;
        }
        return !((position.getX() >= (GameDimensions.getWidth() - 1)) || (position.getX() <= 0) || (position.getY() >= (GameDimensions.getHeight() - 1)) || (position.getY() <= 0));
    }

    public void movePlayer(Position position) {
        if (canElementMove(position)) {
            model.getPlayer().setPosition(position);
        }
    }

    public void handleKey(KeyPress key) {
        switch (key) {
            case UP:
                movePlayer(model.getPlayer().moveUp());
                break;
            case RIGHT:
                movePlayer(model.getPlayer().moveRight());
                break;
            case DOWN:
                movePlayer(model.getPlayer().moveDown());
                break;
            case LEFT:
                movePlayer(model.getPlayer().moveLeft());
                break;
            case W:
                shoot('U', model.getPlayer().getPosition());
                break;
            case A:
                shoot('L', model.getPlayer().getPosition());
                break;
            case S:
                shoot('D', model.getPlayer().getPosition());
                break;
            case D:
                shoot('R', model.getPlayer().getPosition());
                break;
            default:
                break;
        }
    }

    @Override
    public boolean checkEnter(KeyPress key, CurrentLevel level) {
        return (key == KeyPress.ENTER);
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

        for (int j = 7; j < 9; j++) {
            newWalls.add(new Wall(new Position(36, j)));
            newWalls.add(new Wall(new Position(37, j)));
            newWalls.add(new Wall(new Position(38, j)));

            for (int i = 45; i <= 56; i++) {
                newWalls.add(new Wall(new Position(i, j)));
            }
            for (int i = 63; i <= 76; i++) {
                newWalls.add(new Wall(new Position(i, j)));
            }
            for (int i = 83; i <= 89; i++) {
                newWalls.add(new Wall(new Position(i, j)));
            }
        }

        for (int j = 9; j <= 11; j++) {
            newWalls.add(new Wall(new Position(36, j)));
            newWalls.add(new Wall(new Position(37, j)));
            newWalls.add(new Wall(new Position(38, j)));
            for (int i = 54; i <= 56; i++)
                newWalls.add(new Wall(new Position(i, j)));
        }

        for (int i = 45; i <= 47; i++) {
            newWalls.add(new Wall(new Position(i, 12)));
            newWalls.add(new Wall(new Position(i, 13)));
            newWalls.add(new Wall(new Position(i, 14)));

            newWalls.add(new Wall(new Position(i, 18)));
            newWalls.add(new Wall(new Position(i, 19)));
            newWalls.add(new Wall(new Position(i, 20)));
        }

        for (int i = 16; i <= 21; i++) {
            newWalls.add(new Wall(new Position(36, i)));
            newWalls.add(new Wall(new Position(37, i)));
            newWalls.add(new Wall(new Position(38, i)));
        }

        for (int i = 27; i <= 33; i++) {
            newWalls.add(new Wall(new Position(36, i)));
            newWalls.add(new Wall(new Position(37, i)));
            newWalls.add(new Wall(new Position(38, i)));
        }

        for (int j = 32; j < 34; j++) {
            newWalls.add(new Wall(new Position(87, j)));
            newWalls.add(new Wall(new Position(88, j)));
            newWalls.add(new Wall(new Position(89, j)));

            for (int i = 71; i <= 82; i++) {
                newWalls.add(new Wall(new Position(i, j)));
            }
            for (int i = 51; i <= 64; i++) {
                newWalls.add(new Wall(new Position(i, j)));
            }
            for (int i = 38; i <= 44; i++) {
                newWalls.add(new Wall(new Position(i, j)));
            }
        }

        for (int j = 29; j <= 31; j++) {
            newWalls.add(new Wall(new Position(87, j)));
            newWalls.add(new Wall(new Position(88, j)));
            newWalls.add(new Wall(new Position(89, j)));
            for (int i = 62; i <= 64; i++)
                newWalls.add(new Wall(new Position(i, j)));
        }

        for (int i = 77; i <= 79; i++) {
            newWalls.add(new Wall(new Position(i, 28)));
            newWalls.add(new Wall(new Position(i, 27)));
            newWalls.add(new Wall(new Position(i, 26)));

            newWalls.add(new Wall(new Position(i, 22)));
            newWalls.add(new Wall(new Position(i, 21)));
            newWalls.add(new Wall(new Position(i, 20)));
        }

        for (int i = 15; i <= 20; i++) {
            newWalls.add(new Wall(new Position(87, i)));
            newWalls.add(new Wall(new Position(88, i)));
            newWalls.add(new Wall(new Position(89, i)));

        }

        for (int i = 55; i < 59; i++) {
            newWalls.add(new Wall(new Position(i, 17)));
            newWalls.add(new Wall(new Position(i, GameDimensions.getHeight() - 18)));
        }
        for (int i = 66; i < 70; i++) {
            newWalls.add(new Wall(new Position(i, 17)));
            newWalls.add(new Wall(new Position(i, GameDimensions.getHeight() - 18)));
        }
        for (int i = 17; i < GameDimensions.getHeight() - 18; i++) {
            newWalls.add(new Wall(new Position(55, i)));
            newWalls.add(new Wall(new Position(GameDimensions.getWidth() - 56, i)));
        }

        for (Wall wall : newWalls) {
            wall.setColor("#00FF00");
            wall.setWallStr("\u25AE");
        }

        model.setMapWalls(newWalls);
    }

    public synchronized void shoot(char direction, Position initialPos) {
        int b_x = initialPos.getX();
        int b_y = initialPos.getY();
        if (model.getActivePlayerBullets().size() < 10) {
            Bullet newBullet = new Bullet(direction, new Position(b_x, b_y));
            List<Bullet> newBulletsList = model.getActivePlayerBullets();
            newBulletsList.add(newBullet);
            model.setActivePlayerBullets(newBulletsList);
        }
    }

    public synchronized void updateBullets() {
        for (Bullet bullet : model.getActivePlayerBullets()) {
            switch (bullet.getDirection()) {
                case 'U':
                    bullet.getPosition().setY(bullet.getPosition().getY() - 1);
                    break;
                case 'L':
                    bullet.getPosition().setX(bullet.getPosition().getX() - 1);
                    break;
                case 'D':
                    bullet.getPosition().setY(bullet.getPosition().getY() + 1);
                    break;
                case 'R':
                    bullet.getPosition().setX(bullet.getPosition().getX() + 1);
                    break;
                default:
                    break;
            }
        }
        checkPlayerBulletCollisions();
        for (Bullet bullet : model.getActiveEnemyBullets()) {
            switch (bullet.getDirection()) {
                case 'U':
                    bullet.getPosition().setY(bullet.getPosition().getY() - 1);
                    break;
                case 'L':
                    bullet.getPosition().setX(bullet.getPosition().getX() - 1);
                    break;
                case 'D':
                    bullet.getPosition().setY(bullet.getPosition().getY() + 1);
                    break;
                case 'R':
                    bullet.getPosition().setX(bullet.getPosition().getX() + 1);
                    break;
                default:
                    break;
            }
        }
        checkEnemyBulletCollisions();
    }

    public synchronized void checkPlayerBulletCollisions() {
        List<Bullet> bullets = model.getActivePlayerBullets();
        List<BattleTanksEnemy> enemies = model.getActiveEnemies();
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            for (int j = 0; j < enemies.size(); j++) {
                BattleTanksEnemy enemy = enemies.get(j);
                if (bullet.getPosition().equals(enemy.getPosition())) {
                    if (model.getActivePlayerBullets().remove(bullet)) {
                        i--;
                    }
                    model.getActiveEnemies().remove(enemy);
                    j--;
                    break;
                }
            }
            for (Wall wall : model.getMapWalls()) {
                if (bullet.getPosition().equals(wall.getPosition())) {
                    if (model.getActivePlayerBullets().remove(bullet)) {
                        i--;
                        break;
                    }
                }
            }

        }
    }

    public synchronized void checkEnemyBulletCollisions() {
        List<Bullet> bullets = model.getActiveEnemyBullets();
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            for (Wall wall : model.getMapWalls()) {
                if (bullet.getPosition().equals(wall.getPosition())) {
                    if (model.getActiveEnemyBullets().remove(bullet)) {
                        i--;
                    }
                } else if (bullet.getPosition().equals(model.getPlayer().getPosition())) {
                    if (model.getActiveEnemyBullets().remove(bullet)) {
                        i--;
                    }
                    model.setPlayerLives(model.getPlayerLives() - 1);
                    model.getPlayer().resetPosition();
                }
            }
        }
    }

    public synchronized void checkPlayerEnemyCollisons() {
        for (BattleTanksEnemy enemy : model.getActiveEnemies()) {
            if (enemy.getPosition().equals(model.getPlayer().getPosition())) {
                model.setPlayerLives(model.getPlayerLives() - 1);
                model.getPlayer().resetPosition();
                return;
            }
        }
    }

    public synchronized void moveEnemies() {
        Random rand = new Random();
        List<BattleTanksEnemy> enemies = model.getActiveEnemies();
        int direction; //(0 - up; 1 - left; 2 - down; 3 - right)
        for (BattleTanksEnemy enemy : enemies) {
            direction = rand.nextInt(4);
            switch (direction) {
                case 0:
                    if (canElementMove(enemy.moveUp())) {
                        enemy.setPosition(enemy.moveUp());
                    }
                    break;
                case 1:
                    if (canElementMove(enemy.moveLeft()))
                        enemy.setPosition(enemy.moveLeft());
                    break;
                case 2:
                    if (canElementMove(enemy.moveDown()))
                        enemy.setPosition(enemy.moveDown());
                    break;
                case 3:
                    if (canElementMove(enemy.moveRight()))
                        enemy.setPosition(enemy.moveRight());
                    break;
                default:
                    break;
            }
        }
    }


    public synchronized void generateEnemyBullets() {
        Random rand = new Random();
        List<BattleTanksEnemy> enemies = model.getActiveEnemies();
        int enemy_index;
        if (enemies.size() == 0)
            return;
        enemy_index = rand.nextInt(enemies.size());
        int dir;
        char bullet_direction = 'U';
        dir = rand.nextInt(4); //(0 - up; 1 - left; 2 - down; 3 - right)
        switch (dir) {
            case 0:
                bullet_direction = 'U';
                break;
            case 1:
                bullet_direction = 'L';
                break;
            case 2:
                bullet_direction = 'D';
                break;
            case 3:
                bullet_direction = 'R';
                break;
            default:
                break;
        }
        model.getActiveEnemyBullets().add(new Bullet(bullet_direction, new Position(enemies.get(enemy_index).getPosition())));
    }

    public synchronized void updateEnemies() {
        moveEnemies();
        generateEnemyBullets();
    }

    public boolean hasPlayerWon() {
        if (model.isAllEnemiesKilled()) {
            for (int i = 56; i < 69; i++) {
                for (int j = 18; j < 23; j++) {
                    if (model.getPlayer().getPosition().equals(new Position(i, j)))
                        return true;
                }
            }
        }
        return false;
    }


    @Override
    public GameResult play(CurrentLevel level) throws IOException, InterruptedException {

        generateMap();
        Thread bullets_thread = new Thread() {
            public void run() {
                while (true) {
                    updateBullets();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        break;
                    }
                    if (isInterrupted()) return;
                }
            }
        };
        Thread enemies_thread = new Thread() {
            public void run() {
                while (true) {
                    updateEnemies();
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        break;
                    }
                    if (isInterrupted()) return;
                }
            }
        };
        enemies_thread.start();
        bullets_thread.start();
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

            checkPlayerEnemyCollisons();

            if (model.getActiveEnemies().size() == 0) {
                model.setAllEnemiesKilled(true);
            }

            if (checkEnter(key, level)) {
                if (hasPlayerWon()) {
                    bullets_thread.interrupt();
                    enemies_thread.interrupt();
                    break;
                }
            }

            if (key == KeyPress.EXIT) {
                bullets_thread.interrupt();
                enemies_thread.interrupt();
                return GameResult.EXIT;
            }
            Thread.sleep(1000 / 30);

            if (model.getPlayerLives() == 0) {
                bullets_thread.interrupt();
                enemies_thread.interrupt();
                return GameResult.LOSE;
            }

        }
        try {
            bullets_thread.join();
            enemies_thread.join();
        } catch (InterruptedException e) {
        }

        return GameResult.WIN;
    }
}
