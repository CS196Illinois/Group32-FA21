package com.cs196.midcard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

public class LevelMap extends ApplicationAdapter {

    private static final int WORLD_WIDTH = 1920;
    private static final int WORLD_HEIGHT = 1080;

    private Map map;
    private Texture levelMap;
    private Texture mainCharacter;
    private Rectangle rectChar;
    private Music music;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Array<Rectangle> levelRects;

    @Override
    public void create() {
        // load level map
        levelMap = new Texture(Gdx.files.internal("Level Map.jpg"));
        map = new Map("LevelMap");
        //  <- USE FOR render() !!!!!!!

        // load character
        mainCharacter = new Texture(Gdx.files.internal("mainCharacter.png"));

        // load music
        music = Gdx.audio.newMusic(Gdx.files.internal("music/Intromusic.mp3"));
        music.setLooping(true);
        music.play();

        // camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);
        batch = new SpriteBatch();

        // create a Rectangle to logically represent the main character
        rectChar = new Rectangle();
        rectChar.x = 700;
        rectChar.y = 20;
        rectChar.width = 64;
        rectChar.height = 64;

        // create level map rectangles
        // levelRects = { the 8 positions };
    }

    @Override
    public void render() {
        // render background
        map.renderBackground(batch, WORLD_WIDTH, WORLD_HEIGHT);

        //update camera
        camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        batch.setProjectionMatrix(camera.combined);

        // begin a new batch and draw the main character
        batch.begin();
        batch.draw(mainCharacter, rectChar.x, rectChar.y);
        batch.end();

        if(rectChar.x < 0) rectChar.x = 0;
        if(rectChar.x > 800 - 64) rectChar.x = 800 - 64;
    }
}