package com.programm.games.spaceinvaders;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayerShip{
    private static final int PLAYER_SIZE = 64;
    private static final float speed = 3f;
    public float x, y;
    public boolean exists = true ;
    public boolean explode = false;
    public int timerPlayerShootCoolDown = 0;
    public int timerPlayerShipShape = 10;
    public int statePlayerShip = 1;
    public int getStatePlayerShipRandomShape = 30;
    public int baseLine = SpaceInvaderApp.HEIGHT -80;



    private List<PlayerBullet> bulletListe = new ArrayList<>();

    private static BufferedImage playerShip_Flame = null;

    static {
        try {
            playerShip_Flame = ImageIO.read(new File("/Users/gernot/Java/SpaceInvaders/src/main/resources/PlayerShip_Flame.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage playerShip_noFlame = null;

    static {
        try {
            playerShip_noFlame = ImageIO.read(new File("/Users/gernot/Java/SpaceInvaders/src/main/resources/PlayerShip_noFlame.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public PlayerShip (float x, float y) throws IOException {
        this.x=x;
        this.y=y;
    }

    public void draw(SimpleEngine.IPencil pencil) {

        if(exists = true) {

            // pencil.setColor(Color.GREEN);
            // pencil.fillRectangle(x, y, PLAYER_SIZE, PLAYER_SIZE);

            for(int i=0; i< bulletListe.size(); i++) {
                PlayerBullet b = bulletListe.get(i);
                b.draw(pencil);
            }


            if(statePlayerShip == 1 && timerPlayerShipShape != 0){
                pencil.drawImage(playerShip_Flame, x, baseLine, 64, 64);
                timerPlayerShipShape --;

                if (timerPlayerShipShape == 0){
                    statePlayerShip = 2;
                    Random zufall = new Random();
                    timerPlayerShipShape = zufall.nextInt(getStatePlayerShipRandomShape +10)+10;
                }

            }

            if(statePlayerShip == 2 && timerPlayerShipShape != 0){
                pencil.drawImage(playerShip_noFlame, x, baseLine, 64, 64);
                timerPlayerShipShape --;

                if (timerPlayerShipShape == 0){
                    statePlayerShip = 1;
                    Random zufall = new Random();
                    timerPlayerShipShape = zufall.nextInt(getStatePlayerShipRandomShape +10)+10;
                }

            }



        }




    }

    public void update(SimpleEngine.IKeyboard keyboard){

        if(keyboard.A()) {
            x -= speed;
            if (x <= 0 ){
                x =0;
            }
        }

        if(keyboard.D()) {
            x += speed;
            if (x >= SpaceInvaderApp.WIDTH-PLAYER_SIZE  ){
                x = SpaceInvaderApp.WIDTH-PLAYER_SIZE;
            }
        }

        if( timerPlayerShootCoolDown > 0){
            timerPlayerShootCoolDown --;
        }

        if(keyboard.SPACE() && timerPlayerShootCoolDown == 0) {
            bulletListe.add(new PlayerBullet(x+PLAYER_SIZE/2f, y));
            timerPlayerShootCoolDown = 60;
        }

        for(int i=0; i< bulletListe.size(); i++){
            PlayerBullet b = bulletListe.get(i);
            b.update();

            if(!b.exists){
                bulletListe.remove(i);
                i-- ;

            }

        }

    }
}

