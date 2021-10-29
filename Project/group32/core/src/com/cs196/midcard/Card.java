package com.cs196.midcard;

public class Card {

    private Move m1, m2;
    private String name;
    private int prevMoveUsed;
    private int moveUsed;

    public Card(String name, Move m1, Move m2) {
        this.name = name;
        this.m1 = m1;
        this.m2 = m2;
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
