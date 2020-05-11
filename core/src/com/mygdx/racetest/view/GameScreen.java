package com.mygdx.racetest.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.racetest.model.Car;

public class GameScreen implements Screen {

    private Texture texture;
    private SpriteBatch batch;
    private Car car;

    @Override
    public void show() {
        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("rival.png"));
        car = new Car(texture, 0, 0, 100, 206);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1,1); // Определение цвета фона
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);// Очистка экрана
        batch.begin(); // Начало отрисовки
        car.draw(batch);
        batch.end(); // Конец отрисовки
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        texture.dispose();
        batch.dispose();
    }
}
