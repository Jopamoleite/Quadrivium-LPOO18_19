package com.quadrivium.g13.controller;

import com.quadrivium.g13.exceptions.OutOfBoundsException;
import com.quadrivium.g13.model.*;
import com.quadrivium.g13.view.ControlsView;
import com.quadrivium.g13.view.LanternaMenuView;
import com.quadrivium.g13.view.SwingMenuView;

import java.io.IOException;
import java.util.ArrayList;

public class ControlsController implements GameController{
    private Controls model;
    private ControlsView view;

    public ControlsController(Controls model, ControlsView view) throws OutOfBoundsException {
        this.model = model;
        this.view = view;
        model.setLetterX(32);
        model.setLetterY(5);
        model.setLetterSize(5);
        initLetters();
    }

    private void initLetters() throws OutOfBoundsException {

        int height = this.model.getLetterY();
        int width = this.model.getLetterX();
        int size = this.model.getLetterSize();
        model.setLetters(new ArrayList<>());

        for(int i = 0; i < size; ++i){
            model.getLetters().add(new Sector(new Position(width+i, height),"#FFF000"," "));
            model.getLetters().add(new Sector(new Position(width+i, height+size-1),"#FFF000"," "));
            if(i!=0 && i!=4){
                model.getLetters().add(new Sector(new Position(width, height+i),"#FFF000"," "));
                model.getLetters().add(new Sector(new Position(width+size-1, height+i),"#FFF000"," "));
            }
        }
        width += size;
        model.getLetters().add(new Sector(new Position(width-2, height+size),"#FFF000"," "));
        model.getLetters().add(new Sector(new Position(width-1, height+size+1),"#FFF000"," "));

        width++;
        for(int i = 0; i < size; ++i){
            model.getLetters().add(new Sector(new Position(width+i, height+size-1),"#FFF000"," "));
            if(i!=4){
                model.getLetters().add(new Sector(new Position(width, height+i),"#FFF000"," "));
                model.getLetters().add(new Sector(new Position(width+size-1, height+i),"#FFF000"," "));
            }
        }

        width += size;
        width++;
        for(int i = 0; i < size; ++i){
            model.getLetters().add(new Sector(new Position(width+i, height),"#FFF000"," "));
            model.getLetters().add(new Sector(new Position(width+i, height+2),"#FFF000"," "));
            if(i!=0 && i!=2){
                model.getLetters().add(new Sector(new Position(width, height+i),"#FFF000"," "));
                model.getLetters().add(new Sector(new Position(width+size-1, height+i),"#FFF000"," "));
            }
        }

        width += size;
        width++;
        for(int i = 0; i < size; ++i){
            model.getLetters().add(new Sector(new Position(width, height+i),"#FFF000"," "));
            if(i!=0 && i!=4){
                model.getLetters().add(new Sector(new Position(width+size-1, height+i),"#FFF000"," "));
            }
            if(i != 0 && i != 4){
                model.getLetters().add(new Sector(new Position(width+i, height+size-1),"#FFF000"," "));
                model.getLetters().add(new Sector(new Position(width+i, height),"#FFF000"," "));
            }
        }

        width += size;
        width++;
        for(int i = 0; i < size; ++i){
            model.getLetters().add(new Sector(new Position(width+i, height),"#FFF000"," "));
            model.getLetters().add(new Sector(new Position(width+i, height+2),"#FFF000"," "));
            if(i!=0 && i!=2){
                model.getLetters().add(new Sector(new Position(width, height+i),"#FFF000"," "));
            }
            if(i == 1){
                model.getLetters().add(new Sector(new Position(width+size-1, height+1),"#FFF000"," "));
            }
            if(i == 3){
                model.getLetters().add(new Sector(new Position(width+2, height+3),"#FFF000"," "));
            }
            if(i == 4){
                model.getLetters().add(new Sector(new Position(width+3, height+4),"#FFF000"," "));
            }
        }

        width += size;
        width++;
        for(int i = 0; i < size; ++i){
            model.getLetters().add(new Sector(new Position(width+i, height),"#FFF000"," "));
            model.getLetters().add(new Sector(new Position(width+i, height+size-1),"#FFF000"," "));
            if(i!=0 && i!=4){
                model.getLetters().add(new Sector(new Position(width+2, height+i),"#FFF000"," "));
            }
        }

        width+=size;
        width++;
        for(int i = 0; i < size; ++i){
            if(i!=4){
                model.getLetters().add(new Sector(new Position(width+size-1, height+i),"#FFF000"," "));
                model.getLetters().add(new Sector(new Position(width, height+i),"#FFF000"," "));
            }
            if(i!=4 && i != 0){
                model.getLetters().add(new Sector(new Position(width+i, height+size-1),"#FFF000"," "));
            }
        }

        width += size;
        width++;
        for(int i = 0; i < size; ++i){
            model.getLetters().add(new Sector(new Position(width+i, height),"#FFF000"," "));
            model.getLetters().add(new Sector(new Position(width+i, height+size-1),"#FFF000"," "));
            if(i!=0 && i!=4){
                model.getLetters().add(new Sector(new Position(width+2, height+i),"#FFF000"," "));
            }
        }

        width += size;
        width++;
        for(int i = 0; i < size; ++i){
            model.getLetters().add(new Sector(new Position(width+i, height+size-1),"#FFF000"," "));
            if(i!=4){
                model.getLetters().add(new Sector(new Position(width, height+i),"#FFF000"," "));
                model.getLetters().add(new Sector(new Position(width+size-1, height+i),"#FFF000"," "));
            }
        }

        width += size;
        width++;
        for(int i = 0; i < size; ++i){
            model.getLetters().add(new Sector(new Position(width, height+i),"#FFF000"," "));
            model.getLetters().add(new Sector(new Position(width+size-1, height+i),"#FFF000"," "));
            if(i == 1 || i == 2){
                model.getLetters().add(new Sector(new Position(width+i, height+i),"#FFF000"," "));
            }
            if(i == 3){
                model.getLetters().add(new Sector(new Position(width+i, height+1),"#FFF000"," "));
            }
        }
    }

    @Override
    public void setPlayer(PlayerController player) {

    }

    @Override
    public void draw(){
        view.draw(model.getLetters());
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
    public GameResult play(CurrentLevel level) throws IOException, InterruptedException {
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

            if(key == KeyPress.ENTER){
                break;
            }
            if(key == KeyPress.EXIT  || key == KeyPress.EOF){
                return GameResult.EXIT;
            }


            Thread.sleep(1000/30);
        }
        return GameResult.PROCEED;
    }

}
