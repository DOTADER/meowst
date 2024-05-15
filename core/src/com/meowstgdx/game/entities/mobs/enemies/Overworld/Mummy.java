package com.meowstgdx.game.entities.mobs.enemies.Overworld;

import com.meowstgdx.game.entities.mobs.enemies.Enemy;

public class Mummy extends Enemy { // Throws balls of tissue to deal ranged damage
    protected Mummy(float moveSpeed, float attackSpeed, int health, int maxHealth, int stamina, int maxStamina, int damage, int protection) {
        super(moveSpeed, attackSpeed, health, maxHealth, stamina, maxStamina, damage, protection);
    }
}
