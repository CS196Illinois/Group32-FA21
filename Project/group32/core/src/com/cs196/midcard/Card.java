package com.cs196.midcard;

public class Card {

    protected String id;

    protected boolean dead = false;
    protected int hp;
    protected int maxHp;
    // for animation to keep track of hp difference between attacks
    protected int previousHp;
    // for applying the hp change after the dialogue is finished
    protected int damage = 0;
    protected int healing = 0;
    // 0-100 in % points
    protected int accuracy;
    // damage range
    protected int minDamage;
    protected int maxDamage;

    // level up information
    protected int level;

    // move type used default -1
    protected int prevMoveUsed = -1;
    protected int moveUsed = -1;

    public Card(String id) {
        this.id = id;
    }

    public void update() {
        if (hp > maxHp) {
            hp = maxHp;
        }
        if (hp <= 0) {
            hp = 0;
        }
    }

    public void hit(int damage) {
        this.damage = damage;
    }

    public void applyDamage() {
        moveUsed = prevMoveUsed;
        prevMoveUsed = -1;
        damageHp();
    }

    private void damageHp() {
        previousHp = hp;
        hp -= damage;
        damage = 0;
        if (hp <= 0) {
            hp = 0;
            dead = true;
        }
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public String getId() {
        return id;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getPreviousHp() {
        return previousHp;
    }

    public void setPreviousHp(int previousHp) {
        this.previousHp = previousHp;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public int getMoveUsed() {
        return moveUsed;
    }

    public void useMove(int move) {
        this.prevMoveUsed = move;
    }

    public int getPrevMoveUsed() {
        return prevMoveUsed;
    }

    public void setMoveUsed(int moveUsed) {
        this.moveUsed = moveUsed;
    }

    public void setPrevMoveUsed(int prevMoveUsed) {
        this.prevMoveUsed = prevMoveUsed;
    }
}