package com.quadrivium.g13.view;

import com.quadrivium.g13.model.GameDimensions;
import com.quadrivium.g13.model.GameJFrame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class SwingWinScreenView extends SwingGameView implements WinScreenView{

    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        URL resource = GameJFrame.getJframe().getClass().getResource("/YouWin.png");
        BufferedImage image = null;
        try{
            image = ImageIO.read(resource);
        } catch (IOException ignored) {}

        graphics.drawImage(image, GameDimensions.getWidth()/8*8, GameDimensions.getHeight()/3*8,null);

        resource = GameJFrame.getJframe().getClass().getResource("/Continue.png");
        image = null;
        try{
            image = ImageIO.read(resource);
        } catch (IOException ignored) {}

        graphics.drawImage(image, (GameDimensions.getWidth()/2-16)*8, (GameDimensions.getHeight()-GameDimensions.getHeight()/5)*16,null);
    }

    @Override
    public void draw() {
        GameJFrame.getJframe().getContentPane().add(this);
        paintComponents(GameJFrame.getJframe().getGraphics());
    }

}
