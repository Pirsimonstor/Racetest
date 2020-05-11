package com.mygdx.racetest.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.racetest.model.Car;

public class GameScreen implements Screen {

    private Texture texture;
    private SpriteBatch batch;
    private Car car;
    private OrthographicCamera camera;
    public static float deltaCff;


    @Override
    public void show() {
        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("rival.png"));
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        car = new Car(texture, 0, 0, 1f, 1f*2);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1,1); // Определение цвета фона
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);// Очистка экрана
        deltaCff = delta;

        batch.setProjectionMatrix(camera.combined);
        batch.begin(); // Начало отрисовки
        car.draw(batch);
        batch.end(); // Конец отрисовки
    }

    @Override
    public void resize(int width, int height) {
        float aspectRatio = (float) height/width;
        camera = new OrthographicCamera(20, 20*aspectRatio);
        camera.zoom = 0.6f;
        camera.update();
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
