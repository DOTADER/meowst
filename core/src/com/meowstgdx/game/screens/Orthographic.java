package com.meowstgdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Orthographic {
    private OrthographicCamera camera;
    private Viewport viewport;
    private float zoom = 1.0f;
    private int screenWidth;
    private int screenHeight;
    private float minZoom = 0.5f; // Example minimum zoom level
    private float maxZoom = 2.0f; // Example maximum zoom level

    public Orthographic(int screenWidth, int screenHeight) {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, screenWidth, screenHeight);
    }

    public void updateViewport(int screenWidth, int screenHeight) {
        camera.viewportWidth = screenWidth * zoom;
        camera.viewportHeight = screenHeight * zoom;
        camera.update();
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void zoomIn() {
        zoom -= 0.05f;
        if (zoom < minZoom) {
            zoom = minZoom;
        }
        updateCameraViewport();
    }

    public void zoomOut() {
        zoom += 0.05f;
        if (zoom > maxZoom) {
            zoom = maxZoom;
        }
        updateCameraViewport();
    }

    private void updateCameraViewport() {
        int screenWidth = Gdx.graphics.getWidth();
        int screenHeight = Gdx.graphics.getHeight();

        camera.viewportWidth = screenWidth * zoom;
        camera.viewportHeight = screenHeight * zoom;
        camera.update();
    }

}
