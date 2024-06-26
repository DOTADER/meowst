package com.meowstgdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.meowstgdx.game.MeowstGDX;
import com.meowstgdx.game.entities.blocks.DoorCarpet;
import com.meowstgdx.game.entities.mobs.Player;
import com.meowstgdx.game.entities.blocks.Planks;
import com.meowstgdx.game.inventory.Inventory;
import com.meowstgdx.game.inventory.Item;
import com.meowstgdx.game.inventory.items.weapons.Sword;
import com.meowstgdx.game.materials.ToolMaterial;

public class MainGameScreen implements Screen {
    private MeowstGDX game;
    private Orthographic orthographic;
    private HUD hud;

    public static SpriteBatch spriteBatch;
    public static Player player = new Player(0,0);
    public static Inventory playerInventory = player.getInventory();
    public static Planks planks = new Planks();
    public static DoorCarpet doorCarpet = new DoorCarpet();
    public static Sword sword = new Sword(ToolMaterial.WOOD);

    public MainGameScreen(MeowstGDX game, Orthographic orthographic) {
        this.game = game;
        this.orthographic = orthographic;
        playerInventory = player.getInventory();
        this.hud = new HUD(playerInventory);
    }

    @Override
    public void show() {
        spriteBatch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        // Move player
        player.move();
        hud.updateHotbar();
        hud.updatePlayerStats();
        hud.handleInput();
        hud.updateHeldItem();

        // Handle zooming
        if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
            orthographic.zoomIn();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.X)) {
            orthographic.zoomOut();
        }

        // Update camera position to center on player
        float playerSpeed = player.getMoveSpeed(); // Get player speed
        float deltaTime = Gdx.graphics.getDeltaTime(); // Get delta time
        float cameraX = player.getxPos() + player.getWidth() / 2;
        float cameraY = player.getyPos() + player.getHeight() / 2;

        // Adjust camera position directly using player speed and delta time
        cameraX += playerSpeed * deltaTime;
        cameraY += playerSpeed * deltaTime;

        orthographic.getCamera().position.set(cameraX, cameraY, 0);

        // Clear screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Update camera and sprite batch
        orthographic.getCamera().update();
        spriteBatch.setProjectionMatrix(orthographic.getCamera().combined);

        // Begin rendering
        spriteBatch.begin();

        // Render planks grid
        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 8; y++) {
                planks.getTextureSprite().setPosition(x * planks.getWidth(), y * planks.getHeight());
                planks.getTextureSprite().draw(spriteBatch);
            }
        }

        doorCarpet.getTextureSprite().setPosition(16 * doorCarpet.getWidth(), 3 * doorCarpet.getHeight());
        doorCarpet.getTextureSprite().draw(spriteBatch);

        // Render player
        player.getTextureSprite().draw(spriteBatch);

        if (player.getHoldingItem()) {
            if (!player.getFacingRight()) {
                hud.getSelectedItem().getTextureSprite().setBounds(player.getxPos() + 8, player.getyPos() + 26, -50, 50);
            } else {
                hud.getSelectedItem().getTextureSprite().setPosition(player.getxPos() + 96, player.getyPos() + 26);
            }
            hud.getSelectedItem().getTextureSprite().setRotation(-45);
            hud.getSelectedItem().getTextureSprite().draw(spriteBatch);
        }

        // End rendering
        spriteBatch.end();

        // Render HUD after player
        hud.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        orthographic.updateViewport(width, height);
        hud.resize(width, height);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
    }
}
