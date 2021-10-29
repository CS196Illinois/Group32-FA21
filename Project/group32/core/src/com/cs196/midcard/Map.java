package com.cs196.midcard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Map {
	private Texture battleBackground1;
	private Texture battleBackground2;
	private Texture battleBackground3;
	private Texture battleBackground4;
	private Texture battleBackground5;
	
	public void create() {
		battleBackground1 = new Texture(Gdx.files.internal("Battleground1.png"));
		battleBackground2 = new Texture(Gdx.files.internal("Battleground2.png"));
		battleBackground3 = new Texture(Gdx.files.internal("Battleground3.png"));
		battleBackground4 = new Texture(Gdx.files.internal("Battleground4.png"));
		battleBackground5 = new Texture(Gdx.files.internal("Battleground5.png"));
	}
}
