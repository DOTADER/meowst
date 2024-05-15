package com.meowstgdx.game.entities.mobs.enemies;

import com.meowstgdx.game.entities.mobs.Mob;

public abstract class Enemy extends Mob {
    protected Enemy(float moveSpeed, float attackSpeed, int health, int maxHealth, int stamina, int maxStamina, int damage, int protection) {
        super(moveSpeed, attackSpeed, health, maxHealth, stamina, maxStamina, damage, protection);
    }
}
