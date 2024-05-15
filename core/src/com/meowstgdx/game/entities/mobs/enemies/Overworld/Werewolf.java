package com.meowstgdx.game.entities.mobs.enemies.Overworld;

import com.meowstgdx.game.entities.mobs.enemies.Enemy;

public class Werewolf extends Enemy { // Basic nighttime enemy with average attack
    protected Werewolf(float moveSpeed, float attackSpeed, int health, int maxHealth, int stamina, int maxStamina, int damage, int protection) {
        super(moveSpeed, attackSpeed, health, maxHealth, stamina, maxStamina, damage, protection);
    }
}
