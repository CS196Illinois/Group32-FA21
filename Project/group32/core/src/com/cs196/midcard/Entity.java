package com.cs196.midcard;

public class Entity {

    private Move m1, m2, m3, m4, m5, m6, bm1, bm2, bm3, bm4, bm5, bm6;
    private Card c1, c2, c3, bc1, bc2, bc3;
    private int hp, type;

    public Entity(int hp, int type) {
        this.hp = hp;
        this.type = type;
        setEntity();
        setEnemy();
    }

    public void setEntity() {
        m1 = new Move(0, "Tackle", 20, "Run against the foe in its full speed.");
        m2 = new Move(1, "Flame Punch", 30, "Throws a strong punch with burning flames.");
        m3 = new Move(0, "Kick", 20, "Kicks the foe with its right foot.");
        m4 = new Move(2, "Hydro Bomb", 40, "Fires a bomb with a water balloon.");
        m5 = new Move(0, "Punch", 20, "Throws a strong punch in the face.");
        m6 = new Move(3, "Seed Bullet", 25, "Shoots a bullet of seeds.");

        //c1 = new Card("Flame Hedgehog", m1, m2);
        //c2 = new Card("Water Elf", m3, m4);
        //c3 = new Card("Mushroom Mon", m5, m6);
    }

    public void setEnemy() {
        bm1 = new Move(0, "Punch", 20, "Throws a strong punch in the face.");
        bm2 = new Move(1, "Flame Punch", 40, "Throws a strong punch with burning flames.");
        bm3 = new Move(0, "Kick", 20, "Kicks the foe with its right foot.");
        bm4 = new Move(1, "Flame Tail Whip", 30, "Whips its tail covered with burning flames.");
        bm5 = new Move(0, "Tackle", 20, "Run against the foe in its full speed.");
        bm6 = new Move(1, "Ember", 30, "Spits out small pieces of flames.");

        //bc1 = new Card("Salamander", bm1, bm2);
        //bc2 = new Card("Efreet", bm3, bm4);
        //bc3 = new Card("Flame Slimes", bm5, bm6);
    }

    public Move getM1() {
        return m1;
    }

    public Move getM2() {
        return m2;
    }

    public Move getM3() {
        return m3;
    }

    public Move getM4() {
        return m4;
    }

    public Move getM5() {
        return m5;
    }

    public Move getM6() {
        return m6;
    }

    public Move getBM1() {
        return bm1;
    }

    public Move getBM2() {
        return bm2;
    }

    public Move getBM3() {
        return bm3;
    }

    public Move getBM4() {
        return bm4;
    }

    public Move getBM5() {
        return bm5;
    }

    public Move getBM6() {
        return bm6;
    }

    public int getType() {
        return type;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int newHp) {
        hp = newHp;
    }
}
