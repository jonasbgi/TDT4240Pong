package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
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

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false);
        leftContRect = new Rectangle(
                0, 0, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight());
        rightContRect = new Rectangle(
                Gdx.graphics.getWidth()/2, 0, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight());
        leftPaddle = new Paddle(20, leftContRect);
        rightPadde = new Paddle(Gdx.graphics.getWidth() - 20, rightContRect);

        pongInputHandler = new PongInputHandler(leftContRect, rightContRect);

        System.out.println("Playstate initialized");
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(leftPaddle.getPadTexture(), leftPaddle.getPosX(), leftPaddle.getPosY());
        sb.draw(rightPadde.getPadTexture(), rightPadde.getPosX(), rightPadde.getPosY());
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
