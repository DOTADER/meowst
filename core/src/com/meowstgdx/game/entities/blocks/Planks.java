package com.meowstgdx.game.entities.blocks;

import com.meowstgdx.game.entities.Entity;

import static com.meowstgdx.game.screens.MainMenuScreen.atlas;

public class Planks extends Entity {
    public Planks() {
        super(0, 0, 5, 5, atlas);
        this.setTextureSprite(atlas.createSprite("planks"));
        this.getTextureSprite().setBounds(0, 0, 100, 100);
    }
}
