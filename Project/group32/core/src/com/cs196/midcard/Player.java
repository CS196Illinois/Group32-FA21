package com.cs196.midcard;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Input.Keys;

/*  initially the player class should do the following: 
    1- it should show the player's figure on the screen
    2- it should develop the basic movement mechanics and use those
    to move the character on the screen  */

public class Player {

    //define the ScreenWidth and ScreenHeight
    public static final int ScreenWidth = 800;
    public static final int ScreenHeight = 480;
    //define the Constant for the player's speed
    public static final int PlayerSpeed = 10;
    //define the Constant for the player's size
    public static final int PlayerHeight = 36;
    public static final int PlayerWidth = 16;
    //define the Constant for the player's position
    public static final int PlayerInitialPositionX = (ScreenWidth / 2);
    public static final int PlayerInitialPositionY = (ScreenHeight / 2);

    private Texture character;
    private OrthographicCamera camera;
    private SpriteBatch batch = new SpriteBatch();
    private Rectangle characterRec = new Rectangle();
    
    public Player(Texture character, OrthographicCamera camera) {
        this.character = character;
        this.camera = camera;
        characterRec.x = PlayerInitialPositionX;
        characterRec.y = PlayerInitialPositionY;
        characterRec.width = PlayerHeight * 10;
        characterRec.height = PlayerWidth * 10;
    }

    //create a function that sets up the orthogonal camera to the player
    public void setUpCamera() {
        camera.setToOrtho(false, ScreenWidth, ScreenHeight);
        camera.position.set(ScreenWidth / 2, ScreenHeight / 2, 0);
    }
    public void setUpBatch() {
        batch.setProjectionMatrix(camera.combined);
    }
    public void render() {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        camera.update();
        batch.begin();
        batch.draw(character, characterRec.x, characterRec.y,
        characterRec.width, characterRec.height);
        batch.end();

        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            characterRec.x -= PlayerSpeed;
        } else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            characterRec.x += PlayerSpeed;
        } else if (Gdx.input.isKeyPressed(Keys.UP)) {
            characterRec.y += PlayerSpeed;
        } else if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            characterRec.y -= PlayerSpeed;
        }
        // the below will be replaced with tiles and collision detection later
        // once we implement maps
        if (characterRec.x < 0) {
            characterRec.x = 0;
        }
        if (characterRec.x > ScreenWidth - characterRec.width) {
            characterRec.x = ScreenWidth - characterRec.width;
        }
        if (characterRec.y < 0) {
            characterRec.y = 0;
        }
        if (characterRec.y > ScreenHeight - characterRec.height) {
            characterRec.y = ScreenHeight - characterRec.height;
        }
    }
}