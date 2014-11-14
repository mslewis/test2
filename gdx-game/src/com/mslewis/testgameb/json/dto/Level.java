package com.mslewis.testgameb.json.dto;

import com.badlogic.gdx.utils.Array;
import com.mslewis.testgameb.Tile;

import java.util.ArrayList;

/**
 * Created by mslewis on 9/22/14.
 */
public class Level {
    public ArrayList<Tile> tiles;

    public Level(){
        tiles = new ArrayList<Tile>();
    }
}
