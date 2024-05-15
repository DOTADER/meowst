package com.meowstgdx.game.screens;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.meowstgdx.game.MeowstGDX;

import java.lang.reflect.Member;

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
        healthBar.getStyle().background = createColorDrawable(Color.DARK_GRAY); // Background color
        healthBar.getStyle().background.setMinHeight(10);
        healthBar.getStyle().knobBefore = createColorDrawable(Color.RED); // Knob (filled part) color
        healthBar.getStyle().knobBefore.setMinHeight(20);
        healthBar.setValue(player.getHealth());
        // Set size and position...
        healthBar.setSize(400, 20); // Set width and height
        healthBar.setPosition(20, healthBar.getHeight() + 60); // Set x and y position on the stage

        // Create stamina bar
        staminaBar = new ProgressBar(0, player.getMaxStamina(), 1, false, new ProgressBar.ProgressBarStyle());
        staminaBar.getStyle().background = createColorDrawable(Color.DARK_GRAY); // Background color
        staminaBar.getStyle().background.setMinHeight(10);
        staminaBar.getStyle().knobBefore = createColorDrawable(Color.GREEN); // Knob (filled part) color
        staminaBar.getStyle().knobBefore.setMinHeight(20);
        staminaBar.setValue(player.getStamina());
        // Set size and position...
        staminaBar.setSize(400, 20); // Set width and height
        staminaBar.setPosition(20, staminaBar.getHeight() + 30); // Set x and y position on the stage

        // Create hotbar
        hotbar = new Table();
        hotbar.setBackground(createColorDrawable(Color.LIGHT_GRAY)); // Set hotbar background color
        hotbar.setSize(400, 20); // Set width and height
        hotbar.setPosition(20, staminaBar.getHeight()); // Set x and y position on the stage
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

    public void updatePlayerStats() {
        updateHealthBar();
        updateStaminaBar();
    }

    private void updateStaminaBar() {
        staminaBar.setValue(player.getStamina());
    }

    private void updateHealthBar() {
        healthBar.setValue(player.getHealth());
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
