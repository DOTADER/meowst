package com.meowstgdx.game.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.meowstgdx.game.Utils;

public abstract class Entity {

    protected final TextureAtlas atlas = new TextureAtlas(Utils.getInternalPath("textures/atlas/meowst-textures.atlas"));
    protected static Sprite textureSprite;
    protected float xPos, yPos;
    protected int width, height;

    protected Entity(float xPos, float yPos, float width, float height) {
        super();
    }


    // Getters
    public static Sprite getTextureSprite() {
        return textureSprite;
    }

    public float getxPos() {
        return xPos;
    }

    public float getyPos() {
        return yPos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    //Setters
    public void setTextureSprite(Sprite textureSprite) {
        this.textureSprite = textureSprite;
    }

    public void setxPos(float xPos) {
        this.xPos = xPos;
    }

    public void setyPos(float yPos) {
        this.yPos = yPos;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
