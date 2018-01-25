package com.mygdx.game;

import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.states.State;

/**
 * Created by jonas on 25/01/2018.
 */

public class ManualPaddleController implements PaddleController {
    int pointer;
    State state;


    public ManualPaddleController(int pointer, State state){
        this.pointer = pointer;
        this.state = state;
    }

    public void setPointer(int newPointer){
        this.pointer = newPointer;
    }

    @Override
    public Vector3 movePaddle() {
        return null;
    }
}
