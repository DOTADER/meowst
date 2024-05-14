package com.meowstgdx.game.entities.animals.enemies.Water;

import com.meowstgdx.game.entities.animals.enemies.Enemy;

public class Tentacood extends Enemy { // Looks like a jellyfish, but when close enough, it extends its tentacles toward the player to try and kill them
    protected Tentacood(float moveSpeed, float attackSpeed, int health, int maxHealth, int stamina, int maxStamina, int damage, int protection) {
        super(moveSpeed, attackSpeed, health, maxHealth, stamina, maxStamina, damage, protection);
    }
}
