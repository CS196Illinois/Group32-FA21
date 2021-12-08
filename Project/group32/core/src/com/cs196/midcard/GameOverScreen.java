package com.cs196.midcard;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameOverScreen implements Screen {
    private Map map;
    private SpriteBatch batch;

    private static final int WORLD_WIDTH = 1920;
    private static final int WORLD_HEIGHT = 1080;
    private Viewport viewport;
    private Camera camera;

    public GameOverScreen() {
        map = new Map("gameOver");
        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        batch.begin();
        map.renderBackground(batch, WORLD_WIDTH, WORLD_HEIGHT);
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        batch.setProjectionMatrix(camera.combined);
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

    @Override
    public void dispose() {
        batch.dispose();
    }
}
