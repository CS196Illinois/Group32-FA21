package com.cs196.midcard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;

public class LevelMap {
    private Texture levelMap;
    private Texture mainCharacter;
    private Rectangle rectChar;
    private Music music;
    private OrthographicCamera camera;

    public void create() {
        // load level map
        levelMap = new Texture(Gdx.files.internal("Level Map.jpg"));

        // load character
        mainCharacter = new Texture(Gdx.files.internal("mainCharacter.png"));

        // load music
        music = Gdx.audio.newMusic(Gdx.files.internal("music/Intromusic.mp3"));
        music.setLooping(true);
        music.play();



    }
}