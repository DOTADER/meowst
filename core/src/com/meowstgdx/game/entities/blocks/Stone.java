package com.meowstgdx.game.entities.blocks;

import com.meowstgdx.game.entities.Entity;

public class Stone extends Entity {
    protected Stone() {
        super(0, 0, 5, 5);
        this.setTextureSprite(atlas.createSprite("stone"));
        getTextureSprite().setBounds(0, 0, 100, 100);
    }
}
