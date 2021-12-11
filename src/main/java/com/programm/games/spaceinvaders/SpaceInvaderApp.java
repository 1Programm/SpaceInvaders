package com.programm.games.spaceinvaders;

import java.awt.*;

public class SpaceInvaderApp extends SimpleEngine {

    private static final String TITLE = "Space Invaders";
    private static final int WIDTH = 800;
    private static final int HEIGHT = WIDTH / 12 * 9;

    public static void main(String[] args) {
        SpaceInvaderApp app = new SpaceInvaderApp();
        app.start();
    }

    private float posX = 10;

    public SpaceInvaderApp() {
        super(TITLE, WIDTH, HEIGHT, 30);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void onShutdown() {

    }

    @Override
    protected void update() {
        posX += 1;
    }

    @Override
    protected void render(IPencil pencil) {
        pencil.setColor(Color.WHITE);
        pencil.fillScreen();

        pencil.setColor(Color.GREEN);
        pencil.drawRectangle(posX, 10, 60, 60);
    }
}
