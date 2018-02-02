package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by jonas on 29/01/2018.
 */

public class EndState extends State {
    private String winner;
    private BitmapFont scrrenText;

    protected EndState() {
        super();
        cam.setToOrtho(false);
        scrrenText = new BitmapFont();
        scrrenText.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        winner = "Default";
    }

    public void setWinner(String winner){
        this.winner = winner;
    }

    @Override
    protected void handleInput() {
        //Clears GSM states and restarts game
        if(Gdx.input.justTouched()){
            while(gsm.hasStates()){
                gsm.pop();
            }
            gsm.push(new MenuState());
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        scrrenText.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        scrrenText.draw(sb, winner + " won! Click screen to restart",
                200, 200);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
