package com.mygdx.game;

import com.mygdx.game.states.PlayState;
import com.mygdx.game.states.State;
import com.mygdx.game.Ball;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ine on 26.01.2018.
 */

public class AutomaticPaddleController implements PaddleController {
    private float prevBallPos;
    private PlayState playState;
    float velocityY;
    Ball ball;

    public AutomaticPaddleController(PlayState playState, Ball ball) {
        this.playState = playState;
        this.ball = ball;
        velocityY = 150;
        float prevBallPos = ball.getBallPos().x;
    }

    @Override
    public float movePaddle(float oldY, float dt) {
        float newY;
        float ballPos = ball.getBallPos().y;

        float ballVel = (ballPos - prevBallPos)/dt;
        float estimBallY = ballVel*dt;

        if(estimBallY > oldY){
            newY = oldY + velocityY*dt;
        }
        else if(estimBallY < oldY){
            newY = oldY - velocityY*dt;
        }
        else{
            newY = oldY;
        }
        return newY;
    }
}
