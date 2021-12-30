package com.programm.games.spaceinvaders;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpaceInvaderApp extends SimpleEngine {

    private static final String TITLE = "Space Invaders";
    public static final int WIDTH = 800;
    public static final int HEIGHT = WIDTH / 12 * 9;

    public static void main(String[] args) {
        SpaceInvaderApp app = new SpaceInvaderApp();
        app.start();
    }

    // private float posX = WIDTH/2;
    private float speed = 1;
    // private PlayerBullet testBullet = new PlayerBullet(100,100);
    // private List<PlayerBullet> bulletListe = new ArrayList<>();
    private int timer = 0;

    static PlayerShip ship;

    static {
        try {
            ship = new PlayerShip(WIDTH / 2, HEIGHT - 64);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

        if(!ship.exists){
            System.out.println("Spiel zu ende");
            System.exit(0);
        }

        ship.update(keyboard);

    }

    @Override
    protected void render(IPencil pencil) {
        pencil.setColor(Color.BLACK);
        pencil.fillScreen();

        ship.draw(pencil);

    }
}
