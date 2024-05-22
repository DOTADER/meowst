package com.meowstgdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.meowstgdx.game.inventory.Inventory;
import com.meowstgdx.game.inventory.Item;

import static com.meowstgdx.game.screens.MainGameScreen.player;

public class HUD extends InputAdapter {
    private Stage stage;
    private ProgressBar healthBar;
    private ProgressBar staminaBar;
    private Table hotbar;
    private Inventory inventory;
    private static final int HOTBAR_SLOTS = 9;
    private int selectedSlot = 0;

    public HUD(Inventory inventory) {
        this.inventory = inventory;
        stage = new Stage(new ScreenViewport());

        // Create health bar
        healthBar = new ProgressBar(0, player.getMaxHealth(), 1, false, new ProgressBar.ProgressBarStyle());
        healthBar.getStyle().background = createColorDrawable(Color.DARK_GRAY); // Background color
        healthBar.getStyle().background.setMinHeight(10);
        healthBar.getStyle().knobBefore = createColorDrawable(Color.RED); // Knob (filled part) color
        healthBar.getStyle().knobBefore.setMinHeight(20);
        healthBar.setValue(player.getHealth());
        // Set size and position...
        healthBar.setSize(362, 20); // Set width and height
        healthBar.setPosition(20, healthBar.getHeight() + 80); // Set x and y position on the stage

        // Create stamina bar
        staminaBar = new ProgressBar(0, player.getMaxStamina(), 1, false, new ProgressBar.ProgressBarStyle());
        staminaBar.getStyle().background = createColorDrawable(Color.DARK_GRAY); // Background color
        staminaBar.getStyle().background.setMinHeight(10);
        staminaBar.getStyle().knobBefore = createColorDrawable(Color.GREEN); // Knob (filled part) color
        staminaBar.getStyle().knobBefore.setMinHeight(20);
        staminaBar.setValue(player.getStamina());
        // Set size and position...
        staminaBar.setSize(362, 20); // Set width and height
        staminaBar.setPosition(20, staminaBar.getHeight() + 50); // Set x and y position on the stage

        // Create hotbar
        hotbar = new Table();
        hotbar.setBackground(createColorDrawable(Color.LIGHT_GRAY)); // Set hotbar background color
        hotbar.setSize(362, 40);
        hotbar.setPosition(20, 20);
        hotbar.defaults().pad(5).size(60, 60); // Set default size and padding for slots
        stage.addActor(hotbar);

        stage.addActor(healthBar);
        stage.addActor(staminaBar);

        for (int i = 0; i < HOTBAR_SLOTS; i++) {
            hotbar.add().size(30, 30).pad(5);
        }

        Gdx.input.setInputProcessor(this);
    }

    public void updateHotbar() {
        hotbar.clearChildren();

        // Recreate empty slots
        for (int i = 0; i < HOTBAR_SLOTS; i++) {
            Image slotImage = new Image(createColorDrawable(Color.DARK_GRAY));
            if (i == selectedSlot) {
                slotImage.setColor(Color.DARK_GRAY); // Highlight selected slot
            }
            hotbar.add(slotImage).size(30, 30).pad(5);
        }

        // Place items in the first available slots
        int slotIndex = 0;
        for (Item item : inventory.getItems()) {
            if (slotIndex >= HOTBAR_SLOTS) break;

            TextureRegionDrawable drawable = new TextureRegionDrawable(new TextureRegion(item.getTextureSprite()));
            Image itemImage = new Image(drawable);
            if (slotIndex == selectedSlot) {
                itemImage.setColor(Color.GOLD); // Highlight selected slot with item
            }
            hotbar.getCells().get(slotIndex).setActor(itemImage);
            slotIndex++;
        }
    }

    public void handleInput() {
        // Handle number keys
        for (int i = 0; i < HOTBAR_SLOTS; i++) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1 + i)) {
                selectedSlot = i;
                updateHotbar();
                return;
            }
        }
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        if (amountY > 0) {
            selectedSlot = (selectedSlot + 1) % HOTBAR_SLOTS;
        } else if (amountY < 0) {
            selectedSlot = (selectedSlot - 1 + HOTBAR_SLOTS) % HOTBAR_SLOTS;
        }
        updateHotbar();
        return true;
    }

    public void updateHeldItem() {
        Item selectedItem = this.getSelectedItem();
        if (selectedItem != null) {
            player.setHoldingItem(true);
        } else {
            player.setHoldingItem(false);
        }
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

    public Item getSelectedItem() {
        return inventory.getItems().size() > selectedSlot ? inventory.getItems().get(selectedSlot) : null;
    }
}
