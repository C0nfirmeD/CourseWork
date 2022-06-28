package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Player {
    private Vector2 position;
    private Texture texture;
    private int size;

    public Player(int width, int height) {
        this.size = Math.min(Gdx.graphics.getWidth()/width, Gdx.graphics.getHeight()/height);
        this.position = new Vector2(0,0);
        texture = new Texture("smile1.png");
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y, size, size);
    }

    public void update() {

    }
}
