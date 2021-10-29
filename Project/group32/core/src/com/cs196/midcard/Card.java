package com.cs196.midcard;

public class Card {

    private Move m1, m2;

    public Card(Move m1, Move m2) {
        this.m1 = m1;
        this.m2 = m2;
    }

    public Move getMove1() {
        return m1;
    }

    public Move getMove2() {
        return m2;
    }

}