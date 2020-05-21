package com.quadrivium.g13.view;

import com.quadrivium.g13.model.GameJFrame;
import com.quadrivium.g13.model.Wall;

import java.awt.*;
import java.util.List;

public class SwingLightCyclesView extends SwingGameView implements LightCyclesView {
    private List<Wall> walls, trails, enemyTrails;
    private int score;


    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        graphics.setColor(Color.WHITE);
        graphics.drawString("Score: ",700, 40);
        graphics.drawString(String.valueOf(score), 750, 40);

        graphics.setColor(Color.CYAN);
        for(Wall wall : walls){
            graphics.drawRect(wall.getPosition().getX()*8,wall.getPosition().getY()*16,8, 16);
        }
        graphics.setColor(Color.YELLOW);
        for(Wall trail : trails){
            graphics.fillRect(trail.getPosition().getX()*8,trail.getPosition().getY()*16,8, 16);
        }
        graphics.setColor(Color.BLUE);
        for(Wall trail : enemyTrails){
            graphics.fillRect(trail.getPosition().getX()*8,trail.getPosition().getY()*16,8, 16);
        }
    }

    public void draw(List<Wall> walls, List<Wall> trails, List<Wall> enemyTrails, int score){
        this.walls = walls;
        this.trails = trails;
        this.enemyTrails = enemyTrails;
        this.score = score;
        GameJFrame.getJframe().getContentPane().add(this);
        paintComponents(GameJFrame.getJframe().getGraphics());
    }
}
