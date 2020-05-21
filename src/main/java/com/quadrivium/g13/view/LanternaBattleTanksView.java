package com.quadrivium.g13.view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.quadrivium.g13.model.Bullet;
import com.quadrivium.g13.model.Enemy;
import com.quadrivium.g13.model.GameScreen;
import com.quadrivium.g13.model.Wall;

import java.util.List;

public class LanternaBattleTanksView extends LanternaGameView implements BattleTanksView {
    public synchronized void draw(List<Wall> walls, List<Bullet> playerBullets, List<Enemy> enemies, List<Bullet> enemyBullets, boolean allEnemiesKilled, int playerLives, int score){
        TextGraphics graphics = GameScreen.getScreen().newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.enableModifiers(SGR.BOLD);
        if(allEnemiesKilled) {
            graphics.setForegroundColor(TextColor.Factory.fromString("#FF7F50"));
            for (int i = 56; i < 69; i++) {
                for (int j = 18; j < 23; j++) {
                    graphics.putString(new TerminalPosition(i, j), "\u25AE");
                }
            }
        }
        graphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        for(int i = 0; i<playerLives; i++){
            graphics.putString(new TerminalPosition(29+i*2,2), "\u2665 ");
        }
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.putString(new TerminalPosition(85, 2), "Score: ");
        graphics.putString(new TerminalPosition(92,2), String.valueOf(score));
        for(Wall wall : walls){
            graphics.setForegroundColor(TextColor.Factory.fromString(wall.getColor()));
            graphics.putString(new TerminalPosition(wall.getPosition().getX(), wall.getPosition().getY()), wall.getWallStr());
        }
        for(Bullet bullet : playerBullets){
            graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
            graphics.putString(new TerminalPosition(bullet.getPosition().getX(), bullet.getPosition().getY()), "\u2022");
        }

        for(Bullet bullet : enemyBullets){
            graphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
            graphics.putString(new TerminalPosition(bullet.getPosition().getX(), bullet.getPosition().getY()), "\u2022");
        }
        for(Enemy enemy : enemies){
            graphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
            graphics.putString(new TerminalPosition(enemy.getPosition().getX(), enemy.getPosition().getY()), "\u2620");
        }
    }
}
