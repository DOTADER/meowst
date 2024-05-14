package com.meowstgdx.game.entities.animals.enemies;

import com.meowstgdx.game.entities.animals.Animal;

public abstract class Enemy extends Animal {
    protected Enemy(float moveSpeed, float attackSpeed, int health, int maxHealth, int stamina, int maxStamina, int damage, int protection) {
        super(moveSpeed, attackSpeed, health, maxHealth, stamina, maxStamina, damage, protection);
    }
}
