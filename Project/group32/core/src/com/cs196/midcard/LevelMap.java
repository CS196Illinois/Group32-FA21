package com.cs196.midcard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class LevelMap {
    private Texture levelMap;

    public void create() {
        levelMap = new Texture(Gdx.files.internal("Level Map.jpg"));
    }
}