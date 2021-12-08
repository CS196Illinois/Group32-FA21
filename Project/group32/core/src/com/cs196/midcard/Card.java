package com.cs196.midcard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class Card {

    private Move m1, m2;
    private int basic, elemental;
    private String name;
    private int prevMoveUsed;
    private int moveUsed;
    private Texture card;
    private Rectangle cardRec = new Rectangle();
    private Entity player;
    private Entity boss;
    private Battle battle;

    public Card(String name, Texture card, int xPos, int yPos, int basic, int elemental) {
        this.name = name;
        //this.m1 = m1;
        //this.m2 = m2;
        this.basic = basic;
        this.elemental = elemental;
        this.card = card;
        cardRec.x = xPos;
        cardRec.y = yPos;
        cardRec.width = 136;
        cardRec.height = 240;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(card, cardRec.x, cardRec.y, cardRec.width, cardRec.height);
    }

    public String getName() {
        return name;
    }

    public int getBasic() {
        return basic;
    }

    public int getElemental() {
        return elemental;
    }

    public void setMoveUsed(int moveUsed) {
        this.moveUsed = moveUsed;
    }

    public void setPrevMoveUsed(int prevMoveUsed) {
        this.prevMoveUsed = prevMoveUsed;
    }


}
