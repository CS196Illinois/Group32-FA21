package com.cs196.midcard;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {
    
    private Map map;
    private Player player;

    private Camera camera;
    private Viewport viewport;

    private SpriteBatch batch;
    private Texture characterTexture;
    
    private static final int WORLD_WIDTH = 800;
    private static final int WORLD_HEIGHT = 600;

    public GameScreen() {
        camera = new OrthographicCamera();
        viewport = new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        batch = new SpriteBatch();
        map = new Map("Battleground1");
        characterTexture = new Texture("mainCharacter.png");
        player = new Player(characterTexture);
    }
    
    @Override
    public void render(float deltaTime) {
        batch.begin();
        resize(WORLD_WIDTH, WORLD_HEIGHT);
        map.renderBackground(batch, WORLD_WIDTH, WORLD_HEIGHT);
        player.draw(batch);
        player.detectInput();
        batch.end();
    }
    @Override
    public void pause() {
        
    }
    @Override
    public void resume() {
        
    }
    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        batch.setProjectionMatrix(camera.combined);
    }
    @Override
    public void show() {
        
    }
    @Override
    public void hide() {
        
    }
    @Override
    public void dispose() {
        batch.dispose();
    }
}