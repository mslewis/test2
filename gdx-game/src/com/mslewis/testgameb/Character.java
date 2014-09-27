package com.mslewis.testgameb;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by mslewis on 9/7/14.
 */
public class Character extends Actor {
    Tile location;
    Vector2 velocity;
    Vector2 position;
    Tile target;
    Texture texture;

    public Character(Tile start)
    {
        location = start;
        position = new Vector2(location.posx, location.posy);
        texture = new Texture(Gdx.files.internal("char.png"));
    }

    @Override
    public void act(float delta)
    {
        if(null == velocity)
            return;

        position.mulAdd(velocity, delta);
        if(Helper.isBetween(target.posx, position.x-velocity.x, position.x) || Helper.isBetween(target.posy,
                position.y-velocity.y, position.y))
        {
            //target reached
            location = target;
            position = new Vector2(location.posx, location.posy);
            target = null;
            velocity = null;
        }
    }

    public boolean isMoving()
    {
        return velocity!=null;
    }

    public void setTarget(Tile target)
    {
        this.target = target;
        this.velocity = new Vector2(target.posx,target.posy).sub(position);
    }

    @Override
    public void draw(Batch batch, float alpha)
    {
        batch.draw(texture, position.x-25, position.y-25, 50, 50);

    }
}
