package com.meowstgdx.game;

import com.badlogic.gdx.Game;
import com.meowstgdx.game.screens.MainGameScreen;
import com.meowstgdx.game.screens.MainMenuScreen;

public class MeowstGDX extends Game {

	public static int WIDTH = 1280;
	public static int HEIGHT = 720;

	@Override
	public void create () {
		this.setScreen(new MainGameScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {

	}

	@Override
	public void resize(int width, int height) {

	}
}
