package com.quadrivium.g13.view;

import com.quadrivium.g13.model.GameJFrame;
import com.quadrivium.g13.model.Sector;

import java.awt.*;
import java.util.List;

public class SwingMenuView extends SwingGameView implements MenuView {

    private List<List<Sector>> sectors;

    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        int color = 0;
        for (List<Sector> sectorList : sectors){
            if(color == 0){
                graphics.setColor(Color.RED);
            }
            if(color == 1){
                graphics.setColor(Color.ORANGE);
            }
            if(color == 2){
                graphics.setColor(Color.BLUE);
            }
            if(color == 3){
                graphics.setColor(Color.GREEN);
            }
            color++;
            for(Sector sector : sectorList) {
                graphics.drawRect(sector.getPosition().getX()*8,sector.getPosition().getY()*16,8, 16);
            }
        }
    }

    public void draw(List<List<Sector>> sectors){
        this.sectors = sectors;
        GameJFrame.getJframe().getContentPane().add(this);
        paintComponents(GameJFrame.getJframe().getGraphics());
    }

}
