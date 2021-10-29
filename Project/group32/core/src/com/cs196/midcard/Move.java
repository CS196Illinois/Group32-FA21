package com.cs196.midcard;

public class Move {

    public String name;
    /*
    Normal moves = 0
    Heal moves = 1
     */
    public int type;

    public float minDamage;
    public float maxDamage;

    //public float minHeal;
    //public float maxHeal;

    //public int crit;
    //public int dmgReduction;

    // Constructor for normal cards
    public Move(String name, int type, float min, float max) {
        this.name = name;
        this.type = type;
        this.minDamage = min;
        this.maxDamage = max;
    }

    // Constructor for heal moves
    /*
    public Move(int type, String name, float min, float max) {
        this.type = type;
        this.name = name;
        this.minHeal = min;
        this.maxHeal = max;
    }
    */

    // damageSeed is the "average" damage of a move calculated from its range
    public void setDamage(float damageSeed) {
        if (type == 1) {
            return;
        } else {
            minDamage = damageSeed - (minDamage * (damageSeed / 24));
            maxDamage = damageSeed + (maxDamage * (damageSeed / 24));
        }
    }

    /*
    public void setHeal(int hpSeed) {
        if (type != 1) {
            return;
        }
        minHeal = (hpSeed / 16) * minHeal;
        maxHeal = (hpSeed / 16) * maxHeal;
    }
     */
    private int type1; //name changed because of duplicate variable error above
    private String name1; //name changed because of duplicate variable error above
    private int damage;
    private String description;

    public Move(int type, String name, int damage, String description) {
        this.type = type;
        this.name = name;
        this.damage = damage;
        this.description = description;
    }

    public int getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public int getDamage() {
        return this.damage;
    }

    public String getDescription() {
        return this.description;
    }
}
