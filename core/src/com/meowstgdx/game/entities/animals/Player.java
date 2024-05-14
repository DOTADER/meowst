package com.meowstgdx.game.entities.animals;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.meowstgdx.game.MeowstGDX;

public class Player extends Animal {
    private int caps;
    private int kills;

    private int x = MeowstGDX.WIDTH / 2 - this.width / 2;
    private int y = MeowstGDX.HEIGHT / 2 - this.height / 2;

    public Player(int caps, int kills) {
        super(200, 0.5f, 64, 64, 64, 64, 2, 0);
        this.caps = 0;
        this.kills = 0;
        this.setWidth(100);
        this.setHeight(100);
        this.setyPos(y);
        this.setxPos(x);

        this.setTextureSprite(atlas.createSprite("playerStillRight"));
        this.getTextureSprite().setBounds(x, y, this.width, this.height);

        if (kills >= 10) {
            setDamage(4);
        }
    }

    public void move() {
        this.setMoveSpeed(200);

        if (this.xPos <= -10) {
            this.xPos = -10;
        }
        if (this.yPos <= 1) {
            this.yPos = 1;
        }
        if (this.xPos >= MeowstGDX.WIDTH - 90) {
            this.xPos = MeowstGDX.WIDTH - 90;
        }
        if (this.yPos >= MeowstGDX.HEIGHT - 105) {
            this.yPos = MeowstGDX.HEIGHT - 105;
        }


        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            this.setTextureSprite(atlas.createSprite("playerStillRight"));
            this.xPos += (this.moveSpeed * Gdx.graphics.getDeltaTime());
            this.textureSprite.setBounds(this.xPos, this.yPos, this.width, this.height);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            this.setTextureSprite(atlas.createSprite("playerStillLeft"));
            this.xPos -= (this.moveSpeed * Gdx.graphics.getDeltaTime());
            this.textureSprite.setBounds(this.xPos, this.yPos, this.width, this.height);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            this.yPos += (this.moveSpeed * Gdx.graphics.getDeltaTime());
            this.textureSprite.setBounds(this.xPos, this.yPos, this.width, this.height);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            this.yPos -= (this.moveSpeed * Gdx.graphics.getDeltaTime());
            this.textureSprite.setBounds(this.xPos, this.yPos, this.width, this.height);
        }
    }


    // Getters
    public int getCaps() {
        return caps;
    }

    public int getKills() {
        return kills;
    }


    // Setters
    public void setKills(int kills) {
        this.kills = kills;
    }

    public void setCaps(int caps) {
        this.caps = caps;
    }
}