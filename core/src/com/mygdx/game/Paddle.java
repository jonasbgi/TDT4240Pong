package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by jonas on 25/01/2018.
 */

public class Paddle {
    final int posX;
    int posY;
    Texture padTexture;
    Rectangle bounds;
    Rectangle controlSpace;
    PaddleController controller;

    public Paddle(int startX, Rectangle controlRect, PaddleController controller){
        posX = startX;
        controlSpace = controlRect;
        padTexture = new Texture("paddleImg.png");
        posY = (int)(Gdx.graphics.getHeight()/2 - padTexture.getHeight()/2);

        this.controller = controller;

        bounds = new Rectangle(posX, posY, padTexture.getWidth(), padTexture.getHeight());


    }

    public void update(){
        float newY = controller.movePaddle();
        this.posY = (int) newY;
        /*Something to set coords using controller.movePaddle()*/
    }



    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Texture getPadTexture(){
        return padTexture;
    }

}
