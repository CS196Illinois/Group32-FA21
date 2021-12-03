package com.cs196.midcard;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.Input.Keys;

/*  initially the player class should do the following: 
    1- it should show the player's figure on the screen
    2- it should develop the basic movement mechanics and use those
    to move the character on the screen  */

public class Player {

    //define the ScreenWidth and ScreenHeight
    public static final int ScreenWidth = (int) (1920.0 / 2.0);
    public static final int ScreenHeight = (int) (1080.0 / 2.0);
    //define the Constant for the player's speed
    public static final int PlayerSpeed = 5;
    //define the Constant for the player's size
    public static final int PlayerHeight = 100;
    public static final int PlayerWidth = 100;
    //define the Constant for the player's position
    public static int PlayerInitialPositionX = 400;
    public static int PlayerInitialPositionY = -500;

    private Texture character;
    private Rectangle characterRec = new Rectangle();
    
    public Player(Texture character) {
        this.character = character;
        characterRec.x = PlayerInitialPositionX;
        characterRec.y = PlayerInitialPositionY;
        characterRec.width = PlayerHeight;
        characterRec.height = PlayerWidth;
    }

    public void detectInput() {
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            characterRec.x -= PlayerSpeed;
        } else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            characterRec.x += PlayerSpeed;
        } else if (Gdx.input.isKeyPressed(Keys.UP)) {
            characterRec.y += PlayerSpeed;
        } else if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            characterRec.y -= PlayerSpeed;
        }
    }
    public void draw(SpriteBatch batch) {
        batch.draw(character, characterRec.x, characterRec.y,
        characterRec.width, characterRec.height);
    }
    public void checkInMap() { 
        // check in x axis
        if (characterRec.x > ScreenWidth - PlayerWidth) {
            characterRec.x = ScreenWidth - PlayerWidth;
        } else if (characterRec.x < -ScreenWidth) {
            characterRec.x = -ScreenWidth;
        }
        // check in y axis
        if (characterRec.y > ScreenHeight - PlayerHeight) {
            characterRec.y = ScreenHeight - PlayerHeight;
        } else if (characterRec.y < -ScreenHeight) {
            characterRec.y = -ScreenHeight;
        }
    }
    public void setPlayerInitialPosition(int x, int y) {
        PlayerInitialPositionX = x;
        PlayerInitialPositionY = y;
    }
    //implement collision detection with map walls
    public float getX() {
        return characterRec.getX();
    }
    public float getY() {
        return characterRec.getY();
    }
}