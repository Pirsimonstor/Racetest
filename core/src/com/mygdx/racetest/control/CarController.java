package com.mygdx.racetest.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.mygdx.racetest.view.GameScreen;

public class CarController {

    private Polygon carBounds;

    public CarController (Polygon carBounds){
        this.carBounds = carBounds;

    }
    float speed;
    float velocity = 2f;
    float bracke = 4f;
    float speedMax = 30f;
    float rotationSpeed = 20f;

    public void handle(){
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            speed += velocity * GameScreen.deltaCff;
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            speed -= velocity * GameScreen.deltaCff;
        else
            downSpeed();

        speed = sliceSpeed();

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            carBounds.rotate(-rotationSpeed* speed * GameScreen.deltaCff);
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) )
            carBounds.rotate(rotationSpeed* speed * GameScreen.deltaCff);


        carBounds.setPosition(carBounds.getX() + MathUtils.cosDeg(carBounds.getRotation() + 90) * speed * GameScreen.deltaCff,
                                 carBounds.getY() + MathUtils.sinDeg(carBounds.getRotation() + 90 )* speed * GameScreen.deltaCff);
    }

    private void downSpeed() {
        if ( speed > velocity * GameScreen.deltaCff)
            speed -= bracke * GameScreen.deltaCff;
        else if (speed < -velocity * GameScreen.deltaCff)
            speed += bracke * GameScreen.deltaCff;
        else speed = 0f;

    }

    private float sliceSpeed() {
        if (speed > speedMax)
            return speedMax ;
        else if (speed < -speedMax)
            return -speedMax;

        return speed;
    }
}
