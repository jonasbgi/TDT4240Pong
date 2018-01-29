package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.states.PlayState;
import com.mygdx.game.states.State;

/**
 * Created by jonas on 25/01/2018.
 */

public class ManualPaddleController implements PaddleController {
    int pointer;
    PlayState playState;
    Camera cam;


    public ManualPaddleController(int pointer, PlayState state, Camera cam){
        this.pointer = pointer;
        this.playState = state;
        this.cam = cam;
    }

    public void setPointer(int newPointer){
        this.pointer = newPointer;
    }

    @Override
    public float movePaddle(float oldY, float dt) {
        Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        cam.unproject(touchPos);
        return touchPos.y;
    }
}
