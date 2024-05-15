package com.meowstgdx.game.entities.blocks;

import com.meowstgdx.game.entities.Entity;

public class Fog extends Entity {
    public Fog() {
        super(0, 0, 5, 5);

        this.setTextureSprite(atlas.createSprite("fog"));
        getTextureSprite().setBounds(0, 0, this.width, this.height);
    }
}
