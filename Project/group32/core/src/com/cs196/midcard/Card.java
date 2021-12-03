package com.cs196.midcard;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.w3c.dom.Text;

import java.awt.*;

public class Card {

    private Move m1, m2;
    private String name;
    private int prevMoveUsed;
    private int moveUsed;
    private Texture card;
    private Rectangle cardRec = new Rectangle();

    public Card(String name, Texture card, int xPos, int yPos) {
        this.name = name;
        //this.m1 = m1;
        //this.m2 = m2;
        this.card = card;
        cardRec.x = xPos;
        cardRec.y = yPos;
        cardRec.width = 68;
        cardRec.height = 120;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(card, cardRec.x, cardRec.y, cardRec.width, cardRec.height);
    }

    public String getName() {
        return name;
    }

    public Move getMove1() {
        return m1;
    }

    public Move getMove2() {
        return m2;
    }

    public void setMoveUsed(int moveUsed) {
        this.moveUsed = moveUsed;
    }

    public void setPrevMoveUsed(int prevMoveUsed) {
        this.prevMoveUsed = prevMoveUsed;
    }
}
