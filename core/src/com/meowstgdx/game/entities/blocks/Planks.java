package com.meowstgdx.game.entities.blocks;

import com.meowstgdx.game.entities.Entity;

public class Planks extends Entity {
    public Planks() {
        super(30, 30, 5, 5);

        this.setWidth(100);
        this.setHeight(100);
        this.setyPos(30);
        this.setxPos(30);

        this.setTextureSprite(atlas.createSprite("planks"));
        getTextureSprite().setBounds(30, 30, 100, 100);
    }
}
