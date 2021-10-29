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
    public static final int ScreenWidth = 800;
    public static final int ScreenHeight = 480;
    //define the Constant for the player's speed
    public static final int PlayerSpeed = 10;
    //define the Constant for the player's size
    public static final int PlayerHeight = 36;
    public static final int PlayerWidth = 16;
    //define the Constant for the player's position
    public static final int PlayerInitialPositionX = -(ScreenWidth / 2);
    public static final int PlayerInitialPositionY = -(ScreenHeight / 2);

    private Texture character;
    private Rectangle characterRec = new Rectangle();
    
    public Player(Texture character) {
        this.character = character;
        characterRec.x = PlayerInitialPositionX;
        characterRec.y = PlayerInitialPositionY;
        characterRec.width = PlayerHeight * 10;
        characterRec.height = PlayerWidth * 10;
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
}