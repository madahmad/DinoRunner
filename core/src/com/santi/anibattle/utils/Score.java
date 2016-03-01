package com.santi.anibattle.utils;

public class Score {

    private String score;

    public Score(String score){
        this.score = score;
    }

    public String getScore() {
        return score;
    }

    public void incrementScore(){
        int intScore = Integer.parseInt(score);
        intScore += 1;
        score = Integer.toString(intScore);
    }

}
