package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.AutomaticPaddleController;
import com.mygdx.game.Ball;
import com.mygdx.game.ManualPaddleController;
import com.mygdx.game.Paddle;
import com.mygdx.game.Pong;
import com.mygdx.game.PongInputHandler;

import org.w3c.dom.css.Rect;

/**
 * Created by jonas on 25/01/2018.
 */
/*TODO: Implement
* */

public class PlayState extends State {
    private Paddle leftPaddle;
    private Paddle rightPaddle;
    private Rectangle leftContRect;
    private Rectangle rightContRect;
    private InputProcessor pongInputHandler;
    private ManualPaddleController leftController;
    private AutomaticPaddleController rightController;
    private Ball ball;
    private int leftScore;
    private int rightScore;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false);
        ball = new Ball(Gdx.graphics.getWidth() / 2,Gdx.graphics.getHeight() / 2);

        leftScore = 0;
        rightScore = 0;

        leftController = new ManualPaddleController(-1, this);
        rightController = new AutomaticPaddleController(this, ball);

        leftContRect = new Rectangle(
                0, 0, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight());
        rightContRect = new Rectangle(
                Gdx.graphics.getWidth()/2, 0, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight());
        leftPaddle = new Paddle(20, leftContRect, leftController);
        rightPaddle = new Paddle(Gdx.graphics.getWidth() - 20, rightContRect, rightController);

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
        rightPaddle.update();
        if(ball.collides(leftPaddle.getBounds()) || ball.collides(rightPaddle.getBounds())){
            ball.bounce();
        }

        //Bare for testing:
        if(ball.getBallPos().x < 0){
            leftScore += 1;
            System.out.print(leftScore + " - " + rightScore);
            gsm.push(new PlayState(gsm));
        } else if (ball.getBallPos().x > Gdx.graphics.getWidth()){
            rightScore += 1;
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(leftPaddle.getPadTexture(), leftPaddle.getPosX(), leftPaddle.getPosY());
        sb.draw(rightPaddle.getPadTexture(), rightPaddle.getPosX(), rightPaddle.getPosY());
        sb.draw(ball.getTexture(), ball.getBallPos().x, ball.getBallPos().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
