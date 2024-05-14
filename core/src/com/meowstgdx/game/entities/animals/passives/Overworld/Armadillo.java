package com.meowstgdx.game.entities.animals.passives.Overworld;

import com.meowstgdx.game.entities.animals.Animal;

public class Armadillo extends Animal { // Has a shell, and damage is greater from the head.
    protected Armadillo(float moveSpeed, float attackSpeed, int health, int maxHealth, int stamina, int maxStamina, int damage, int protection) {
        super(moveSpeed, attackSpeed, health, maxHealth, stamina, maxStamina, damage, protection);
    }
}
