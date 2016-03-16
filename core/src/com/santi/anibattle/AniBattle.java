package com.santi.anibattle;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.Game;
import com.santi.anibattle.screens.GameScreen;
import com.santi.anibattle.screens.MainMenuScreen;

public class AniBattle extends Game {

	@Override
	public void create() {
		setScreen(new MainMenuScreen(this));
	}

	public void render(){
		super.render();
	}

}
