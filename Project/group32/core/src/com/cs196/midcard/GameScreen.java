package com.cs196.midcard;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
    private Texture enemyTexture;
    private Texture cardOneTexture;
    private Texture cardTwoTexture;
    private Texture cardThreeTexture;
    private Texture cardFourTexture;

    private Card cardOne;
    private Card cardTwo;
    private Card cardThree;
    private Card cardFour;

    private Entity boss;
    private Entity user;

    private Music battleMusic;

    BitmapFont font = new BitmapFont();
    
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
        cardThreeTexture = new Texture("Water_1.jpg");
        cardFourTexture = new Texture("Water_2.jpg");
        cardOne = new Card("fire1", cardOneTexture, 300, -500);
        cardTwo = new Card("fire2", cardTwoTexture, 450, -500);
        cardThree = new Card("water1", cardThreeTexture, 600, -500);
        cardFour = new Card("water2", cardFourTexture, 750, -500);
        boss = new Entity(500, 2);
        user = new Entity(200, 1);
    }
    
    @Override
    public void render(float deltaTime) {
        batch.begin();
        camera.translate((WORLD_WIDTH), (WORLD_HEIGHT), 0);
        map.renderBackground(batch, WORLD_WIDTH, WORLD_HEIGHT);
        player.draw(batch);
        player.detectInput();
        player.checkInMap();
        enemy.draw(batch);

        if (Gdx.input.getX() > 300 && Gdx.input.getX() < 400) {
            System.out.println("Did it work?");
        }

        cardOne.draw(batch);
        cardTwo.draw(batch);
        cardThree.draw(batch);
        cardFour.draw(batch);

        font.getData().setScale(5, 5);
        font.draw(batch, "Enemy HP : " + boss.getHp(), -1000, 500);
        font.draw(batch, "Player HP : " + user.getHp(), 300, 500);

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