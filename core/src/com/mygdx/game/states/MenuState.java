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
        playBtn = new Texture("btnPlay.png");

        playBtnX = (Gdx.graphics.getWidth() / 2) - playBtn.getWidth()/2;
        playBtnY = 0; //Height is 480 px, screen is currently 480 px
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(playBtn, playBtnX, playBtnY);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
