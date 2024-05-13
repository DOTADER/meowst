package com.meowstgdx.game.entities.animals;

import com.meowstgdx.game.entities.Entity;

import static com.meowstgdx.game.screens.MainMenuScreen.atlas;

public abstract class Animal extends Entity {
    protected int moveSpeed;
    protected int attackSpeed;
    protected int health;
    protected int maxHealth;
    protected int stamina;
    protected int maxStamina;
    protected int damage;
    protected int protection;

    protected Animal(float moveSpeed, float attackSpeed, int health, int maxHealth, int stamina, int maxStamina, int damage, int protection) {
        super(0, 0, 5, 5, atlas);
    }

    public void hurt(int amount) {
        setHealth(getHealth() - amount);
    }


    // Getters
    public float getMoveSpeed() {
        return moveSpeed;
    }

    public float getAttackSpeed() {
        return attackSpeed;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getStamina() {
        return stamina;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    public int getDamage() {
        return damage;
    }

    public int getProtection() {
        return protection;
    }


    // Setters
    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public void setMaxStamina(int maxStamina) {
        this.maxStamina = maxStamina;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }
}
