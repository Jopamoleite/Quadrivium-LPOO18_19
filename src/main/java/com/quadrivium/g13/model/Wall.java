package com.quadrivium.g13.model;

import com.quadrivium.g13.exceptions.OutOfBoundsException;

public class Wall extends Element{
    private String color;
    private String wallStr;

    public Wall(){}

    public Wall(Position position) throws OutOfBoundsException {
        setPosition(position);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWallStr() {
        return wallStr;
    }

    public void setWallStr(String wallStr) {
        this.wallStr = wallStr;
    }
}
