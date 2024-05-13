package com.meowstgdx.game.entities.animals.passives.Overworld;

import com.meowstgdx.game.entities.animals.Animal;

public class Elk extends Animal { // Runs away after getting hurt
    protected Elk(float moveSpeed, float attackSpeed, int health, int maxHealth, int stamina, int maxStamina, int damage, int protection) {
        super(moveSpeed, attackSpeed, health, maxHealth, stamina, maxStamina, damage, protection);
    }
}
