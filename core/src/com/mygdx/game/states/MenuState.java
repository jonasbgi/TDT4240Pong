package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by jonas on 25/01/2018.
 * TODO: Make sprites scale to screen (menubutton is very small)
 */

public class MenuState extends State {
    Texture playBtn;
    int playBtnX;
    int playBtnY;
    Rectangle playBtnRect;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false);
        playBtn = new Texture("btnPlay.png");

        System.out.println("Starting");

        playBtnX = Gdx.graphics.getWidth()/2 - playBtn.getWidth()/2;
        playBtnY = Gdx.graphics.getHeight()/2 - playBtn.getHeight()/2;

        playBtnRect = new Rectangle(playBtnX, playBtnY, playBtn.getWidth(), playBtn.getHeight());
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()) {
            float inputX = Gdx.input.getX();
            float inputY = Gdx.input.getY();

            Vector3 inputCoords = new Vector3(inputX, inputY, 0);
            cam.unproject(inputCoords);

            if(playBtnRect.contains(inputCoords.x, inputCoords.y)){
                gsm.push(new PlayState(gsm));
            }
        }
    }

    @Override
    public void update(float dt) {
        if(Gdx.input.isTouched()){
            handleInput();
        }
    }

    @Override
    public void render(SpriteBatch sb){
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(playBtn, playBtnX, playBtnY);
        sb.end();
    }

    @Override
    public void dispose() {
        playBtn.dispose();
    }
}
