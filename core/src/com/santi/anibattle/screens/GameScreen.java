package com.santi.anibattle.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.santi.anibattle.stages.GameStage;

public class GameScreen implements Screen {

    private GameStage stage;

    public GameScreen(Game game) {
        stage=new GameStage(game);
    }

    @Override
    public void dispose() {

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // Clear the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Update the stage
        stage.draw();
        stage.act(delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }
}
