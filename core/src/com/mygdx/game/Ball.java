package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.CircleShape;

/**
 * Created by lena- on 26.01.2018.
 */


public class Ball {
  //  private static final int MOVEMENT = 100;

    private Vector3 ballPos;
    private Vector3 ballVel;
    private Rectangle bounds;
    private Texture texture;

    public Ball(int x, int y) {
        ballPos = new Vector3(x, y,0);
        ballVel = new Vector3(300,150,0);
        texture = new Texture("ball.png");
        bounds = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
    }

    public void update(float dt) {
        ballVel.scl(dt);
        ballPos.add(ballVel.x, ballVel.y, 0);
        if(ballPos.y < 0 || ballPos.y > Gdx.graphics.getHeight() - texture.getHeight()) {
            ballVel.y = -ballVel.y;
        }
        ballVel.scl(1/dt);
        bounds.setPosition(ballPos.x, ballPos.y);
    }

    public void bounce(){
        ballVel.x = -ballVel.x;
    }

    public Vector3 getBallPos() {
        return ballPos;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void dispose() {
        texture.dispose();
    }

    public Texture getTexture(){ return texture; }

    public boolean collides(Rectangle paddle){
        if(paddle.overlaps(bounds)){
            ballVel.scl((float) 1.06);
            return true;
        }
        else{ return false;}
    }

    public void scored(int direction, int x, int y){
        ballPos = new Vector3(x, y,0);
        //direction = 1 eller -1
        ballVel = new Vector3(200*direction,100,0);
    }


}
