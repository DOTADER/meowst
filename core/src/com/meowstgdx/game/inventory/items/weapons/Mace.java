package com.meowstgdx.game.inventory.items.weapons;

import com.meowstgdx.game.materials.ToolMaterial;

public class Mace extends Weapon {
    public Mace(ToolMaterial toolMaterial) {
        super("Mace", 128, 2, 256, toolMaterial);

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
