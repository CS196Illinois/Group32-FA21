package com.cs196.midcard;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Music introMusic;
	Texture character;
	Player player;
	OrthographicCamera camera;

	@Override
	public void create () {
		batch = new SpriteBatch();

		/*  The music used below is Adventure by Alexander Nakarada
		| https://www.serpentsoundstudios.com
		Music promoted by https://www.chosic.com/free-music/all/
		Attribution 4.0 International (CC BY 4.0)
		https://creativecommons.org/licenses/by/4.0/ */

		introMusic = Gdx.audio.newMusic(Gdx.files.internal("music/Intromusic.mp3"));
		introMusic.setLooping(true);
		introMusic.play();

		character = new Texture("mainCharacter.png");
		camera = new OrthographicCamera();
		player = new Player(character, camera);
		player.setUpCamera();
		player.setUpBatch();
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		player.render();
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		introMusic.dispose();
	}
}