package com.quadrivium.g13.controller;

import com.quadrivium.g13.exceptions.OutOfBoundsException;
import com.quadrivium.g13.model.*;
import com.quadrivium.g13.view.IOTowerView;
import com.quadrivium.g13.view.LanternaMenuView;
import com.quadrivium.g13.view.SwingMenuView;

import java.io.IOException;

public class IOTowerController implements GameController{
    private IOTower model;
    private IOTowerView view;

    public IOTowerController(IOTower model, IOTowerView view){
        this.model = model;
        this.view = view;
    }

    public PlayerController getPlayer(){
        return model.getPlayer();
    }

    @Override
    public void setPlayer(PlayerController player) {
        model.setPlayer(player);
    }

    @Override
    public void draw() {
        model.getPlayer().draw();
    }


    private boolean canPlayerMove(Position position){
        return !(position.getX() >= (GameDimensions.getWidth()-1) || position.getX()<=0 || position.getY() >= (GameDimensions.getHeight()-1) || position.getY()<=0);
    }

    private void movePlayer(Position position) throws OutOfBoundsException {
        if(canPlayerMove(position)) {
            model.getPlayer().setPosition(position);
        }
    }

    void handleKey(KeyPress key) throws OutOfBoundsException {
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
        }
    }

    @Override
    public boolean checkEnter(KeyPress key, CurrentLevel level) throws OutOfBoundsException {
        if(key == KeyPress.ENTER){
            if(GameDimensions.isSwing()){
                level.setActiveGame(new MenuController(new Menu(), new SwingMenuView()));
            }
            else{
                level.setActiveGame(new MenuController(new Menu(), new LanternaMenuView()));
            }
            return true;
        }

        return false;
    }

    @Override
    public GameResult play(CurrentLevel level) throws IOException, InterruptedException, OutOfBoundsException {
        while(true){
            view.clearScreen();
            draw();
            view.refreshScreen();

            KeyPress key;
            if(GameDimensions.isSwing()){
                key = level.getKey();
            } else{
                key = view.processKey();
            }

            if(key!=null)
            handleKey(key);

            if(checkEnter(key, level))
                break;

            if (key == KeyPress.EXIT || key == KeyPress.EOF){
                return GameResult.EXIT;
            }
            Thread.sleep(1000/30);
        }
        return GameResult.PROCEED;
    }
}
