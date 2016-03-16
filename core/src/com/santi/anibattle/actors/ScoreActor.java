package com.santi.anibattle.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.santi.anibattle.utils.Constants;

public class ScoreActor extends Actor {

    private BitmapFont font;
    private int intScore;

    public ScoreActor(int intScore) {
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.getData().setScale(3, 3);
        this.intScore = intScore;
    }

    public int getScore(){
        return intScore;
    }

    public void setScore(int intScore){
        this.intScore = intScore;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        font.draw(batch, Integer.toString(getScore()),
                Constants.APP_WIDTH - 50f,
                Constants.APP_HEIGHT - 50f);
    }

}
