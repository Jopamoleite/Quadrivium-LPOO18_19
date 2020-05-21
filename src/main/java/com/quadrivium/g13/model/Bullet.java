package com.quadrivium.g13.model;

import com.quadrivium.g13.controller.PlayerController;

import java.util.Random;

public class Bullet {
    private char direction;
    private Position position;

    public Bullet(){}

    public Bullet(char direction, Position position){
        this.direction = direction;
        this.position = position;
    }

    public static Bullet bulletFromEnemy(Enemy enemy){
        Random rand = new Random();
        int dir;
        char bullet_direction = 'U';
        dir = rand.nextInt(4); //(0 - up; 1 - left; 2 - down; 3 - right)
        switch(dir){
            case 0:
                bullet_direction = 'U';
                break;
            case 1:
                bullet_direction = 'L';
                break;
            case 2:
                bullet_direction = 'D';
                break;
            case 3:
                bullet_direction = 'R';
                break;
            default:
                break;
        }
        return new Bullet(bullet_direction, new Position(enemy.getPosition()));
    }

    public static Bullet bulletFromPlayer(PlayerController player, char direction){
        return new Bullet(direction, new Position(player.getPosition()));
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
