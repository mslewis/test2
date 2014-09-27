package com.mslewis.testgameb;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MyGdxGame implements ApplicationListener
{
	//Texture texture;
	SpriteBatch batch;
    ShapeRenderer gridRender;
    TileMap map;
    OrthographicCamera camera;
    BitmapFont font;
    Character act;
    int tileIter = 0;
    Stage stage;
    Viewport vport;


	@Override
	public void create()
	{
		//texture = new Texture(Gdx.files.internal("android.jpg"));
		batch = new SpriteBatch();
        font = new BitmapFont();
        font.setScale(GameConstants.fontScale);
        font.setColor(Color.BLACK);
        gridRender = new ShapeRenderer();
        camera = new OrthographicCamera();
        configureCamera();
        vport = new ScreenViewport(camera);
        stage = new Stage(vport);
        map = new TileMap(stage,"maps/map.json");
        act = new Character(map.tiles.get(0));
        stage.addActor(act);
        Gdx.input.setInputProcessor(stage);
        stage.addListener(new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                if(event.getTarget() instanceof Tile)
                {
                    Tile target = (Tile)event.getTarget();
                    act.setTarget(target);
                }

                return true;
            }
        });


	}

	@Override
	public void render()
	{        
	    Gdx.gl.glClearColor(1, 1, 1, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        gridRender.setProjectionMatrix(camera.combined);
        batch.begin();
        font.draw(batch, map.getDebugText(), 10, Gdx.graphics.getHeight());
        batch.end();
        stage.draw();
        act.act(Gdx.graphics.getDeltaTime());
//        if(Gdx.input.isTouched() && !act.isMoving())
//        {
//            tileIter++;
//            if(tileIter>=map.tiles.size())
//                tileIter=0;
//            act.setTarget(map.tiles.get(tileIter));
//        }
//        else
//        {
//            act.move();
//        }
	}

	@Override
	public void dispose()
	{
        gridRender.dispose();
        batch.dispose();
        stage.dispose();
	}

	@Override
	public void resize(int width, int height)
	{
	}

	@Override
	public void pause()
	{
	}

	@Override
	public void resume()
	{
	}

    public void configureCamera()
    {
        float size = 800;
        if(Gdx.graphics.getHeight() < Gdx.graphics.getWidth())
            camera.setToOrtho(false, size, size*Gdx.graphics.getHeight() / Gdx.graphics.getWidth());
        else
            camera.setToOrtho(false, size*Gdx.graphics.getWidth()/Gdx.graphics.getHeight(), size);
    }
}