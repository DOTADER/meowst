package com.meowstgdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.meowstgdx.game.MeowstGDX;
import com.meowstgdx.game.entities.mobs.Player;
import com.meowstgdx.game.entities.blocks.Planks;

public class MainGameScreen implements Screen {
    private MeowstGDX game;
    private Orthographic orthographic;
    private HUD hud;

    public static SpriteBatch spriteBatch;
    public static Player player = new Player(0,0);
    public static Planks planks = new Planks();

    public MainGameScreen(MeowstGDX game, Orthographic orthographic) {
        this.game = game;
        this.orthographic = orthographic;
        this.hud = new HUD();
    }

    @Override
    public void show() {
        spriteBatch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        // Move player
        player.move();

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

        // Render player
        player.getTextureSprite().draw(spriteBatch);

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
