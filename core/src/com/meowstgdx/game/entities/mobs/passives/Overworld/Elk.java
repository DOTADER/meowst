package com.meowstgdx.game.entities.mobs.passives.Overworld;

import com.meowstgdx.game.entities.mobs.Mob;

public class Elk extends Mob { // Runs away after getting hurt
    protected Elk(float moveSpeed, float attackSpeed, int health, int maxHealth, int stamina, int maxStamina, int damage, int protection) {
        super(moveSpeed, attackSpeed, health, maxHealth, stamina, maxStamina, damage, protection);
    }
}
