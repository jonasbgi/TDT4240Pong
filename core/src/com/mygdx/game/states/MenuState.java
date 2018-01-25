package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by jonas on 25/01/2018.
 */

public class MenuState extends State {
    Texture playBtn;
    int playBtnX;
    int playBtnY;
    public MenuState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(true);
        playBtn = new Texture("btnPlay.png");

        playBtnX = Gdx.graphics.getWidth()/2 - playBtn.getWidth()/2;
        playBtnY = Gdx.graphics.getHeight()/2 - playBtn.getHeight()/2;
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        if(Gdx.input.justTouched()){
            System.out.println(dt);
        }
    }

    @Override
    public void render(SpriteBatch sb) {
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
