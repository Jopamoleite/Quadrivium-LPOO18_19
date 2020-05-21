package com.quadrivium.g13.view;

import com.quadrivium.g13.model.GameJFrame;
import com.quadrivium.g13.model.Wall;

import java.awt.*;
import java.util.List;

public class SwingLightCyclesView extends SwingGameView implements LightCyclesView {
    List<Wall> walls, trails, enemyTrails;


    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.setColor(Color.CYAN);
        for (Wall wall : walls) {
            graphics.drawRect(wall.getPosition().getX() * 8, wall.getPosition().getY() * 16, 8, 16);
        }
        graphics.setColor(Color.YELLOW);
        for (Wall trail : trails) {
            graphics.fillRect(trail.getPosition().getX() * 8, trail.getPosition().getY() * 16, 8, 16);
        }
        graphics.setColor(Color.BLUE);
        for (Wall trail : enemyTrails) {
            graphics.fillRect(trail.getPosition().getX() * 8, trail.getPosition().getY() * 16, 8, 16);
        }
    }

    public void draw(List<Wall> walls, List<Wall> trails, List<Wall> enemyTrails) {
        this.walls = walls;
        this.trails = trails;
        this.enemyTrails = enemyTrails;
        GameJFrame.getJframe().getContentPane().add(this);
        paintComponents(GameJFrame.getJframe().getGraphics());
    }
}
