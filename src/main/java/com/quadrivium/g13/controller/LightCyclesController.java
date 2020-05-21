package com.quadrivium.g13.controller;

import com.quadrivium.g13.exceptions.InvalidGameException;
import com.quadrivium.g13.exceptions.OutOfBoundsException;
import com.quadrivium.g13.model.*;
import com.quadrivium.g13.view.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LightCyclesController extends ScoreSubject implements GameController{
    private LightCycles model;
    private LightCyclesView view;
    private int score;
    private List<ScoreObserver> scoreObservers;

    public LightCyclesController(LightCycles model, LightCyclesView view) throws OutOfBoundsException, InvalidGameException {
        this.model = model;
        this.view = view;
        this.score = 0;
        this.scoreObservers = new ArrayList<>();
        initEnemy();
        generateMap();
        initTrails();
    }

    public LightCycles.Direction getCurrentDirection(){
        return this.model.getCurrentDirection();
    }

    private void initEnemy() throws OutOfBoundsException, InvalidGameException {
        Enemy model = GetEnemyFactory.generateEnemy(new Position(GameDimensions.getWidth()/2,GameDimensions.getHeight()*3/4), "LC");
        LightCyclesEnemyView view;
        if(GameDimensions.isSwing())
            view = new SwingLightCyclesEnemyView();
        else
            view = new LanternaLightCyclesEnemyView();
        this.model.setEnemy(new LightCyclesEnemyController(model, view ));
        this.model.getEnemy().setAlive(true);
    }

    private void initTrails(){
        List<Wall> newTrails = new ArrayList<>();
        model.setTrails(newTrails);
        List<Wall> newEnemyTrails = new ArrayList<>();
        model.setEnemyTrails(newEnemyTrails);
    }

    private void generateMap() throws OutOfBoundsException {
        List<Wall> newWalls = new ArrayList<>();
        for(int i = 28; i < GameDimensions.getWidth()-27; i++){
            newWalls.add(new Wall(new Position(i,3)));
            newWalls.add(new Wall(new Position(i,GameDimensions.getHeight()-4)));
        }
        for(int i = 3; i < GameDimensions.getHeight()-4; i++){
            newWalls.add(new Wall(new Position(28,i)));
            newWalls.add(new Wall(new Position(GameDimensions.getWidth()-28, i)));
        }
        for(Wall wall : newWalls){
            wall.setColor("#00FFFF");
            wall.setWallStr("X");
        }
        model.setMapWalls(newWalls);
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
        if(GameDimensions.isSwing()){
            model.getPlayer().draw();
            model.getEnemy().draw();
        }
        view.draw(model.getMapWalls(), model.getTrails(), model.getEnemyTrails(), score);
        if(!GameDimensions.isSwing()){
            model.getPlayer().draw();
            model.getEnemy().draw();
        }
    }

    private boolean canPlayerMove(Position position){
        for (Wall wall : model.getMapWalls()){
            if(position.equals(wall.getPosition()))
                return false;
        }
        for (Wall trail : model.getTrails()){
            if(position.equals(trail.getPosition()))
                return false;
        }
        for (Wall trail : model.getEnemyTrails()){
            if(position.equals(trail.getPosition()))
                return false;
        }

        return (position != model.getPlayer().getPosition() && position != model.getEnemy().getPosition());
    }

    private boolean movePlayer() throws OutOfBoundsException {
        Position position;
        Position oldPosition = model.getPlayer().getPosition();
        switch(model.getCurrentDirection()){
            case UP:
                position = model.getPlayer().moveUp();
                break;
            case RIGHT:
                position = model.getPlayer().moveRight();
                break;
            case DOWN:
                position = model.getPlayer().moveDown();
                break;
            case LEFT:
                position = model.getPlayer().moveLeft();
                break;
            default:
                position = model.getPlayer().getPosition();
        }
        if(canPlayerMove(position)){
            List<Wall> newTrail = model.getTrails();
            Wall trail = new Wall(oldPosition);
            trail.setWallStr("X");
            trail.setColor("#F0F000");
            newTrail.add(trail);
            model.setTrails(newTrail);
            model.getPlayer().setPosition(position);
        }
        else{
            return false;
        }
        return true;
    }

    private void moveEnemy() throws OutOfBoundsException {
        Position position = model.getEnemy().getPosition();
        List<Character> moveTo = new ArrayList<>();
        moveTo.add('U');
        moveTo.add('R');
        moveTo.add('D');
        moveTo.add('L');
        moveTo.add('U');
        moveTo.add('R');
        Random rand = new Random();
        Character direction = moveTo.get(rand.nextInt(moveTo.size()));

        Position oldPosition = position;

        switch(direction){
            case 'U':
                position = model.getEnemy().moveUp();
                if(!canPlayerMove(position)){
                    position = model.getEnemy().moveDown();
                }
                if(!canPlayerMove(position)){
                    position = model.getEnemy().moveRight();
                }
                if(!canPlayerMove(position)){
                    position = model.getEnemy().moveLeft();
                }
                break;
            case 'R':
                position = model.getEnemy().moveRight();
                if(!canPlayerMove(position)){
                    position = model.getEnemy().moveLeft();
                }
                if(!canPlayerMove(position)){
                    position = model.getEnemy().moveDown();
                }
                if(!canPlayerMove(position)){
                    position = model.getEnemy().moveUp();
                }
                break;
            case 'D':
                position = model.getEnemy().moveDown();
                if(!canPlayerMove(position)){
                    position = model.getEnemy().moveUp();
                }
                if(!canPlayerMove(position)){
                    position = model.getEnemy().moveLeft();
                }
                if(!canPlayerMove(position)){
                    position = model.getEnemy().moveRight();
                }
                break;
            case 'L':
                position = model.getEnemy().moveLeft();
                if(!canPlayerMove(position)){
                    position = model.getEnemy().moveRight();
                }
                if(!canPlayerMove(position)){
                    position = model.getEnemy().moveUp();
                }
                if(!canPlayerMove(position)){
                    position = model.getEnemy().moveDown();
                }
                break;
        }

        if(canPlayerMove(position)){
            List<Wall> newTrail = model.getEnemyTrails();
            Wall trail = new Wall(oldPosition);
            trail.setWallStr("X");
            trail.setColor("#000FFF");
            newTrail.add(trail);
            model.setEnemyTrails(newTrail);
            model.getEnemy().setPosition(position);
        }
        else{
            model.getEnemy().setAlive(false);
        }
    }

    void handleKey(KeyPress key){
        switch (key) {
            case UP:
                if(model.getCurrentDirection() != LightCycles.Direction.DOWN)
                    model.setCurrentDirection(LightCycles.Direction.UP);
                break;
            case RIGHT:
                if(model.getCurrentDirection() != LightCycles.Direction.LEFT)
                    model.setCurrentDirection(LightCycles.Direction.RIGHT);
                break;
            case DOWN:
                if(model.getCurrentDirection() != LightCycles.Direction.UP)
                    model.setCurrentDirection(LightCycles.Direction.DOWN);
                break;
            case LEFT:
                if(model.getCurrentDirection() != LightCycles.Direction.RIGHT)
                    model.setCurrentDirection(LightCycles.Direction.LEFT);
                break;
        }
    }

    @Override
    public boolean checkEnter(KeyPress key, CurrentLevel level){
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

            if(!model.getEnemy().isAlive()){
               break;
            }

            moveEnemy();

            if(!movePlayer()){
                if(GameDimensions.isSwing()){
                    level.setActiveGame(new LoseScreenController(new LoseScreen(), new SwingLoseScreenView()));
                }
                else{
                    level.setActiveGame(new LoseScreenController(new LoseScreen(), new LanternaLoseScreenView()));
                }
                return GameResult.LOSE;
            }

            if (key == KeyPress.EXIT  || key == KeyPress.EOF){
                return GameResult.EXIT;
            }
            setScore(getScore()+1);
            Thread.sleep(150);
        }
        if(GameDimensions.isSwing()){
            level.setActiveGame(new WinScreenController(new WinScreen(), new SwingWinScreenView()));
        }
        else{
            level.setActiveGame(new WinScreenController(new WinScreen(), new LanternaWinScreenView()));
        }
        return GameResult.WIN;
    }

    @Override
    public void attach(ScoreObserver observer) {
        scoreObservers.add(observer);
    }

    @Override
    public void detach(ScoreObserver observer) {
        scoreObservers.remove(observer);
    }

    @Override
    public void notifyObs() {
        for(ScoreObserver observer : scoreObservers){
            observer.update();
        }
    }

    public List<ScoreObserver> getScoreObservers() {
        return scoreObservers;
    }

    public void setScoreObservers(List<ScoreObserver> scoreObservers) {
        this.scoreObservers = scoreObservers;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void setScore(int score) {
        notifyObs();
        this.score = score;
    }
}
