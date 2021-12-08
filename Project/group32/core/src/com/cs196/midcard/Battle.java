package com.cs196.midcard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

import java.util.Random;
import java.util.Scanner;

import static com.badlogic.gdx.Gdx.input;

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
            } else if (m.getType() == 1 || m.getType() == 3) {
                return m.getDamage() / 2;
            } else {
                return m.getDamage() * 2;
            }
        } else {
            return m.getDamage();
        }
    }

    public void updateHp(Entity entity, Move m) {
        entity.setHp(entity.getHp() - calculateDamage(entity, m));
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

    public void detectInput(int cardNumber) {
        if (input.isButtonPressed(Input.Buttons.LEFT) && input.getX() >= 1260 && input.getX() <= 1395 && input.getX() >= 942) {

        };
    }

    public void play() {
        Battle b = new Battle();
        Scanner sc = new Scanner(System.in);
        int moveInput = 0;
        Entity character = b.getEntity();
        Entity boss = b.getBoss();
        Random rand = new Random();
        int randomNum = rand.nextInt(6) + 1;
        System.out.println(randomNum);

        System.out.println("Game Start\n\n");

        while (b.gameOver()) {
            System.out.println("Your HP: " + character.getHp() + "\nYour Skills: " + character.getM1().getName() + ", " +
                    character.getM2().getName() + ", " + character.getM3().getName() + ", " + character.getM4().getName() + ", " +
                    character.getM5().getName() + ", " + character.getM6().getName());
            System.out.println("Boss HP: " + boss.getHp());
            System.out.println("\nChoose Your Move.");
            moveInput = sc.nextInt();
            switch (moveInput) {
                case 1: b.updateHp(boss, character.getM1());
                    System.out.println("You used " + character.getBM1().getName() + "!");
                    System.out.println("You dealt " + character.getBM1().getDamage() + " amount of damage!");
                    break;
                case 2: b.updateHp(boss, character.getM2());
                    System.out.println("You used " + character.getBM1().getName() + "!");
                    System.out.println("You dealt " + character.getBM1().getDamage() + " amount of damage!");
                    break;
                case 3: b.updateHp(boss, character.getM3());
                    System.out.println("You used " + character.getBM1().getName() + "!");
                    System.out.println("You dealt " + character.getBM1().getDamage() + " amount of damage!");
                    break;
                case 4: b.updateHp(boss, character.getM4());
                    System.out.println("You used " + character.getBM1().getName() + "!");
                    System.out.println("You dealt " + character.getBM1().getDamage() + " amount of damage!");
                    break;
                case 5: b.updateHp(boss, character.getM5());
                    System.out.println("You used " + character.getBM1().getName() + "!");
                    System.out.println("You dealt " + character.getBM1().getDamage() + " amount of damage!");
                    break;
                case 6: b.updateHp(boss, character.getM6());
                    System.out.println("You used " + character.getBM1().getName() + "!");
                    System.out.println("You dealt " + character.getBM1().getDamage() + " amount of damage!");
                    break;
            }

            System.out.println("\n");

            switch (randomNum) {
                case 1: b.updateHp(character, boss.getBM1());
                    System.out.println("The enemy used " + boss.getBM1().getName() + "!");
                    System.out.println("The enemy dealt " + boss.getBM1().getDamage() + " amount of damage!");
                    break;
                case 2: b.updateHp(character, boss.getBM2());
                    System.out.println("The enemy used " + boss.getBM1().getName() + "!");
                    System.out.println("The enemy dealt " + boss.getBM2().getDamage() + " amount of damage!");
                    break;
                case 3: b.updateHp(character, boss.getBM3());
                    System.out.println("The enemy used " + boss.getBM1().getName() + "!");
                    System.out.println("The enemy dealt " + boss.getBM3().getDamage() + " amount of damage!");
                    break;
                case 4: b.updateHp(character, boss.getBM4());
                    System.out.println("The enemy used " + boss.getBM1().getName() + "!");
                    System.out.println("The enemy dealt " + boss.getBM4().getDamage() + " amount of damage!");
                    break;
                case 5: b.updateHp(character, boss.getBM5());
                    System.out.println("The enemy used " + boss.getBM1().getName() + "!");
                    System.out.println("The enemy dealt " + boss.getBM5().getDamage() + " amount of damage!");
                    break;
                case 6: b.updateHp(character, boss.getBM6());
                    System.out.println("The enemy used " + boss.getBM1().getName() + "!");
                    System.out.println("The enemy dealt " + boss.getBM6().getDamage() + " amount of damage!");
                    break;
            }

            System.out.println("\n");

        }
    }

}