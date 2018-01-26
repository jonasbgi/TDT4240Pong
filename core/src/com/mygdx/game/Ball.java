package com.mygdx.game;


import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by lena- on 26.01.2018.
 */

public class Ball {
    private static final int MOVEMENT = 100;

    private Vector3 ballPos;
    private Vector3 ballVel;
    private Rectangle bounds;
    private Texture texture;
    private Texture ball;

    public Ball(int x, int y) {
        ballPos = new Vector3(x, y,0);
        ballVel = new Vector3(0,0,0);
        texture = new Texture("ball.png");
        bounds = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
    }

    public void update(float dt) {
        if (ballPos.y > 0)
            ballVel.add(0,-15,0);
        ballVel.scl(dt);
        ballPos.add(MOVEMENT*dt, ballVel.y, 0);
        if(ballPos.y < 0)
            ballPos.y = 0;

        ballVel.scl(1/dt);
        bounds.setPosition(ballPos.x, ballPos.y);
    }

    public Vector3 getBallPos() {
        return ballPos;
    }

    public Rectangle getBounds() {
        return bounds;
    }
    public void dispose() {
        texture.dispose();
    }



}
