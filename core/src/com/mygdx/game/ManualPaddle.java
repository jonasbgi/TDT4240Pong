package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by jonas on 02/02/2018.
 */

public class ManualPaddle extends Paddle {
    public ManualPaddle(int startX, Rectangle controlRect, Camera cam) {
        super(startX, controlRect, cam);
    }

    @Override
    public void update(float dt) {
        Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        cam.unproject(touchPos);
        this.posY = (int) touchPos.y;
        bounds.setPosition(posX, posY);
    }


}
