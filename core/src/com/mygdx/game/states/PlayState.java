package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.AutomaticPaddleController;
import com.mygdx.game.Ball;
import com.mygdx.game.ManualPaddle;
import com.mygdx.game.AutoPaddle;
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
    private ManualPaddle leftPaddle;
    private AutoPaddle rightPaddle;
    private Rectangle leftContRect;
    private Rectangle rightContRect;
    private InputProcessor pongInputHandler;
    private ManualPaddleController leftController;
    private AutomaticPaddleController rightController;
    private int leftScore;
    private int rightScore;
    private BitmapFont font;
    private Ball ball;
    private GameStateManager gsm;


    protected PlayState() {
        super();
        gsm = GameStateManager.getGsm();
        cam.setToOrtho(false);
        ball = new Ball(Gdx.graphics.getWidth() / 2,Gdx.graphics.getHeight() / 2);

        leftScore = 0;
        rightScore = 0;
        font = new BitmapFont();

        /* leftController = new ManualPaddleController(-1, this, cam);
        rightController = new AutomaticPaddleController(this, ball);*/

        leftContRect = new Rectangle(
                0, 0, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight());
        rightContRect = new Rectangle(
                Gdx.graphics.getWidth()/2, 0, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight());

        leftPaddle = new ManualPaddle(20, leftContRect, cam);
        rightPaddle = new AutoPaddle(Gdx.graphics.getWidth() - 20, rightContRect, cam);
        rightPaddle.setBall(ball);

        pongInputHandler = new PongInputHandler(leftContRect, rightContRect);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        ball.update(dt);
        leftPaddle.update(dt);
        rightPaddle.update(dt);
        if(ball.collides(leftPaddle.getBounds()) || ball.collides(rightPaddle.getBounds())){
            ball.bounce();
        }

        //Sjekk scoring
        if(ball.getBallPos().x < 0){
            rightScore += 1;
            System.out.print(leftScore + " - " + rightScore);
            ball.scored(1, Gdx.graphics.getWidth() / 2,Gdx.graphics.getHeight() / 2);
            if(rightScore > 5){
                EndState end = new EndState();
                end.setWinner("CPU");
                gsm.push(end);
            }
        } else if (ball.getBallPos().x > Gdx.graphics.getWidth()){
            leftScore += 1;
            ball.scored(-1, Gdx.graphics.getWidth() / 2,Gdx.graphics.getHeight() / 2);
            if(leftScore > 5){
                EndState end = new EndState();
                end.setWinner("You");
                gsm.push(end);
            }
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(leftPaddle.getPadTexture(), leftPaddle.getPosX(), leftPaddle.getPosY());
        sb.draw(rightPaddle.getPadTexture(), rightPaddle.getPosX(), rightPaddle.getPosY());
        sb.draw(ball.getTexture(), ball.getBallPos().x, ball.getBallPos().y);
        font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        font.draw(sb, "You: " + leftScore, 100, 400);
        font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        font.draw(sb, "CPU: " + rightScore, 450, 400);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
