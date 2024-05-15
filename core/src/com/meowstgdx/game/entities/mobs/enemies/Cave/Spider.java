package com.meowstgdx.game.entities.mobs.enemies.Cave;

import com.meowstgdx.game.entities.mobs.enemies.Enemy;

public class Spider extends Enemy { // General enemy, nothing special
    protected Spider(float moveSpeed, float attackSpeed, int health, int maxHealth, int stamina, int maxStamina, int damage, int protection) {
        super(moveSpeed, attackSpeed, health, maxHealth, stamina, maxStamina, damage, protection);
    }
}
