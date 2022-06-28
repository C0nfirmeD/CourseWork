package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import sun.jvm.hotspot.utilities.HeapGXLWriter;

import java.util.concurrent.RecursiveTask;

public class Field {

    private int height;
    private int width;
    private Block[][] table; //таблица значей ячейки с координатами x, y
    private Texture txWhite, txGreen, txBlue;

    class Block {
        private Vector2 position;
        private Texture tx;
        private int pixel;
        private boolean isPainted;

        public Block(Vector2 position, int pixel) {
            this.position = position;
            this.pixel = pixel;
            tx = txWhite;
        }

        public void setPixel(int pixel) {
            this.pixel = pixel;
        }

    }

    public Field(int width, int height) {
        this.txWhite = new Texture("white_block.png");
        this.txGreen = new Texture("green_block.png");
        this.txBlue = new Texture("blue_block.png");

        this.height = height;
        this.width = width;
        this.table = new Block[width][height];

        int size = Math.min(Gdx.graphics.getWidth()/width, Gdx.graphics.getHeight()/height);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                table[i][j] = new Block(new Vector2(i*size,j*size), size);
                table[i][j].isPainted = false;
            }
        }
    }

    public void paint(Vector2 pos) {
        table[(int) pos.x][(int) pos.y].isPainted = true;
    }
    public void render(SpriteBatch batch) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Block block = table[i][height-1 - j];
                batch.draw(block.tx, block.position.x, block.position.y, block.pixel, block.pixel);
            }
        }
    }

    public void update() {
        try {
            if (Gdx.input.isTouched()) {

                int size = table[0][0].pixel;
                Block block = table[(Gdx.input.getX())/size][(Gdx.graphics.getHeight()-Gdx.input.getY())/size];
                if (!block.isPainted) {
                    block.tx = txGreen;
                    block.isPainted = true;
                }

            }

        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }


    //чет не то
    public void updatePixels() {
        int size = Math.min(Gdx.graphics.getWidth() / width, Gdx.graphics.getHeight() / height);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                table[i][j].setPixel(size);
            }
        }
    }


}
