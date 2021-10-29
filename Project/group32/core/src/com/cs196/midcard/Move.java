package com.cs196.midcard;

public class Move {

    private int type;
    private String name;
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
