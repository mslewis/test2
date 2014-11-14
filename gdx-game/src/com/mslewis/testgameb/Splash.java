package com.mslewis.testgameb;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by mslewis on 10/1/14.
 */
public class Splash implements Screen {
    private Texture texture = new Texture(Gdx.files.internal("img/Turntable.png"));
    private Image splashImage = new Image(texture);
    private Stage stage = new Stage();

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0,0,0,1); //sets clear color to black
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //clear the batch
        stage.act(); //update all actors
        stage.draw(); //draw all actors on the Stage.getBatch()

    }

    @Override
    public void resize(int i, int i2) {

    }

    @Override
    public void show() {
        stage.addActor(splashImage);
    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
