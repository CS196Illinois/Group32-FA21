package com.cs196.midcard;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class MidCard extends Game {

	GameScreen gameScreen;
	Music introMusic;
	
	@Override
	public void create () {
		gameScreen = new GameScreen();
		setScreen(gameScreen);
		/*  The music used below is Adventure by Alexander Nakarada
		| https://www.serpentsoundstudios.com
		Music promoted by https://www.chosic.com/free-music/all/
		Attribution 4.0 International (CC BY 4.0)
		https://creativecommons.org/licenses/by/4.0/ */
		introMusic = Gdx.audio.newMusic(Gdx.files.internal("music/Intromusic.mp3"));
	}

	@Override
	public void render () {
		gameScreen.render(Gdx.graphics.getDeltaTime());
		introMusic.play();
		introMusic.setLooping(true);
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