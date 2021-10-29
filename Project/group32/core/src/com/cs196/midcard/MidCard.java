package com.cs196.midcard;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class MidCard extends Game {

	GameScreen gameScreen;

	@Override
	public void create () {
		gameScreen = new GameScreen();
		setScreen(gameScreen);
	}

	@Override
	public void render () {
		gameScreen.render(Gdx.graphics.getDeltaTime());
	}
	
	@Override
	public void dispose () {
		gameScreen.dispose();
	}
	@Override
	public void resize(int width, int height) {
		gameScreen.resize(width, height);
	}
}