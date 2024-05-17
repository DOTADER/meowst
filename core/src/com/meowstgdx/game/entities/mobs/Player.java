package com.meowstgdx.game.entities.mobs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.meowstgdx.game.MeowstGDX;
import com.meowstgdx.game.inventory.Inventory;
import com.meowstgdx.game.inventory.Item;
import com.meowstgdx.game.inventory.items.weapons.Sword;
import com.meowstgdx.game.materials.ToolMaterial;
import com.meowstgdx.game.screens.HUD;

import static com.meowstgdx.game.screens.MainGameScreen.player;

public class Player extends Mob {

    private int caps;
    private int kills;

    private int x = MeowstGDX.SCREEN_WIDTH / 2 - this.width / 2;
    private int y = MeowstGDX.SCREEN_HEIGHT / 2 - this.height / 2;

    public Player(int caps, int kills) {
        super(300, 0.25f, 64, 64, 64, 64, 2, 0);
        this.caps = 0;
        this.kills = 0;
        this.inventory = new Inventory(9);
        this.setWidth(100);
        this.setHeight(100);
        this.setyPos(y);
        this.setxPos(x);
        this.health = 64;
        this.maxHealth = 64;
        this.stamina = 64;
        this.maxStamina = 64;

        this.setTextureSprite(atlas.createSprite("playerStillRight"));
        this.getTextureSprite().setBounds(this.xPos, this.yPos, this.width, this.height);

        if (kills >= 10) {
            setDamage(4);
        }
    }

    public void move() {

        if (this.facingRight) {
            if (this.holdingItem) {
                this.setTextureSprite(atlas.createSprite("playerHoldingRight"));
                this.getTextureSprite().setBounds(this.xPos, this.yPos, this.width, this.height);
            } else {
                this.setTextureSprite(atlas.createSprite("playerStillRight"));
                this.getTextureSprite().setBounds(this.xPos, this.yPos, this.width, this.height);
            }
        } else {
            if (this.holdingItem) {
                this.setTextureSprite(atlas.createSprite("playerHoldingLeft"));
                this.getTextureSprite().setBounds(this.xPos, this.yPos, this.width, this.height);
            } else {
                this.setTextureSprite(atlas.createSprite("playerStillLeft"));
                this.getTextureSprite().setBounds(this.xPos, this.yPos, this.width, this.height);
            }
        }

        this.moveSpeed = 300;
        // Double movement speed if SHIFT_LEFT is pressed
        if (this.stamina <= 0) {

        } else if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
            this.moveSpeed *= 2;
            this.stamina -= 0.25;
        }

        if (!Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
            if (this.stamina < this.maxStamina) {
                this.stamina += 0.125;
            } else {
                this.stamina = this.maxStamina;
            }
        }

        // Move in each direction separately
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            moveRight(this.moveSpeed);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            moveLeft(this.moveSpeed);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            moveUp(this.moveSpeed);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            moveDown(this.moveSpeed);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.T)) {
            this.inventory.addItem(new Sword(ToolMaterial.WOOD));
        }
    }

    private void moveRight(float speed) {
        this.setFacingRight(true);
        this.xPos += (speed * Gdx.graphics.getDeltaTime());
        this.textureSprite.setBounds(this.xPos, this.yPos, this.width, this.height);
    }

    private void moveLeft(float speed) {
        this.setFacingRight(false);
        this.xPos -= (speed * Gdx.graphics.getDeltaTime());
        this.textureSprite.setBounds(this.xPos, this.yPos, this.width, this.height);
    }

    private void moveUp(float speed) {
        this.yPos += (speed * Gdx.graphics.getDeltaTime());
        this.textureSprite.setBounds(this.xPos, this.yPos, this.width, this.height);
    }

    private void moveDown(float speed) {
        this.yPos -= (speed * Gdx.graphics.getDeltaTime());
        this.textureSprite.setBounds(this.xPos, this.yPos, this.width, this.height);
    }

    public void addItemToInventory(Item item) {
        inventory.addItem(item);
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