package com.cs196.midcard;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MapScreen implements Screen {

    private Game game;
    private Stage stage;
    private Map map;
    private Player player;

    private Camera camera;
    private Viewport viewport;

    private SpriteBatch batch;
    private Texture characterTexture;

    private static final int WORLD_WIDTH = 1920;
    private static final int WORLD_HEIGHT = 1080;

    public MapScreen(Game aGame) {
        game = aGame;
        camera = new OrthographicCamera();
        viewport = new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        batch = new SpriteBatch();
        map = new Map("LevelMap");
        characterTexture = new Texture("mainCharacter.png");
        player = new Player(characterTexture, 400, -500, 100, 100);
    }

    public void render(float deltaTime) {
        batch.begin();
        camera.translate((WORLD_WIDTH), (WORLD_HEIGHT), 0);
        map.renderBackground(batch, WORLD_WIDTH, WORLD_HEIGHT);
        player.draw(batch);
        player.detectInput();
        player.checkInMap();
        if (player.getY() == -400) {
            game.setScreen(new GameScreen(game));
        }
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

    public int getWidth() {
        return WORLD_WIDTH;
    }

    public int getHeight() {
        return WORLD_HEIGHT;
    }
}
