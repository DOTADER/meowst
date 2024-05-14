package com.meowstgdx.game.entities.animals.passives.Water;

import com.meowstgdx.game.entities.animals.Animal;

public class Fish extends Animal { // Swims away after getting hurt
    protected Fish(float moveSpeed, float attackSpeed, int health, int maxHealth, int stamina, int maxStamina, int damage, int protection) {
        super(moveSpeed, attackSpeed, health, maxHealth, stamina, maxStamina, damage, protection);
    }
}
