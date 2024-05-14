package com.meowstgdx.game.entities.animals.enemies.Cave;

import com.meowstgdx.game.entities.animals.enemies.Enemy;

public class Husher extends Enemy { // Impossible to see in complete darkness (because it is completely black), stalks prey and absorbs HP slowly. Runs away from light.
    protected Husher(float moveSpeed, float attackSpeed, int health, int maxHealth, int stamina, int maxStamina, int damage, int protection) {
        super(moveSpeed, attackSpeed, health, maxHealth, stamina, maxStamina, damage, protection);
    }
}
