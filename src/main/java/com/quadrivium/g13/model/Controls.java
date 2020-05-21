package com.quadrivium.g13.model;

import java.util.List;

public class Controls {

    private List<Sector> letters;
    private int letterY;
    private int letterX;
    private int letterSize;

    public Controls(){

    }

    public List<Sector> getLetters() {
        return letters;
    }

    public void setLetters(List<Sector> letters) {
        this.letters = letters;
    }

    public int getLetterY() {
        return letterY;
    }

    public void setLetterY(int letterY) {
        this.letterY = letterY;
    }

    public int getLetterX() {
        return letterX;
    }

    public void setLetterX(int letterX) {
        this.letterX = letterX;
    }

    public int getLetterSize() {
        return letterSize;
    }

    public void setLetterSize(int letterSize) {
        this.letterSize = letterSize;
    }
}
