package com.meowstgdx.game.entities.animals.enemies.Water;

import com.meowstgdx.game.entities.animals.enemies.Enemy;

public class SaberEel extends Enemy { // Extremely aggressive towards all animals, including the player. Bites everything it can get to.
    protected SaberEel(float moveSpeed, float attackSpeed, int health, int maxHealth, int stamina, int maxStamina, int damage, int protection) {
        super(moveSpeed, attackSpeed, health, maxHealth, stamina, maxStamina, damage, protection);
    }
}
