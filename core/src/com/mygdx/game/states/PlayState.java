package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.AutomaticPaddleController;
import com.mygdx.game.Ball;
import com.mygdx.game.ManualPaddleController;
import com.mygdx.game.Paddle;
import com.mygdx.game.PongInputHandler;

import org.w3c.dom.css.Rect;

/**
 * Created by jonas on 25/01/2018.
 */
/*TODO: Implement
* */

public class PlayState extends State {
    Paddle leftPaddle;
    Paddle rightPadde;
    Rectangle leftContRect;
    Rectangle rightContRect;
    InputProcessor pongInputHandler;
    ManualPaddleController leftController;
    AutomaticPaddleController rightController;
    Ball ball;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false);
        ball = new Ball(40,40);

        leftController = new ManualPaddleController(-1, this);
        rightController = new AutomaticPaddleController(this, ball);

        leftContRect = new Rectangle(
                0, 0, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight());
        rightContRect = new Rectangle(
                Gdx.graphics.getWidth()/2, 0, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight());
        leftPaddle = new Paddle(20, leftContRect, leftController);
        rightPadde = new Paddle(Gdx.graphics.getWidth() - 20, rightContRect, rightController);

        pongInputHandler = new PongInputHandler(leftContRect, rightContRect);

        System.out.println("Playstate initialized");
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        ball.update(dt);
        leftPaddle.update();
        rightPadde.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(leftPaddle.getPadTexture(), leftPaddle.getPosX(), leftPaddle.getPosY());
        sb.draw(rightPadde.getPadTexture(), rightPadde.getPosX(), rightPadde.getPosY());
        sb.draw(ball.getTexture(), ball.getBallPos().x, ball.getBallPos().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
