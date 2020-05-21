package com.quadrivium.g13.controller;

import com.quadrivium.g13.exceptions.InvalidGameException;
import com.quadrivium.g13.exceptions.OutOfBoundsException;
import com.quadrivium.g13.model.*;
import com.quadrivium.g13.view.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BattleTanksController extends ScoreSubject implements GameController{
    private BattleTanks model;
    private BattleTanksView view;
    private List<ScoreObserver> scoreObservers;
    private int score;

    public BattleTanksController(BattleTanks model, BattleTanksView view) throws OutOfBoundsException, InvalidGameException {
        this.model = model;
        this.view = view;
        List<Enemy> new_enemies = new ArrayList<>();
        this.scoreObservers = new ArrayList<>();
        this.scoreObservers.add(new ScoreObserver(this));
        this.score = 0;
        new_enemies.add(GetEnemyFactory.generateEnemy(new Position(29, 4),"BT"));
        new_enemies.add(GetEnemyFactory.generateEnemy(new Position(GameDimensions.getWidth()-29, 4), "BT"));
        new_enemies.add(GetEnemyFactory.generateEnemy(new Position(29, GameDimensions.getHeight()-5), "BT"));
        new_enemies.add(GetEnemyFactory.generateEnemy(new Position(GameDimensions.getWidth()-29, GameDimensions.getHeight()-5), "BT"));
        model.setActiveEnemies(new_enemies);
    }

    public void setEnemyAtPlayerPosition() throws OutOfBoundsException, InvalidGameException {
        this.model.setTestEnemy(GetEnemyFactory.generateEnemy(new Position(this.model.getPlayer().getPosition().getX(), this.model.getPlayer().getPosition().getY()), "BT"));
        this.model.setTestEnemyActive(true);
    }

    public PlayerController getPlayer(){
        return model.getPlayer();
    }

    @Override
    public void setPlayer(PlayerController player) {
        model.setPlayer(player);
    }

    @Override
    public synchronized void draw() {
        if(GameDimensions.isSwing())
            model.getPlayer().draw();
        view.draw(model.getMapWalls(), model.getActivePlayerBullets(), model.getActiveEnemies(), model.getActiveEnemyBullets(), model.isAllEnemiesKilled(), model.getPlayerLives(), score);
        if(!GameDimensions.isSwing())
            model.getPlayer().draw();
    }

    private boolean canElementMove(Position position){
        for (Wall wall : model.getMapWalls()){
            if(position.equals(wall.getPosition()))
                return false;
        }
        return !((position.getX() >= (GameDimensions.getWidth()-1)) || (position.getX()<=0) || (position.getY() >= (GameDimensions.getHeight()-1)) || (position.getY()<=0));
    }

    private void movePlayer(Position position) throws OutOfBoundsException {
        if(canElementMove(position)) {
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
            case W:
                shoot('U');
                break;
            case A:
                shoot('L');
                break;
            case S:
                shoot('D');
                break;
            case D:
                shoot('R');
                break;
            default:
                break;
        }
    }

    @Override
    public boolean checkEnter(KeyPress key, CurrentLevel level){
        return (key == KeyPress.ENTER);
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

        for(int j = 7; j < 9; j++) {
            newWalls.add(new Wall(new Position(36, j)));
            newWalls.add(new Wall(new Position(37, j)));
            newWalls.add(new Wall(new Position(38, j)));

            for (int i = 45; i <= 56; i++) {
                newWalls.add(new Wall(new Position(i, j)));
            }
            for (int i = 63; i <= 76; i++) {
                newWalls.add(new Wall(new Position(i, j)));
            }
            for (int i = 83; i <= 89; i++) {
                newWalls.add(new Wall(new Position(i, j)));
            }
        }

        for(int  j = 9; j <= 11; j++) {
            newWalls.add(new Wall(new Position(36, j)));
            newWalls.add(new Wall(new Position(37, j)));
            newWalls.add(new Wall(new Position(38, j)));
            for(int i = 54; i <= 56; i++)
                newWalls.add(new Wall (new Position(i, j)));
        }

        for(int i = 45; i <= 47; i++) {
            newWalls.add(new Wall(new Position(i,12)));
            newWalls.add(new Wall(new Position(i,13)));
            newWalls.add(new Wall(new Position(i,14)));

            newWalls.add(new Wall(new Position(i,18)));
            newWalls.add(new Wall(new Position(i,19)));
            newWalls.add(new Wall(new Position(i,20)));
        }

        for(int i = 16; i <= 21; i++){
            newWalls.add(new Wall(new Position(36, i)));
            newWalls.add(new Wall(new Position(37, i)));
            newWalls.add(new Wall(new Position(38, i)));
        }

        for(int i = 27; i <= 33; i++){
            newWalls.add(new Wall(new Position(36, i)));
            newWalls.add(new Wall(new Position(37, i)));
            newWalls.add(new Wall(new Position(38, i)));
        }

        for(int j = 32; j < 34; j++) {
            newWalls.add(new Wall(new Position(87, j)));
            newWalls.add(new Wall(new Position(88, j)));
            newWalls.add(new Wall(new Position(89, j)));

            for (int i = 71; i <= 82; i++) {
                newWalls.add(new Wall(new Position(i, j)));
            }
            for (int i = 51; i <= 64; i++) {
                newWalls.add(new Wall(new Position(i, j)));
            }
            for (int i = 38; i <= 44; i++) {
                newWalls.add(new Wall(new Position(i, j)));
            }
        }

        for(int  j = 29; j <= 31; j++) {
            newWalls.add(new Wall(new Position(87, j)));
            newWalls.add(new Wall(new Position(88, j)));
            newWalls.add(new Wall(new Position(89, j)));
            for(int i = 62; i <= 64; i++)
                newWalls.add(new Wall (new Position(i, j)));
        }

        for(int i = 77; i <= 79; i++) {
            newWalls.add(new Wall(new Position(i, 28)));
            newWalls.add(new Wall(new Position(i,27)));
            newWalls.add(new Wall(new Position(i, 26)));

            newWalls.add(new Wall(new Position(i, 22)));
            newWalls.add(new Wall(new Position(i, 21)));
            newWalls.add(new Wall(new Position(i, 20)));
        }

        for(int i = 15; i <= 20; i++) {
            newWalls.add(new Wall(new Position(87, i)));
            newWalls.add(new Wall(new Position(88, i)));
            newWalls.add(new Wall(new Position(89, i)));

        }

        for(int i = 55; i < 59; i++){
            newWalls.add(new Wall(new Position(i,17)));
            newWalls.add(new Wall(new Position(i,GameDimensions.getHeight()-18)));
        }
        for(int i = 66; i < 70; i++){
            newWalls.add(new Wall(new Position(i,17)));
            newWalls.add(new Wall(new Position(i,GameDimensions.getHeight()-18)));
        }
        for(int i = 17; i < GameDimensions.getHeight()-18; i++){
            newWalls.add(new Wall(new Position(55,i)));
            newWalls.add(new Wall(new Position(GameDimensions.getWidth()-56, i)));
        }

        for(Wall wall : newWalls){
            wall.setColor("#00FF00");
            wall.setWallStr("\u25AE");
        }

        model.setMapWalls(newWalls);
    }

    private synchronized void shoot(char direction){
        if(model.getActivePlayerBullets().size()<10) {
            Bullet newBullet = Bullet.bulletFromPlayer(model.getPlayer(), direction);
            List<Bullet> newBulletsList = model.getActivePlayerBullets();
            newBulletsList.add(newBullet);
            model.setActivePlayerBullets(newBulletsList);
        }
    }

    private synchronized void updateBullets() throws OutOfBoundsException {
        for(Bullet bullet : model.getActivePlayerBullets()){
            switch(bullet.getDirection()){
                case 'U':
                    bullet.getPosition().setY(bullet.getPosition().getY()-1);
                    break;
                case 'L':
                    bullet.getPosition().setX(bullet.getPosition().getX()-1);
                    break;
                case 'D':
                    bullet.getPosition().setY(bullet.getPosition().getY()+1);
                    break;
                case 'R':
                    bullet.getPosition().setX(bullet.getPosition().getX()+1);
                    break;
                default:
                    break;
            }
        }
        checkPlayerBulletCollisions();
        for(Bullet bullet : model.getActiveEnemyBullets()){
            switch(bullet.getDirection()){
                case 'U':
                    bullet.getPosition().setY(bullet.getPosition().getY()-1);
                    break;
                case 'L':
                    bullet.getPosition().setX(bullet.getPosition().getX()-1);
                    break;
                case 'D':
                    bullet.getPosition().setY(bullet.getPosition().getY()+1);
                    break;
                case 'R':
                    bullet.getPosition().setX(bullet.getPosition().getX()+1);
                    break;
                default:
                    break;
            }
        }
        checkEnemyBulletCollisions();
    }

    private synchronized void checkPlayerBulletCollisions(){
        List<Bullet> bullets = model.getActivePlayerBullets();
        List<Enemy> enemies = model.getActiveEnemies();
        for(int i = 0; i < bullets.size(); i++){
            Bullet bullet = bullets.get(i);
            for(int j = 0; j < enemies.size(); j++){
                Enemy enemy = enemies.get(j);
                if(bullet.getPosition().equals(enemy.getPosition())){
                    if (model.getActivePlayerBullets().remove(bullet)) {
                        i--;
                    }
                    enemy.setAlive(false);
                    model.getActiveEnemies().remove(enemy);
                    setScore(getScore()+500);
                    j--;
                    break;
                }
            }
            for(Wall wall : model.getMapWalls()){
                if(bullet.getPosition().equals(wall.getPosition())) {
                    if (model.getActivePlayerBullets().remove(bullet)) {
                        i--;
                        break;
                    }
                }
            }

        }
    }

    public void setPlayerLives(int lives){
        model.setPlayerLives(lives);
    }

    private synchronized void checkEnemyBulletCollisions() throws OutOfBoundsException {
        List<Bullet> bullets = model.getActiveEnemyBullets();
        for(int i = 0; i < bullets.size(); i++){
            Bullet bullet = bullets.get(i);
            for(Wall wall : model.getMapWalls()){
                if(bullet.getPosition().equals(wall.getPosition())){
                    if(model.getActiveEnemyBullets().remove(bullet)){
                        i--;
                    }
                }
                else if(bullet.getPosition().equals(model.getPlayer().getPosition())){
                    if(model.getActiveEnemyBullets().remove(bullet)){
                        i--;
                    }
                    model.setPlayerLives(model.getPlayerLives()-1);
                    model.getPlayer().resetPosition();
                }
            }
        }
    }

    private synchronized void checkPlayerEnemyCollisions() throws OutOfBoundsException {
        for(Enemy enemy : model.getActiveEnemies()){
            if(enemy.getPosition().equals(model.getPlayer().getPosition())){
                model.setPlayerLives(model.getPlayerLives()-1);
                model.getPlayer().resetPosition();
                return;
            }
        }
        if(model.isTestEnemyActive()){
            if(model.getTestEnemy().getPosition().equals(model.getPlayer().getPosition())){
                model.setPlayerLives(model.getPlayerLives()-1);
                model.getPlayer().resetPosition();
            }
        }
    }

    private synchronized void moveEnemies() throws OutOfBoundsException {
        Random rand = new Random();
        List<Enemy> enemies = model.getActiveEnemies();
        int direction; //(0 - up; 1 - left; 2 - down; 3 - right)
        for(Enemy enemy : enemies){
            direction = rand.nextInt(4);
            switch(direction){
                case 0:
                    if(canElementMove(enemy.moveUp())) {
                        enemy.setPosition(enemy.moveUp());
                    }
                    break;
                case 1:
                    if(canElementMove(enemy.moveLeft()))
                        enemy.setPosition(enemy.moveLeft());
                    break;
                case 2:
                    if(canElementMove(enemy.moveDown()))
                        enemy.setPosition(enemy.moveDown());
                    break;
                case 3:
                    if(canElementMove(enemy.moveRight()))
                        enemy.setPosition(enemy.moveRight());
                    break;
                default:
                    break;
            }
        }
    }



    private synchronized void generateEnemyBullets(){
        Random rand = new Random();
        List<Enemy> enemies = model.getActiveEnemies();
        int enemy_index;
        if(enemies.size() == 0)
            return;
        enemy_index = rand.nextInt(enemies.size());
        model.getActiveEnemyBullets().add(Bullet.bulletFromEnemy(model.getActiveEnemies().get(enemy_index)));
    }

    private synchronized void updateEnemies() throws OutOfBoundsException {
        moveEnemies();
        generateEnemyBullets();
    }

    private boolean hasPlayerWon(){
        if(model.isAllEnemiesKilled()){
            for(int i = 56; i < 69; i++){
                for(int j = 18; j < 23; j++){
                    if(model.getPlayer().getPosition().equals(new Position(i,j)))
                        return true;
                }
            }
        }
        return false;
    }


    @Override
    public GameResult play(CurrentLevel level) throws IOException, InterruptedException, OutOfBoundsException {

        generateMap();
        Thread bullets_thread = new Thread() {
            public void run(){
                do {
                    try {
                        updateBullets();
                    } catch (OutOfBoundsException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        break;
                    }
                } while (!isInterrupted());
            }
        };
        Thread enemies_thread = new Thread() {
            public void run(){
                do {
                    try {
                        updateEnemies();
                    } catch (OutOfBoundsException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        break;
                    }
                } while (!isInterrupted());
            }
        };
        enemies_thread.start();
        bullets_thread.start();

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

            checkPlayerEnemyCollisions();

            if(model.getPlayerLives() == 0){
                bullets_thread.interrupt();
                enemies_thread.interrupt();
                for(ScoreObserver obs : scoreObservers){
                    detach(obs);
                }
                if(GameDimensions.isSwing()){
                    level.setActiveGame(new LoseScreenController(new LoseScreen(), new SwingLoseScreenView()));
                }
                else{
                    level.setActiveGame(new LoseScreenController(new LoseScreen(), new LanternaLoseScreenView()));
                }
                return GameResult.LOSE;
            }

            if(model.getActiveEnemies().size() == 0){
                model.setAllEnemiesKilled(true);
            }

            if(checkEnter(key, level)){
                if(hasPlayerWon()) {
                    bullets_thread.interrupt();
                    enemies_thread.interrupt();
                    break;
                }
            }

            if (key == KeyPress.EXIT  || key == KeyPress.EOF){
                bullets_thread.interrupt();
                enemies_thread.interrupt();
                for(ScoreObserver obs : scoreObservers){
                    detach(obs);
                }
                return GameResult.EXIT;
            }

            Thread.sleep(1000/30);
        }
        try {
            bullets_thread.join();
            enemies_thread.join();
        } catch (InterruptedException ignored) {
        }
        for(ScoreObserver obs : scoreObservers){
            detach(obs);
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
