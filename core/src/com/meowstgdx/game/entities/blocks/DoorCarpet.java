package com.meowstgdx.game.entities.blocks;

import com.meowstgdx.game.entities.Entity;

public class DoorCarpet extends Entity {
    public DoorCarpet() {
        super(0, 0, 5, 5);

        this.setWidth(100);
        this.setHeight(100);
        this.setyPos(30);
        this.setxPos(30);

        this.setTextureSprite(atlas.createSprite("doorCarpet"));
        getTextureSprite().setBounds(0, 0, this.width, this.height);
    }
}
