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
    private Player fire1;

    private Camera camera;
    private Viewport viewport;

    private Battle battle;

    private SpriteBatch batch;

    private Texture characterTexture;
    private Texture enemyTexture;
    private Texture cardOneTexture;
    private Texture cardTwoTexture;
    private Texture cardThreeTexture;
    private Texture cardFourTexture;
    private Texture fire1Texture;

    private Card cardOne;
    private Card cardTwo;
    private Card cardThree;
    private Card cardFour;

    private Entity boss;
    private Entity user;

    private int bossHp;
    private int playerHp;

    private String bossHpString = String.valueOf(bossHp);
    private String playerHpString = String.valueOf(playerHp);

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
        fire1Texture = new Texture("Visual Effects/alt fire.png");
        fire1 = new Player(fire1Texture, 0, -150, 150, 150);
        cardOneTexture = new Texture("Fire 1.jpg");
        cardTwoTexture = new Texture("Fire 2.jpg");
        cardThreeTexture = new Texture("Water_1.jpg");
        cardFourTexture = new Texture("Water_2.jpg");
        cardOne = new Card("fire1", cardTwoTexture, 300, -500, 45, 105);
        cardTwo = new Card("fire2", cardOneTexture, 450, -500, 30, 95);
        cardThree = new Card("water1", cardThreeTexture, 600, -500, 45, 100);
        cardFour = new Card("water2", cardFourTexture, 750, -500, 50, 150);
        boss = new Entity(500, 2);
        user = new Entity(200, 1);
        battle = new Battle();
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
        battle.detectInput();
        if (battle.isClicked() == true) {
            fire1.draw(batch);
            fire1.setMove();
        }

        cardOne.draw(batch);
        cardTwo.draw(batch);
        cardThree.draw(batch);
        cardFour.draw(batch);
        font.getData().setScale(5, 5);
        font.draw(batch, "Enemy HP: " + boss.getHp(), -900, 500);
        font.draw(batch, "Player HP: " + user.getHp(), 400, 500);

        if (battle.detectInput() == 1) {
            boss.setHp(boss.getHp() - 15);
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
}