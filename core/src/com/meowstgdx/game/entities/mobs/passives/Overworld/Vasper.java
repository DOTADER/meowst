package com.meowstgdx.game.entities.mobs.passives.Overworld;

import com.meowstgdx.game.entities.mobs.Mob;

public class Vasper extends Mob { // Does not fight back, but produces a cloud of poison
    protected Vasper(float moveSpeed, float attackSpeed, int health, int maxHealth, int stamina, int maxStamina, int damage, int protection) {
        super(moveSpeed, attackSpeed, health, maxHealth, stamina, maxStamina, damage, protection);
    }
}
