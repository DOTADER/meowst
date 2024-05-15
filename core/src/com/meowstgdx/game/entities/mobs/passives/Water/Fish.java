package com.meowstgdx.game.entities.mobs.passives.Water;

import com.meowstgdx.game.entities.mobs.Mob;

public class Fish extends Mob { // Swims away after getting hurt
    protected Fish(float moveSpeed, float attackSpeed, int health, int maxHealth, int stamina, int maxStamina, int damage, int protection) {
        super(moveSpeed, attackSpeed, health, maxHealth, stamina, maxStamina, damage, protection);
    }
}
