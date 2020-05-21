package com.quadrivium.g13.model;

public class Sector extends Element {

    private String color;
    private String sectorStr;

    public Sector(Position pos, String color, String sectorStr) {
        this.setPosition(pos);
        this.color = color;
        this.sectorStr = sectorStr;
    }

    public Sector() {
    }

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
