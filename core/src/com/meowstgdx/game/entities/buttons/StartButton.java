package com.meowstgdx.game.entities.buttons;

import com.badlogic.gdx.Gdx;
import com.meowstgdx.game.MeowstGDX;
import com.meowstgdx.game.entities.Entity;

public class StartButton extends Entity {

    private int x = MeowstGDX.SCREEN_WIDTH / 2 - this.width / 2;
    private int y = MeowstGDX.SCREEN_HEIGHT / 2 - this.height / 2;

    public StartButton() {
        super((float) MeowstGDX.SCREEN_WIDTH / 2 - 100, (float) MeowstGDX.SCREEN_HEIGHT / 2 - 50, 160, 45);

        if (Gdx.input.getX() < x + this.width && Gdx.input.getX() > x && Gdx.input.getY() < y + this.height && Gdx.input.getY() > y) {
            this.setTextureSprite(atlas.createSprite("startHover"));
            this.getTextureSprite().setBounds(x, y, 160, 45);
        } else {
            this.setTextureSprite(atlas.createSprite("startIdle"));
            this.getTextureSprite().setBounds(x, y, 160, 45);
        }
    }
}
