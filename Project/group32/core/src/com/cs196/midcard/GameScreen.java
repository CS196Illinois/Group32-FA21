package com.cs196.midcard;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import org.w3c.dom.Text;

public class GameScreen implements Screen {

    private Game game;
    private Map map;
    private Player player;
    private Player enemy;

    private Camera camera;
    private Viewport viewport;

    private SpriteBatch batch;

    private Texture characterTexture;
    private Texture cardOneTexture;
    private Texture cardTwoTexture;
    private Texture enemyTexture;

    private Card cardOne;
    private Card cardTwo;
    
    private static final int WORLD_WIDTH = 1920;
    private static final int WORLD_HEIGHT = 1080;

    public GameScreen(Game aGame) {
        game = aGame;
        camera = new OrthographicCamera();
        viewport = new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        batch = new SpriteBatch();
        map = new Map("Battleground2");
        characterTexture = new Texture("mainCharacter.png");
        enemyTexture = new Texture("Enemy/1.png");
        enemy = new Player(enemyTexture, -800, -300, 500, 500);
        player = new Player(characterTexture, -50, -350, 100, 100);
        cardOneTexture = new Texture("Fire 1.jpg");
        cardTwoTexture = new Texture("Fire 2.jpg");
        cardOne = new Card("fire1", cardOneTexture, 300, -500);
        cardTwo = new Card("fire2", cardTwoTexture, 450, -500);
    }
    
    @Override
    public void render(float deltaTime) {
        batch.begin();
        camera.translate((WORLD_WIDTH), (WORLD_HEIGHT), 0);
        map.renderBackground(batch, WORLD_WIDTH, WORLD_HEIGHT);
        player.draw(batch);
        enemy.draw(batch);
        player.detectInput();
        player.checkInMap();
        cardOne.draw(batch);
        cardTwo.draw(batch);
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