package com.santi.anibattle.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.santi.anibattle.utils.Score;

public class ScoreActor extends Actor {

    private SpriteBatch batch;
    private BitmapFont font;
    private Score score;

    public ScoreActor(Score score) {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.getData().setScale(3, 3);
        this.score = score;
    }

    @Override
    public void act(float delta) {
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        font.draw(batch, score.getScore(), 700, 400);    // 0,0 is bottom left
    }

}
