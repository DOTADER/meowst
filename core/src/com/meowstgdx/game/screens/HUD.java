package com.meowstgdx.game.screens;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.meowstgdx.game.MeowstGDX;

import static com.meowstgdx.game.screens.MainGameScreen.player;

public class HUD {
    private Stage stage;
    private ProgressBar healthBar;
    private ProgressBar staminaBar;
    private Table hotbar;

    public HUD() {
        stage = new Stage(new ScreenViewport());

        // Create health bar
        healthBar = new ProgressBar(0, player.getMaxHealth(), 1, false, new ProgressBar.ProgressBarStyle());
        healthBar.getStyle().background = createColorDrawable(Color.BLACK); // Background color
        healthBar.getStyle().knobBefore = createColorDrawable(Color.RED); // Knob (filled part) color
        healthBar.setValue(player.getHealth());
        // Set size and position...
        healthBar.setSize(200, 20); // Set width and height
        healthBar.setPosition(20, healthBar.getHeight() - 20); // Set x and y position on the stage

        // Create stamina bar
        staminaBar = new ProgressBar(0, player.getMaxStamina(), 1, false, new ProgressBar.ProgressBarStyle());
        staminaBar.getStyle().background = createColorDrawable(Color.BLACK); // Background color
        staminaBar.getStyle().knobBefore = createColorDrawable(Color.GREEN); // Knob (filled part) color
        staminaBar.setValue(player.getStamina());
        // Set size and position...
        staminaBar.setSize(200, 20); // Set width and height
        staminaBar.setPosition(20, staminaBar.getHeight() - 20); // Set x and y position on the stage

        // Create hotbar
        hotbar = new Table();
        hotbar.setBackground(createColorDrawable(Color.LIGHT_GRAY)); // Set hotbar background color
        // Add inventory items...

        stage.addActor(healthBar);
        stage.addActor(staminaBar);
        stage.addActor(hotbar);
    }

    public void render(float delta) {
        stage.act();
        stage.draw();
    }

    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    // Helper method to create a ColorDrawable with the specified color
    private Drawable createColorDrawable(Color color) {
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fill();
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        return new Image(texture).getDrawable();
    }
}
