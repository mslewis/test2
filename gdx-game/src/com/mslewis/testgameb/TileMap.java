package com.mslewis.testgameb;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.JsonWriter;
import com.mslewis.testgameb.json.dto.Level;
import com.mslewis.testgameb.json.dto.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mslewis on 9/7/14.
 */
public class TileMap {
    List<Tile> tiles;
    float edge = GameConstants.tileEdge;
    Stage stage;
    String debug = "";

    public TileMap(Stage stage,int columns, int rows)
    {
        this.stage = stage;
        tiles = new ArrayList<Tile>();
        for(int i=1; i<=rows;i++)
        {
            for( int j=1; j<=columns; j++)
            {
                Tile tile = new Tile((i*edge)+5, (float)(j*edge), (float)(edge-10f), (float)(edge-10f), "image");
                tiles.add(tile);
                stage.addActor(tile);
            }
        }

    }

    public TileMap(Stage stage, String jsonfile)
    {
        this.stage = stage;
        try
        {
            Json json = new Json();
            json.setTypeName(null);
            json.setUsePrototypes(false);
            json.setIgnoreUnknownFields(true);
            json.setOutputType(JsonWriter.OutputType.json);
            String levelJson = Gdx.files.internal(jsonfile).readString();
            Level level = json.fromJson(Level.class, levelJson);
            buildTiles(level);
        } catch(Exception e)
        {
            debug = e.getMessage();
        }
    }

    private void buildTiles(Level level)
    {
        tiles = new ArrayList<Tile>(level.tiles.size());
        for(Tile tile: level.tiles)
        {
            tiles.add(tile);
            tile.setBounds();
            this.stage.addActor(tile);
        }

    }

    public CharSequence getDebugText()
    {
        return debug;
    }
}
