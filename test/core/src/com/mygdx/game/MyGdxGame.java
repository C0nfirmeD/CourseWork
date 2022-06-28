package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Field field;
	Player player;

	public static MyGdxGame self() {
		return (MyGdxGame) Gdx.app.getApplicationListener();
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		field = new Field(21, 21);
		player = new Player(21,  21);
		//img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		update();
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		field.render(batch);
		player.render(batch);
		batch.end();
	}

	public void update() {
		field.update();
		player.update();
//		int oldHeight =0;
//		int oldWight =0;
//		if (Gdx.graphics.getHeight() != oldHeight || Gdx.graphics.getWidth() != oldWight)
//			field.updatePixels();
//		oldHeight = Gdx.graphics.getHeight();
//		oldWight = Gdx.graphics.getWidth();
	}

	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
