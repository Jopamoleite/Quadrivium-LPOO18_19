package com.quadrivium.g13.model;

import com.quadrivium.g13.exceptions.OutOfBoundsException;

public class Sector extends Element{

    private String color;
    private String sectorStr;

    public Sector(Position pos, String color, String sectorStr) throws OutOfBoundsException {
        this.setPosition(pos);
        this.color = color;
        this.sectorStr = sectorStr;
    }

    public Sector(){}

    public String getSectorStr() {
        return sectorStr;
    }

    public void setSectorStr(String sectorStr) {
        this.sectorStr = sectorStr;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
