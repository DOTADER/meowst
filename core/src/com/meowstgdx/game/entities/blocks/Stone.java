package com.meowstgdx.game.entities.blocks;

import com.meowstgdx.game.entities.Entity;

import static com.meowstgdx.game.screens.MainMenuScreen.atlas;

public class Stone extends Entity {
    protected Stone() {
        super(0, 0, 5, 5, atlas);
        this.setTextureSprite(atlas.createSprite("fog"));
        this.getTextureSprite().setBounds(0, 0, 100, 100);
    }
}
