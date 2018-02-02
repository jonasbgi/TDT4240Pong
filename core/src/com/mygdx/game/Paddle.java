package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by jonas on 25/01/2018.
 */

public abstract class Paddle {
    final int posX;
    float posY;
    Texture padTexture;
    Rectangle bounds;
    Rectangle controlSpace;
    Camera cam;

    public Paddle(int startX, Rectangle controlRect, Camera cam){
        posX = startX;
        controlSpace = controlRect;
        padTexture = new Texture("paddleImg.png");
        posY = (Gdx.graphics.getHeight()/2 - padTexture.getHeight()/2);

        bounds = new Rectangle(posX, posY, padTexture.getWidth(), padTexture.getHeight());

        this.cam = cam;
    }

    public abstract void update(float dt);


    public int getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public Texture getPadTexture(){
        return padTexture;
    }

    public Rectangle getBounds(){ return bounds; }

}
