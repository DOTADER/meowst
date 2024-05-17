package com.meowstgdx.game.entities.mobs;

import com.meowstgdx.game.entities.Entity;
import com.meowstgdx.game.inventory.Inventory;

public abstract class Mob extends Entity {
    protected int moveSpeed;
    protected int attackSpeed;
    protected int health;
    protected int maxHealth;
    protected float stamina;
    protected int maxStamina;
    protected int damage;
    protected int protection;
    protected boolean facingRight;
    protected boolean holdingItem;
    protected Inventory inventory;

    protected Mob(float moveSpeed, float attackSpeed, int health, int maxHealth, int stamina, int maxStamina, int damage, int protection) {
        super(0, 0, 5, 5);
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

    public float getStamina() {
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

    public boolean getFacingRight() {
        return facingRight;
    }

    public boolean getHoldingItem() {
        return holdingItem;
    }

    public Inventory getInventory() {
        return inventory;
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

    public void setStamina(float stamina) {
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

    public void setFacingRight(boolean facingRight) {
        this.facingRight = facingRight;
    }

    public void setHoldingItem(boolean holdingItem) {
        this.holdingItem = holdingItem;
    }
}
