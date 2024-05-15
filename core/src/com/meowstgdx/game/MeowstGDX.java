package com.meowstgdx.game;

import com.badlogic.gdx.Game;
import com.meowstgdx.game.screens.MainGameScreen;
import com.meowstgdx.game.screens.Orthographic;

public class MeowstGDX extends Game {

	private Orthographic orthographic;
	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;

	@Override
	public void create() {
		orthographic = new Orthographic(SCREEN_WIDTH, SCREEN_HEIGHT);
		this.setScreen(new MainGameScreen(this, orthographic));
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}
}
