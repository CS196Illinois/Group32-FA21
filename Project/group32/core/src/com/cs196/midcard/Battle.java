package com.cs196.midcard;

import java.util.Scanner;

public class Battle {

    private Entity entity;
    private Entity boss;

    public Battle() {
        entity = new Entity(400, 0);
        boss = new Entity(40, 1);
    }

    public Entity getEntity() {
        return entity;
    }

    public Entity getBoss() {
        return boss;
    }

    public int calculateDamage(Entity entity, Move m) {
        assert m.getType() >= 0 && m.getType() < 4 : "Wrong type number.";
        if (entity.getType() == 1) {
            if (m.getType() == 0) {
                return m.getDamage();
            } else if (m.getType() == 1 || m.getType() == 2) {
                return m.getDamage() / 2;
            } else {
                return m.getDamage() * 2;
            }
        } else {
            return m.getDamage();
        }
    }

    public void updateHp(Entity entity, Move m) {
        entity.setHp(boss.getHp() - calculateDamage(entity, m));
    }

    public boolean gameOver() {
        if (entity.getHp() <= 0) {
            System.out.println("Game Over");
            return false;
        } else if (boss.getHp() <= 0) {
            System.out.println("You won");
            return false;
        } else {
            return true;
        }
    }

    public void play() {
        Battle b = new Battle();
        Scanner sc = new Scanner(System.in);
        int moveInput = 0;
        Entity character = b.getEntity();
        Entity boss = b.getBoss();

        System.out.println("Game Start\n\n");

        while (b.gameOver()) {
            System.out.println("Your HP: " + character.getHp() + "\nYour Skills: " + character.getM1().getName() + " " +
                    character.getM2().getName() + " " + character.getM3().getName() + " " + character.getM4().getName() + " " +
                    character.getM5().getName() + " " + character.getM6().getName());
            System.out.println("Boss HP: " + boss.getHp());
            System.out.println("\nChoose Your Move.");
            moveInput = sc.nextInt();
            switch (moveInput) {
                case 1: b.updateHp(boss, character.getM1());
                    break;
                case 2: b.updateHp(boss, character.getM2());
                    break;
                case 3: b.updateHp(boss, character.getM3());
                    break;
                case 4: b.updateHp(boss, character.getM4());
                    break;
                case 5: b.updateHp(boss, character.getM5());
                    break;
                case 6: b.updateHp(boss, character.getM6());
                    break;
            }

        }
    }

}
