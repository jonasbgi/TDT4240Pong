package com.mygdx.game;

import com.mygdx.game.states.PlayState;
import com.mygdx.game.states.State;
import com.mygdx.game.Ball;

/**
 * Created by Ine on 26.01.2018.
 */

public class AutomaticPaddleController implements PaddleController {
    private PlayState playState;
    float velocityY;
    Ball ball;

    public AutomaticPaddleController(PlayState playState, Ball ball) {
        this.playState = playState;
        this.ball = ball;
        velocityY = 20;
    }

    @Override
    public float movePaddle(float oldY) {
        float newY;
        float ballPos = ball.getBallPos().y;
        if(ballPos > oldY){
            newY = oldY + velocityY;
        }
        else if(ballPos < oldY){
            newY = oldY - velocityY;
        }
        else{
            newY = oldY;
        }
        return newY;
    }
}
