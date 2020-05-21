package com.quadrivium.g13.model;

public abstract class ScoreSubject {
    public abstract void attach(ScoreObserver observer);
    public abstract void detach(ScoreObserver observer);
    public abstract void notifyObs();
    public abstract int getScore();
    public abstract void setScore(int score);
}
