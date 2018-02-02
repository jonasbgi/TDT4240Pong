package com.mygdx.game;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by jonas on 02/02/2018.
 */
public class AutoPaddle extends Paddle {

    float velocityY;
    float prevBallPos;
    Ball ball;

    public AutoPaddle(int startX, Rectangle controlRect, Camera cam) {
        super(startX, controlRect, cam);
        velocityY = 150;
        prevBallPos = 0;
    }

    @Override
    public void update(float dt) {
        float newY;
        try {
            float ballPos = ball.getBallPos().y;

            float ballVel = (ballPos - prevBallPos)/dt;
            float estimBallY = ballVel * dt;

            if (estimBallY > posY) {
                newY = posY + velocityY * dt;
            } else if (estimBallY < posY) {
                newY = posY - velocityY * dt;
            } else {
                newY = posY;
            }
            this.posY = newY;
        }
        catch (NullPointerException e){
            System.out.println("AutoPaddle: Ball not set!");
            newY = posY;
            this.posY = newY;
        }

        bounds.setPosition(posX, posY);
    }

    public void setBall(Ball ball){
        this.ball = ball;
    }

}
