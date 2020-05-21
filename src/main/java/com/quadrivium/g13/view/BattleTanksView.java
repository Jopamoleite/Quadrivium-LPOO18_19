package com.quadrivium.g13.view;

import com.quadrivium.g13.model.Bullet;
import com.quadrivium.g13.model.Enemy;
import com.quadrivium.g13.model.KeyPress;
import com.quadrivium.g13.model.Wall;

import java.io.IOException;
import java.util.List;

public interface BattleTanksView{
    KeyPress processKey() throws IOException;
    void refreshScreen() throws IOException;
    void clearScreen();
    void draw(List<Wall> map, List<Bullet> playerBullets, List<Enemy> enemies, List<Bullet> enemyBullets, boolean allEnemiesKilled, int playerLives, int score);
}
