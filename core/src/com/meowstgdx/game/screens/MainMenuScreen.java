package com.meowstgdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.meowstgdx.game.MeowstGDX;
import com.meowstgdx.game.Utils;
import com.meowstgdx.game.entities.buttons.StartButton;

import static com.meowstgdx.game.screens.MainGameScreen.spriteBatch;

public class MainMenuScreen implements Screen {

    public static StartButton startButton = new StartButton();

    MeowstGDX game;

    public MainMenuScreen (MeowstGDX game) {
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

        spriteBatch.begin();
        startButton.getTextureSprite().draw(spriteBatch);
        spriteBatch.end();
    }

    @Override
    public void resize(int i, int i1) {

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
