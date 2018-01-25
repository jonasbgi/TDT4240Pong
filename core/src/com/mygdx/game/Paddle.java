package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
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

    public Paddle(int startX, Rectangle controlRect){
        posX = startX;
        controlSpace = controlRect;
        padTexture = new Texture("paddleImg.png");
        posY = (int)(Gdx.graphics.getHeight()/2 - padTexture.getHeight()/2);

        bounds = new Rectangle(posX, posY, padTexture.getWidth(), padTexture.getHeight());
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
