package com.mslewis.testgameb;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.mslewis.testgameb.json.dto.TileConnect;

import java.util.ArrayList;

/**
 * Created by mslewis on 9/7/14.
 */
public class Tile extends Actor {

    enum State{
        normal,
        highlightedMove,
        highlightedAttack

    }
    public int id;
    public int posx;
    public int posy;
    float width=GameConstants.tileEdge;
    float height = GameConstants.tileEdge;
    public ArrayList<TileConnect> neighbors;

    public Texture getTexture() {
        if(texture==null)
            texture = new Texture(image);

        return texture;
    }

    Texture texture;
    public String image;

    public Tile()
    {
        posx =0;
        posy =0;
        neighbors = new ArrayList<TileConnect>();
        texture = new Texture("Stone.jpg");
    }

    public Tile(float locx, float locy, float width, float height, String filepath)
    {

        posx =(int)locx;
        posy =(int)locy;
        this.width = width;
        this.height = height;
        neighbors = new ArrayList<TileConnect>();
        texture = new Texture(Gdx.files.internal(filepath));
    }

    public void draw(Batch batch, float alpha)
    {
        batch.draw(getTexture(), posx-width/2, posy-height/2, width, height);
    }


    public void setBounds()
    {
        this.setBounds(posx-width/2, posy-height/2, width, height);
        this.setTouchable(Touchable.enabled);
    }
}
