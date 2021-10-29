package com.cs196.midcard;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Enemy extends ApplicationAdapter {
    private Texture enemyOne;
    public void create() {
        enemyOne = new Texture(Gdx.files.internal("Ogre.gif"));

    }

}
