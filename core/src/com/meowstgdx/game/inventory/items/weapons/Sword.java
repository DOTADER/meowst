package com.meowstgdx.game.inventory.items.weapons;

import com.meowstgdx.game.materials.ToolMaterial;

import static com.meowstgdx.game.screens.MainGameScreen.player;

public class Sword extends Weapon {
    public Sword(ToolMaterial toolMaterial) {
        super("Sword", 32, 1, 128, toolMaterial);

        this.setTextureSprite(atlas.createSprite("SwordItem"));
        this.getTextureSprite().setBounds(player.getxPos(), player.getyPos(), 50, 50);

        switch (toolMaterial) {
            case WOOD: {
                this.damage *= 1;
                this.durability *= 1;
            }
            case FLINT: {
                this.damage *= 2;
                this.durability *= 2;
            }
            case STONE: {
                this.damage *= 3;
                this.durability *= 3;
            }
            case BRASS: {
                this.damage *= 4;
                this.durability *= 4;
            }
            case IRON: {
                this.damage *= 5;
                this.durability *= 5;
            }
            case TITANIUM: {
                this.damage *= 10;
                this.durability *= 10;
            }
        }
    }
}
