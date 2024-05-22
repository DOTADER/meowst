package com.meowstgdx.game.inventory;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.meowstgdx.game.Utils;

public class Item {
    private final String name;
    protected final TextureAtlas atlas = new TextureAtlas(Utils.getInternalPath("textures/atlas/meowst-textures.atlas"));
    protected Sprite textureSprite;

    public Item(String name) {
        this.name = name;
        this.textureSprite = getTextureSprite();
    }

    public String getName() {
        return name;
    }

    public Sprite getTextureSprite() {
        return textureSprite;
    }

    public void setTextureSprite(Sprite textureSprite) {
        this.textureSprite = textureSprite;
    }
}
