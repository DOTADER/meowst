package com.meowstgdx.game.inventory.items.weapons;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.meowstgdx.game.Utils;
import com.meowstgdx.game.inventory.Item;
import com.meowstgdx.game.materials.ToolMaterial;

public abstract class Weapon extends Item {
    
    protected float damage;
    protected float attackSpeed;
    protected int durability;
    protected ToolMaterial toolMaterial;

    protected Weapon(String name, float damage, float attackSpeed, int durability, ToolMaterial toolMaterial) {
        super(name);
    }


    // Getters
    public float getDamage() {
        return damage;
    }

    public float getAttackSpeed() {
        return attackSpeed;
    }

    public int getDurability() {
        return durability;
    }

    public ToolMaterial getToolMaterial() {
        return toolMaterial;
    }

    // Setters
    public void setDamage(float damage) {
        this.damage = damage;
    }

    public void setAttackSpeed(float attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public void setToolMaterial(ToolMaterial toolMaterial) {
        this.toolMaterial = toolMaterial;
    }
}
