package com.mygdx.game;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.states.PlayState;

/**
 * Created by jonas on 25/01/2018.
 */

public class PongInputHandler implements InputProcessor {
    public int rightPointer;
    public int leftPointer;

    private Rectangle leftHalf;
    private Rectangle rightHalf;

    public PongInputHandler(Rectangle left, Rectangle right){
        rightPointer = -1;
        leftPointer = -1;

        this.leftHalf = left;
        this.rightHalf = right;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(rightPointer == -1 && rightHalf.contains(screenX, screenY)){
            rightPointer = pointer;
            System.out.println("Right pointer active");
        }
        else if(leftPointer == -1 && leftHalf.contains(screenX, screenY)){
            leftPointer = pointer;
            System.out.println("Left pointer active");
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(pointer == rightPointer){
            rightPointer = -1;
            System.out.println("Right pointer inactive");
        }
        else if(pointer == leftPointer){
            leftPointer = -1;
            System.out.println("Left pointer inactive");
        }
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
