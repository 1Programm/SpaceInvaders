package com.programm.games.spaceinvaders;

import java.awt.*;

public class PlayerBullet {
    public float x, y;
    public boolean exists = true ;


    public PlayerBullet (float x, float y){
        this.x=x;
        this.y=y;
    }

    public void draw(SimpleEngine.IPencil pencil) {

        if(exists = true) {
            pencil.setColor(Color.RED);
            pencil.fillRectangle(x, y, 3, 7);
        }

    }

    public void update(){
        y -= 1;
        if(y <= 0 ){
            exists = false;
        }
    }
}
