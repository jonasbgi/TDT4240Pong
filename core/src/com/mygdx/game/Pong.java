package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.states.GameStateManager;
import com.mygdx.game.states.MenuState;

public class Pong extends ApplicationAdapter {
	//public static final int WIDTH = Gdx.graphics.getWidth();
	//public static final int HEIGHT = Gdx.graphics.getHeight();
	public static final String title = "Pong";
	private SpriteBatch sb;
	private Texture img;

	private GameStateManager gsm = GameStateManager.getGsm();

	@Override
	public void create () {
		sb = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		gsm.push(new MenuState());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(sb);
	}
	
	@Override
	public void dispose () {
		sb.dispose();
		img.dispose();
	}

}
