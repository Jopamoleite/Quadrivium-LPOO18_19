package com.quadrivium.g13.view;

import com.quadrivium.g13.model.BattleTanksEnemy;
import com.quadrivium.g13.model.Bullet;
import com.quadrivium.g13.model.GameJFrame;
import com.quadrivium.g13.model.Wall;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SwingBattleTanksView extends SwingGameView implements BattleTanksView {
    List<Wall> walls;
    List<Bullet> playerBullets;
    List<BattleTanksEnemy> enemies;
    List<Bullet> enemyBullets;
    boolean allEnemiesKilled;
    int playerLives;

    @Override
    protected synchronized void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        if (allEnemiesKilled) {
            graphics.setColor(Color.ORANGE);
            for (int i = 56; i < 69; i++) {
                for (int j = 18; j < 23; j++) {
                    graphics.fillRect(i * 8, j * 16, 8, 16);
                }
            }
        }

        URL resource = GameJFrame.getJframe().getClass().getResource("/Lives.png");
        BufferedImage livesIMG = null;
        try {
            livesIMG = ImageIO.read(resource);
        } catch (IOException e) {
        }

        for (int i = 0; i < playerLives; i++) {
            graphics.drawImage(livesIMG, 29 * 8 + i * 16, 2 * 16, null);
        }

        graphics.setColor(Color.GREEN);
        for (Wall wall : walls) {
            graphics.fillRect(wall.getPosition().getX() * 8, wall.getPosition().getY() * 16, 8, 16);
        }

        graphics.setColor(Color.WHITE);
        for (Bullet bullet : playerBullets) {
            graphics.fillOval(bullet.getPosition().getX() * 8, bullet.getPosition().getY() * 16, 8, 8);
        }

        graphics.setColor(Color.RED);
        for (Bullet bullet : enemyBullets) {
            graphics.fillOval(bullet.getPosition().getX() * 8, bullet.getPosition().getY() * 16, 8, 8);
        }

        resource = GameJFrame.getJframe().getClass().getResource("/Enemy.png");
        BufferedImage enemyIMG = null;
        try {
            enemyIMG = ImageIO.read(resource);
        } catch (IOException e) {
        }

        for (BattleTanksEnemy enemy : enemies) {
            graphics.drawImage(enemyIMG, enemy.getPosition().getX() * 8, enemy.getPosition().getY() * 16, null);
        }
    }

    @Override
    public synchronized void draw(List<Wall> walls, List<Bullet> playerBullets, List<BattleTanksEnemy> enemies, List<Bullet> enemyBullets, boolean allEnemiesKilled, int playerLives) {
        this.walls = walls;
        this.playerBullets = new ArrayList<>();
        for (Bullet bullet : playerBullets) {
            this.playerBullets.add(bullet);
        }
        this.enemies = new ArrayList<>();
        for (BattleTanksEnemy enemy : enemies) {
            this.enemies.add(enemy);
        }
        this.enemyBullets = new ArrayList<>();
        for (Bullet bullet : enemyBullets) {
            this.enemyBullets.add(bullet);
        }
        this.allEnemiesKilled = allEnemiesKilled;
        this.playerLives = playerLives;
        GameJFrame.getJframe().getContentPane().add(this);
        paintComponents(GameJFrame.getJframe().getGraphics());
    }

}
