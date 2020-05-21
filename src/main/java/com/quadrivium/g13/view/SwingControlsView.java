package com.quadrivium.g13.view;

import com.quadrivium.g13.model.GameDimensions;
import com.quadrivium.g13.model.GameJFrame;
import com.quadrivium.g13.model.Sector;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class SwingControlsView extends SwingGameView implements ControlsView {
    private List<Sector> sectors;

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.setColor(Color.ORANGE);
        for (Sector sector : sectors) {
            graphics.drawRect(sector.getPosition().getX() * 8, sector.getPosition().getY() * 16, 8, 16);
        }

        URL resource = GameJFrame.getJframe().getClass().getResource("/Instructions.png");
        BufferedImage image = null;
        try {
            image = ImageIO.read(resource);
        } catch (IOException e) {
        }

        graphics.drawImage(image, GameDimensions.getWidth() / 4 * 8, GameDimensions.getHeight() / 2 * 16, null);

        resource = GameJFrame.getJframe().getClass().getResource("/Continue.png");
        image = null;
        try {
            image = ImageIO.read(resource);
        } catch (IOException e) {
        }

        graphics.drawImage(image, (GameDimensions.getWidth() / 2 - 16) * 8, (GameDimensions.getHeight() - GameDimensions.getHeight() / 5) * 16, null);
    }

    public void draw(List<Sector> sectors) {
        this.sectors = sectors;
        GameJFrame.getJframe().getContentPane().add(this);
        paintComponents(GameJFrame.getJframe().getGraphics());
    }
}


