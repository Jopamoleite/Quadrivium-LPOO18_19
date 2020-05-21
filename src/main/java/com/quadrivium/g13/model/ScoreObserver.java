package com.quadrivium.g13.model;

public class ScoreObserver {
    private int score;
    private ScoreSubject subject;

    public ScoreObserver(ScoreSubject subject){
        this.subject = subject;
        this.subject.attach(this);
        this.update();
    }

    public void update(){
        this.setScore(this.subject.getScore());
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
