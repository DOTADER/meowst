package com.meowstgdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.meowstgdx.game.MeowstGDX;
import com.meowstgdx.game.Utils;
import com.meowstgdx.game.entities.animals.Player;
import com.meowstgdx.game.entities.blocks.Fog;
import com.meowstgdx.game.entities.blocks.Planks;

public class MainGameScreen implements Screen {

    public static SpriteBatch spriteBatch;
    public final TextureAtlas atlas = new TextureAtlas(Utils.getInternalPath("textures/atlas/meowst-textures.atlas"));
    public static Player player = new Player(0,0);

    MeowstGDX game;

    public MainGameScreen (MeowstGDX game) {
        this.game = game;
    }

    @Override
    public void show() {
        spriteBatch = new SpriteBatch();
    }

    @Override
    public void render(float v) {

        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 0.5f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        player.move();

        spriteBatch.begin();
        player.getTextureSprite().draw(spriteBatch);
        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
        spriteBatch.getProjectionMatrix().setToOrtho2D(0, 0, width, height);
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
        atlas.dispose();
    }
}
