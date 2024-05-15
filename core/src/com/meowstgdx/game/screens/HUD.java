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
        healthBar.getStyle().background = createColorDrawable(Color.BLACK); // Background color
        healthBar.getStyle().knobBefore = createColorDrawable(Color.RED); // Knob (filled part) color
        healthBar.setValue(player.getHealth());
        // Set size and position...
        healthBar.setSize(400, 20); // Set width and height
        healthBar.setPosition(20, healthBar.getHeight() + 30); // Set x and y position on the stage

        // Create stamina bar
        staminaBar = new ProgressBar(0, player.getMaxStamina(), 1, false, new ProgressBar.ProgressBarStyle());
        staminaBar.getStyle().background = createColorDrawable(Color.BLACK); // Background color
        staminaBar.getStyle().knobBefore = createColorDrawable(Color.GREEN); // Knob (filled part) color
        staminaBar.setValue(player.getStamina());
        // Set size and position...
        staminaBar.setSize(400, 20); // Set width and height
        staminaBar.setPosition(20, staminaBar.getHeight() + 60); // Set x and y position on the stage

        // Create hotbar
        hotbar = new Table();
        hotbar.setBackground(createColorDrawable(Color.DARK_GRAY)); // Set hotbar background color
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

        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(stage.getCamera().combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.RED);

        // Draw outline around health bar
        float healthBarX = healthBar.getX();
        float healthBarY = healthBar.getY();
        float healthBarWidth = healthBar.getWidth();
        float healthBarHeight = healthBar.getHeight();
        Rectangle healthBarBounds = new Rectangle(healthBarX, healthBarY, healthBarWidth, healthBarHeight);
        shapeRenderer.rect(healthBarBounds.x, healthBarBounds.y, healthBarBounds.width, healthBarBounds.height);

        shapeRenderer.setColor(Color.GREEN);

        // Draw outline around stamina bar
        float staminaBarX = staminaBar.getX();
        float staminaBarY = staminaBar.getY();
        float staminaBarWidth = staminaBar.getWidth();
        float staminaBarHeight = staminaBar.getHeight();
        Rectangle staminaBarBounds = new Rectangle(staminaBarX, staminaBarY, staminaBarWidth, staminaBarHeight);
        shapeRenderer.rect(staminaBarBounds.x, staminaBarBounds.y, staminaBarBounds.width, staminaBarBounds.height);

        shapeRenderer.setColor(Color.WHITE);

        // Draw outline around hotbar
        float hotbarX = hotbar.getX();
        float hotbarY = hotbar.getY();
        float hotbarWidth = hotbar.getWidth();
        float hotbarHeight = hotbar.getHeight();
        Rectangle hotbarBounds = new Rectangle(hotbarX, hotbarY, hotbarWidth, hotbarHeight);
        shapeRenderer.rect(hotbarBounds.x, hotbarBounds.y, hotbarBounds.width, hotbarBounds.height);

        shapeRenderer.end();

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
