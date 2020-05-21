package com.quadrivium.g13.view;

import com.quadrivium.g13.model.GameJFrame;
import com.quadrivium.g13.model.Position;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class SwingPlayerView extends JComponent implements PlayerView {
    private Position position;

    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);


        URL resource = GameJFrame.getJframe().getClass().getResource("/Player.png");
        BufferedImage image = null;
        try{
            image = ImageIO.read(resource);
        } catch (IOException ignored) {}

        graphics.drawImage(image, position.getX()*8, position.getY()*16,null);

    }
    public void draw(Position playerPosition){
        this.position = playerPosition;
        GameJFrame.getJframe().getContentPane().add(this);
        paintComponents(GameJFrame.getJframe().getGraphics());
    }
}
