package com.cs196.midcard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Map {
	private Texture backgroundMap;

	public Map(String mapName) {
		if (mapName.equals("LevelMap")) {
			backgroundMap = new Texture(Gdx.files.internal(mapName + ".jpg"));
		} else if (mapName.equals("gameOver")) {
			backgroundMap = new Texture(Gdx.files.internal(mapName + ".jpeg"));
		} else {
			backgroundMap = new Texture(Gdx.files.internal(mapName + "/" + "Bright" + "/" + mapName + ".png"));
		}
	}

	public void renderBackground(SpriteBatch batch, float WORLD_WIDTH, float WORLD_HEIGHT) {
		batch.draw(backgroundMap, -(WORLD_WIDTH/2), -(WORLD_HEIGHT/2), WORLD_WIDTH, WORLD_HEIGHT);
	}
}
