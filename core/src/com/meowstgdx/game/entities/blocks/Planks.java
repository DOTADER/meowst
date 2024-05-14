package com.meowstgdx.game.entities.blocks;

import com.meowstgdx.game.entities.Entity;

public class Planks extends Entity {
    public Planks() {
        super(0, 0, 5, 5);
        this.setTextureSprite(atlas.createSprite("planks"));
        this.getTextureSprite().setBounds(0, 0, 100, 100);
    }
}
